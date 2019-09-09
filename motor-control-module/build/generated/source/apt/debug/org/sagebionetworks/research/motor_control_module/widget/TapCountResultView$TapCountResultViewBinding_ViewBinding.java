// Generated code from Butter Knife. Do not modify!
package org.sagebionetworks.research.motor_control_module.widget;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.sagebionetworks.research.motor_control_module.R;

public class TapCountResultView$TapCountResultViewBinding_ViewBinding implements Unbinder {
  private TapCountResultView.TapCountResultViewBinding target;

  @UiThread
  public TapCountResultView$TapCountResultViewBinding_ViewBinding(
      TapCountResultView.TapCountResultViewBinding target, View source) {
    this.target = target;

    target.count = Utils.findRequiredViewAsType(source, R.id.tapping_completion_count, "field 'count'", TextView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.tapping_completion_description, "field 'description'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TapCountResultView.TapCountResultViewBinding target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.count = null;
    target.description = null;
  }
}
