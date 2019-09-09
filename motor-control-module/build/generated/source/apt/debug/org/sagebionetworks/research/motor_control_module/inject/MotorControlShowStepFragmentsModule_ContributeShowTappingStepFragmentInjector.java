package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.tapping.ShowTappingStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowTappingStepFragmentInjector
          .ShowTappingStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowTappingStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowTappingStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowTappingStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowTappingStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowTappingStepFragmentSubcomponent
      extends AndroidInjector<ShowTappingStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowTappingStepFragment> {}
  }
}
