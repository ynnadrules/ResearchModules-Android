// Generated code from Butter Knife. Do not modify!
package org.sagebionetworks.research.motor_control_module.step_binding;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import org.sagebionetworks.research.mobile_ui.R;
import org.sagebionetworks.research.motor_control_module.widget.DisablableScrollView;

public class OverviewStepViewBinding$OverviewStepViewHolder_ViewBinding implements Unbinder {
  private OverviewStepViewBinding.OverviewStepViewHolder target;

  @UiThread
  public OverviewStepViewBinding$OverviewStepViewHolder_ViewBinding(
      OverviewStepViewBinding.OverviewStepViewHolder target, View source) {
    this.target = target;

    target.overallIconDescriptionLabel = Utils.findRequiredViewAsType(source, R.id.overallIconDescriptionLabel, "field 'overallIconDescriptionLabel'", TextView.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'scrollView'", DisablableScrollView.class);
    target.iconImageViews = Utils.listFilteringNull(
        Utils.findRequiredViewAsType(source, R.id.centerIconImageView, "field 'iconImageViews'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.leftIconImageView, "field 'iconImageViews'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.rightIconImageView, "field 'iconImageViews'", ImageView.class));
    target.iconLabels = Utils.listFilteringNull(
        Utils.findRequiredViewAsType(source, R.id.centerIconLabel, "field 'iconLabels'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.leftIconLabel, "field 'iconLabels'", TextView.class), 
        Utils.findRequiredViewAsType(source, R.id.rightIconLabel, "field 'iconLabels'", TextView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    OverviewStepViewBinding.OverviewStepViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.overallIconDescriptionLabel = null;
    target.scrollView = null;
    target.iconImageViews = null;
    target.iconLabels = null;
  }
}
