package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.hand_selection.ShowHandSelectionStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowHandSelectionStepFragmentInjector
          .ShowHandSelectionStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowHandSelectionStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowHandSelectionStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowHandSelectionStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowHandSelectionStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowHandSelectionStepFragmentSubcomponent
      extends AndroidInjector<ShowHandSelectionStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowHandSelectionStepFragment> {}
  }
}
