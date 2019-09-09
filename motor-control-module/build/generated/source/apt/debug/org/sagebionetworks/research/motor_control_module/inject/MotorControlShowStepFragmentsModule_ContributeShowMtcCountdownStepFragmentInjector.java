package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.MtcCountdownStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowMtcCountdownStepFragmentInjector
          .MtcCountdownStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowMtcCountdownStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowMtcCountdownStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(MtcCountdownStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MtcCountdownStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface MtcCountdownStepFragmentSubcomponent
      extends AndroidInjector<MtcCountdownStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MtcCountdownStepFragment> {}
  }
}
