package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.ShowInstructionStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowInstructionStepFragmentInjector
          .ShowInstructionStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowInstructionStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowInstructionStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowInstructionStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowInstructionStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowInstructionStepFragmentSubcomponent
      extends AndroidInjector<ShowInstructionStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowInstructionStepFragment> {}
  }
}
