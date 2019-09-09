// Generated code from Butter Knife. Do not modify!
package org.sagebionetworks.research.motor_control_module.show_step_fragment.tapping;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.sagebionetworks.research.mobile_ui.widget.ActionButton;
import org.sagebionetworks.research.motor_control_module.R;

public class TappingStepViewBinding$TappingStepViewHolder_ViewBinding implements Unbinder {
  private TappingStepViewBinding.TappingStepViewHolder target;

  @UiThread
  public TappingStepViewBinding$TappingStepViewHolder_ViewBinding(
      TappingStepViewBinding.TappingStepViewHolder target, View source) {
    this.target = target;

    target.leftTappingButton = Utils.findRequiredViewAsType(source, R.id.leftTappingButton, "field 'leftTappingButton'", ActionButton.class);
    target.rightTappingButton = Utils.findRequiredViewAsType(source, R.id.rightTappingButton, "field 'rightTappingButton'", ActionButton.class);
    target.tappingButtonView = Utils.findRequiredView(source, R.id.tappingButtonView, "field 'tappingButtonView'");
  }

  @Override
  @CallSuper
  public void unbind() {
    TappingStepViewBinding.TappingStepViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftTappingButton = null;
    target.rightTappingButton = null;
    target.tappingButtonView = null;
  }
}
