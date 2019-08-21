// Generated code from Butter Knife. Do not modify!
package org.sagebionetworks.research.motor_control_module.show_step_fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.sagebionetworks.research.motor_control_module.R;
import org.sagebionetworks.research.motor_control_module.widget.TapCountResultView;

public class TappingCompletionStepViewBinding$TappingCompletionStepViewHolder_ViewBinding implements Unbinder {
  private TappingCompletionStepViewBinding.TappingCompletionStepViewHolder target;

  @UiThread
  public TappingCompletionStepViewBinding$TappingCompletionStepViewHolder_ViewBinding(
      TappingCompletionStepViewBinding.TappingCompletionStepViewHolder target, View source) {
    this.target = target;

    target.leftResult = Utils.findRequiredViewAsType(source, R.id.tapping_completion_left_result, "field 'leftResult'", TapCountResultView.class);
    target.rightResult = Utils.findRequiredViewAsType(source, R.id.tapping_completion_right_result, "field 'rightResult'", TapCountResultView.class);
    target.timeLabel = Utils.findRequiredViewAsType(source, R.id.tapping_completion_time_label, "field 'timeLabel'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TappingCompletionStepViewBinding.TappingCompletionStepViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftResult = null;
    target.rightResult = null;
    target.timeLabel = null;
  }
}
