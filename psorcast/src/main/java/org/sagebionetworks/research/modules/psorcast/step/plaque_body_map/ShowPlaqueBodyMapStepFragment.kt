/*
 * BSD 3-Clause License
 *
 * Copyright 2019  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.modules.psorcast.step.plaque_body_map

import android.arch.lifecycle.Observer
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.os.Environment
import android.support.annotation.NonNull
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.srpm_show_plaque_body_step_fragment.plaque_coverage_view_back
import kotlinx.android.synthetic.main.srpm_show_plaque_body_step_fragment.plaque_coverage_view_front
import kotlinx.android.synthetic.main.srpm_show_plaque_body_step_fragment.toggle_button
import kotlinx.android.synthetic.main.srpm_show_plaque_body_step_fragment.view.plaque_coverage_view_front
import org.sagebionetworks.research.domain.result.implementations.ResultBase
import org.sagebionetworks.research.mobile_ui.show_step.view.ShowStepFragmentBase
import org.sagebionetworks.research.mobile_ui.show_step.view.ShowUIStepFragmentBase
import org.sagebionetworks.research.mobile_ui.show_step.view.view_binding.UIStepViewBinding
import org.sagebionetworks.research.mobile_ui.widget.ActionButton
import org.sagebionetworks.research.modules.psorcast.R
import org.sagebionetworks.research.presentation.model.action.ActionType
import org.sagebionetworks.research.presentation.model.interfaces.StepView
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.threeten.bp.Instant
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Random

class ShowPlaqueBodyMapStepFragment :
        ShowUIStepFragmentBase<PlaqueBodyMapStepView, ShowPlaqueBodyMapStepViewModel, UIStepViewBinding<PlaqueBodyMapStepView>>() {

    //private val builder = this.showStepViewModel.pdResultBuilder
    private val above_waist_front_id = R.drawable.above_waist_front_blurred
    private val above_waist_back_id = R.drawable.above_waist_back_blurred

    companion object {
        @JvmStatic
        fun newInstance(@NonNull stepView: StepView): ShowPlaqueBodyMapStepFragment {
            val fragment = ShowPlaqueBodyMapStepFragment()
            val arguments = ShowStepFragmentBase.createArguments(stepView)
            fragment.arguments = arguments
            return fragment
        }
    }

    private var logger: Logger = LoggerFactory.getLogger(ShowPlaqueBodyMapStepFragment::class.java)

    override fun getLayoutId(): Int {
        return R.layout.srpm_show_plaque_body_step_fragment
    }

    override fun instantiateAndBindBinding(view: View?): UIStepViewBinding<PlaqueBodyMapStepView> {
        return UIStepViewBinding(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var result = super.onCreateView(inflater, container, savedInstanceState)

        // Observe the current view
        this.showStepViewModel.isFront().observe(this, Observer<Boolean> {front : Boolean? ->
            var front_ = if (front == null) true else front
            // Save a screenshot of the view before toggling to the other side
            updateBitmap(!front_)
            toggleView(front_)
        })

        return result
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the image sources
        val drawable_front = ContextCompat.getDrawable(context!!, above_waist_front_id)
        this.plaque_coverage_view_front.setImageDrawable(drawable_front)
        val drawable_back = ContextCompat.getDrawable(context!!, above_waist_back_id)
        this.plaque_coverage_view_back.setImageDrawable(drawable_back)

        // Create listener for toggle button - flip isFront on click
        this.toggle_button.setOnClickListener {
            this.showStepViewModel.front.value = !this.showStepViewModel.front.value!!
        }
    }

    override fun handleActionButtonClick(actionButton: ActionButton) {
        @ActionType val actionType = this.getActionTypeFromActionButton(actionButton)
        if (ActionType.FORWARD == actionType) {
            setPaths()
        }
        super.handleActionButtonClick(actionButton)
    }

    fun toggleView(front: Boolean) {
        if (front) {
            this.plaque_coverage_view_front.visibility = View.VISIBLE
            this.plaque_coverage_view_back.visibility = View.INVISIBLE
        } else {
            this.plaque_coverage_view_front.visibility = View.INVISIBLE
            this.plaque_coverage_view_back.visibility = View.VISIBLE
        }
    }

    private fun setPaths() {
        this.showStepViewModel.pdResultBuilder.setFrontPaths(this.plaque_coverage_view_front.getPaths())
        this.showStepViewModel.pdResultBuilder.setBackPaths(this.plaque_coverage_view_back.getPaths())
    }

    private fun updateBitmap(wasFront: Boolean) {
        val v = view as View
        val width = v.plaque_coverage_view_front.width
        val height = v.plaque_coverage_view_front.height
        if (width > 0 && height > 0) {
            val bitmap = loadBitmapFromView(v, width, height)
            if (wasFront) {
                this.showStepViewModel.pdResultBuilder.setFrontBitmap(bitmap)
            } else {
                this.showStepViewModel.pdResultBuilder.setBackBitmap(bitmap)
            }
        }
    }

    private fun loadBitmapFromView(v: View, width: Int, height: Int): Bitmap {
        var b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var c = Canvas(b)
        v.layout(0, 0, width, height)
        v.draw(c)
        return b
    }

//    private fun saveImage(bitmap: Bitmap) {
//        val outputDirectory = getOutputDirectory(context!!)
//        val file = createFile(outputDirectory, "yyyy-MM-dd-HH-mm-ss-SSS", ".jpeg")
//        if (file.exists())
//            file.delete()
//        try {
//            val out = FileOutputStream(file)
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
//            out.flush()
//            out.close()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    private fun getOutputDirectory(context: Context): File {
//        val appContext = context.applicationContext
//        val mediaDir = if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
//            context.externalMediaDirs.firstOrNull()?.let {
//                File(it, appContext.resources.getString(R.string.app_name)).apply { mkdirs() } }
//        } else {
//            TODO("VERSION.SDK_INT < LOLLIPOP")
//        }
//        return if (mediaDir != null && mediaDir.exists())
//            mediaDir else appContext.filesDir
//    }
//
//    private fun createFile(baseFolder: File, format: String, extension: String): File {
//        return File(baseFolder,
//                SimpleDateFormat(format, Locale.US).format(System.currentTimeMillis()) + extension)
//    }
}
