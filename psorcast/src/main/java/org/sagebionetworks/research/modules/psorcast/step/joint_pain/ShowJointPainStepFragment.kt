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
            var diam = 41f/411f * iv.measuredHeight

            var joints = getJoints((arguments!!.get("STEP_VIEW") as JointPainStepView).identifier)

            for (joint in joints) {
                var params = LayoutParams(diam.toInt(), diam.toInt())

                // Anchor the button to the imageview
                params.topToTop = iv.id
                params.leftToLeft = iv.id
                params.bottomToBottom = iv.id
                params.rightToRight = iv.id

                // Define the position of the button
                params.horizontalBias = newHorizontalBias(iv, joint.first)
                params.horizontalBias = adjustBias(params.horizontalBias, iv.measuredWidth.toFloat(), diam)
                params.verticalBias = joint.second
                params.verticalBias = adjustBias(params.verticalBias, iv.measuredHeight.toFloat(), diam)

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

    private fun adjustBias(bias: Float, length: Float, diam: Float): Float {
        return (bias*length - diam/2f)/(length - diam)
    }

    private fun newHorizontalBias(iv: ImageView, oldScale: Float) : Float {
        var viewWidth = iv.measuredWidth.toFloat()
        var imgRatio = iv.drawable.intrinsicWidth.toFloat()/iv.drawable.intrinsicHeight
        var imgWidth = imgRatio * iv.measuredHeight.toFloat()
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
            "leftHand" -> return leftHandJoints(widthScale, heightScale)
            "rightHand" -> return rightHandJoints(widthScale, heightScale)
            "leftFoot" -> return leftFootJoints(widthScale, heightScale)
            "rightFoot" -> return rightFootJoints(widthScale, heightScale)
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
        var wristHorizontal = 72.51f/widthScale // 72.5f Doesn't work -- NO IDEA WHY
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

    private fun leftHandJoints(widthScale: Float, heightScale: Float): HashSet<Pair<Float, Float>> {
        var leftHandJoints = HashSet<Pair<Float, Float>>()
        var thumb1Horizontal = 308f/widthScale
        var thumb1Vertical = 248.5f/heightScale
        leftHandJoints.add(Pair(thumb1Horizontal, thumb1Vertical))
        var thumb2Horizontal = 280.5f/widthScale
        var thumb2Vertical = 299.5f/heightScale
        leftHandJoints.add(Pair(thumb2Horizontal, thumb2Vertical))
        var thumb3Horizontal = 237.5f/widthScale
        var thumb3Vertical = 346.5f/heightScale
        leftHandJoints.add(Pair(thumb3Horizontal, thumb3Vertical))
        var finger11Horizontal = 246.5f/widthScale
        var finger11Vertical = 96.5f/heightScale
        leftHandJoints.add(Pair(finger11Horizontal, finger11Vertical))
        var finger12Horizontal = 232.5f/widthScale
        var finger12Vertical = 142.5f/heightScale
        leftHandJoints.add(Pair(finger12Horizontal, finger12Vertical))
        var finger13Horizontal = 217.5f/widthScale
        var finger13Vertical = 197.5f/heightScale
        leftHandJoints.add(Pair(finger13Horizontal, finger13Vertical))
        var finger21Horizontal = 185.01f/widthScale
        var finger21Vertical = 61.5f/heightScale
        leftHandJoints.add(Pair(finger21Horizontal, finger21Vertical))
        var finger22Horizontal = 178.53f/widthScale
        var finger22Vertical = 126.5f/heightScale
        leftHandJoints.add(Pair(finger22Horizontal, finger22Vertical))
        var finger23Horizontal = 170.97f/widthScale
        var finger23Vertical = 187.5f/heightScale
        leftHandJoints.add(Pair(finger23Horizontal, finger23Vertical))
        var finger31Horizontal = 121.96f/widthScale
        var finger31Vertical = 85.5f/heightScale
        leftHandJoints.add(Pair(finger31Horizontal, finger31Vertical))
        var finger32Horizontal = 121.5f/widthScale
        var finger32Vertical = 139.5f/heightScale
        leftHandJoints.add(Pair(finger32Horizontal, finger32Vertical))
        var finger33Horizontal = 123.5f/widthScale
        var finger33Vertical = 193.5f/heightScale
        leftHandJoints.add(Pair(finger33Horizontal, finger33Vertical))
        var finger41Horizontal = 52.5f/widthScale
        var finger41Vertical = 132.5f/heightScale
        leftHandJoints.add(Pair(finger41Horizontal, finger41Vertical))
        var finger42Horizontal = 64.5f/widthScale
        var finger42Vertical = 176.5f/heightScale
        leftHandJoints.add(Pair(finger42Horizontal, finger42Vertical))
        var finger43Horizontal = 78.5f/widthScale
        var finger43Vertical = 223.5f/heightScale
        leftHandJoints.add(Pair(finger43Horizontal, finger43Vertical))
        return leftHandJoints
    }

    private fun rightHandJoints(widthScale: Float, heightScale: Float): HashSet<Pair<Float, Float>> {
        var rightHandJoints = HashSet<Pair<Float, Float>>()
        var leftHandJoints = leftHandJoints(widthScale, heightScale)
        for (joint in leftHandJoints) {
            rightHandJoints.add(Pair(1f - joint.first, joint.second))
        }
        return rightHandJoints
    }

    private fun leftFootJoints(widthScale: Float, heightScale: Float): HashSet<Pair<Float, Float>> {
        var leftFootJoints = HashSet<Pair<Float, Float>>()
        var big1Horizontal = 294.5f/widthScale
        var big1Vertical = 64.5f/heightScale
        leftFootJoints.add(Pair(big1Horizontal, big1Vertical))
        var big2Horizontal = 293.5f/widthScale
        var big2Vertical = 131.5f/heightScale
        leftFootJoints.add(Pair(big2Horizontal, big2Vertical))
        var toe11Horizontal = 217.5f/widthScale
        var toe11Vertical = 70.5f/heightScale
        leftFootJoints.add(Pair(toe11Horizontal, toe11Vertical))
        var toe12Horizontal = 217.5f/widthScale
        var toe12Vertical = 132.5f/heightScale
        leftFootJoints.add(Pair(toe12Horizontal, toe12Vertical))
        var toe21Horizontal = 162.5f/widthScale
        var toe21Vertical = 90.5f/heightScale
        leftFootJoints.add(Pair(toe21Horizontal, toe21Vertical))
        var toe22Horizontal = 162.5f/widthScale
        var toe22Vertical = 144.5f/heightScale
        leftFootJoints.add(Pair(toe22Horizontal, toe22Vertical))
        var toe31Horizontal = 107.5f/widthScale
        var toe31Vertical = 108.5f/heightScale
        leftFootJoints.add(Pair(toe31Horizontal, toe31Vertical))
        var toe32Horizontal = 107.5f/widthScale
        var toe32Vertical = 162.5f/heightScale
        leftFootJoints.add(Pair(toe32Horizontal, toe32Vertical))
        var toe41Horizontal = 54.5f/widthScale
        var toe41Vertical = 138.5f/heightScale
        leftFootJoints.add(Pair(toe41Horizontal, toe41Vertical))
        var toe42Horizontal = 54.5f/widthScale
        var toe42Vertical = 189.5f/heightScale
        leftFootJoints.add(Pair(toe42Horizontal, toe42Vertical))
        var archHorizontal = 202.5f/widthScale
        var archVertical = 320.5f/heightScale
        leftFootJoints.add(Pair(archHorizontal, archVertical))
        return leftFootJoints
    }

    private fun rightFootJoints(widthScale: Float, heightScale: Float): HashSet<Pair<Float, Float>> {
        var rightFootJoints = HashSet<Pair<Float, Float>>()
        var leftFootJoints = leftFootJoints(widthScale, heightScale)
        for (joint in leftFootJoints) {
            rightFootJoints.add(Pair(1f - joint.first, joint.second))
        }
        return rightFootJoints
    }
}