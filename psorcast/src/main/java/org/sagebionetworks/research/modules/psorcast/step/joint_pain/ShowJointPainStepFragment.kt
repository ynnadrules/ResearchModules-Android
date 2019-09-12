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

package org.sagebionetworks.research.modules.psorcast.step.joint_pain

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sagebionetworks.research.mobile_ui.show_step.view.ShowStepFragmentBase
import org.sagebionetworks.research.mobile_ui.show_step.view.ShowUIStepFragmentBase
import org.sagebionetworks.research.mobile_ui.show_step.view.view_binding.UIStepViewBinding
import org.sagebionetworks.research.modules.psorcast.R
import org.sagebionetworks.research.presentation.model.interfaces.StepView
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import android.widget.ToggleButton
import org.sagebionetworks.research.modules.psorcast.R.drawable

class ShowJointPainStepFragment : ShowUIStepFragmentBase<JointPainStepView, ShowJointPainStepViewModel, UIStepViewBinding<JointPainStepView>>() {
    companion object {
        @JvmStatic
        fun newInstance(@NonNull stepView: StepView): ShowJointPainStepFragment {
            val fragment = ShowJointPainStepFragment()
            val arguments = ShowStepFragmentBase.createArguments(stepView)
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.srpm_show_joint_pain_step_fragment
    }

    override fun instantiateAndBindBinding(view: View?): UIStepViewBinding<JointPainStepView> {
        return UIStepViewBinding(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = super.onCreateView(inflater, container, savedInstanceState)
        if (v != null) {
            var viewTreeObserver = v.viewTreeObserver
            if (viewTreeObserver.isAlive) {
                viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        v.getViewTreeObserver().removeOnGlobalLayoutListener(this)
                        addButtons()
                    }
                })
            }
        }
        return v
    }

    private fun addButtons() {
        var iv = this.stepViewBinding.imageView
        if (view is ConstraintLayout && iv != null && arguments != null) {
            val diam = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, iv.measuredHeight.toFloat() / 27,
                    resources.displayMetrics).toInt()

            var joints = getJoints((arguments!!.get("STEP_VIEW") as JointPainStepView).identifier)

            for (joint in joints) {
                var params = LayoutParams(diam, diam)

                // Anchor the button to the imageview
                params.topToTop = iv.id
                params.leftToLeft = iv.id
                params.bottomToBottom = iv.id
                params.rightToRight = iv.id

                // Define the position of the button
                params.horizontalBias = newHorizontalBias(iv, joint.first)
                params.verticalBias = joint.second

                // Define button for this joint
                var button = ToggleButton(context)
                button.tag = ""
                button.layoutParams = params
                button.textOff = ""
                button.textOn = ""
                button.text = ""
                button.setBackgroundResource(drawable.srpm_joint_pain_toggle_button)

                (view as ConstraintLayout).addView(button)
            }
        }
    }

    private fun newHorizontalBias(iv: ImageView, oldScale: Float) : Float {
        var viewWidth = iv.measuredWidth
        var imgRatio = iv.drawable.intrinsicWidth.toFloat()/iv.drawable.intrinsicHeight
        var imgWidth = imgRatio * iv.measuredHeight
        var shift = (viewWidth - imgWidth)/2f
        var position = imgWidth * oldScale + shift
        var newScale = position/viewWidth
        return newScale
    }

    private fun getJoints(identifier: String) : HashSet<Pair<Float, Float>> {
        val widthScale = 375f
        val heightScale = 411f

        when(identifier)  {
            "upperBody" -> return upperBodyJoints(widthScale, heightScale)
            "lowerBody" -> return lowerBodyJoints(widthScale, heightScale)
            else -> return HashSet()
        }
    }

    private fun upperBodyJoints(widthScale: Float, heightScale: Float) : HashSet<Pair<Float, Float>> {
        var upperBodyJoints = HashSet<Pair<Float, Float>>()
        var shoulderHorizontal = 130.5f/widthScale
        var shoulderVertical = 130.5f/heightScale
        upperBodyJoints.add(Pair(shoulderHorizontal, shoulderVertical))
        upperBodyJoints.add(Pair(1f - shoulderHorizontal, shoulderVertical))
        var elbowHorizontal = 106.5f/widthScale
        var elbowVertical = 241.5f/heightScale
        upperBodyJoints.add(Pair(elbowHorizontal, elbowVertical))
        upperBodyJoints.add(Pair(1f - elbowHorizontal, elbowVertical))
        var wristHorizontal = 62.5f/widthScale
        var wristVertical = 319.5f/heightScale
        upperBodyJoints.add(Pair(wristHorizontal, wristVertical))
        upperBodyJoints.add(Pair(1f - wristHorizontal, wristVertical))
        return upperBodyJoints
    }

    private fun lowerBodyJoints(widthScale: Float, heightScale: Float): HashSet<Pair<Float, Float>> {
        var lowerBodyJoints = HashSet<Pair<Float, Float>>()
        var hipHorizontal = 133.5f/widthScale
        var hipVertical = 48.5f/heightScale
        lowerBodyJoints.add(Pair(hipHorizontal, hipVertical))
        lowerBodyJoints.add(Pair(1f - hipHorizontal, hipVertical))
        var kneeHorizontal = 147.5f/widthScale
        var kneeVertical = 201.5f/heightScale
        lowerBodyJoints.add(Pair(kneeHorizontal, kneeVertical))
        lowerBodyJoints.add(Pair(1f - kneeHorizontal, kneeVertical))
        var ankleHorizontal = 157.5f/widthScale
        var ankleVertical = 334.5f/heightScale
        lowerBodyJoints.add(Pair(ankleHorizontal, ankleVertical))
        lowerBodyJoints.add(Pair(1f - ankleHorizontal, ankleVertical))
        return lowerBodyJoints
    }
}