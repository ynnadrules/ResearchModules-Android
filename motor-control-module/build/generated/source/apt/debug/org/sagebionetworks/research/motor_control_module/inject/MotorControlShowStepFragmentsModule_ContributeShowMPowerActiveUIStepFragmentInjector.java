package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.ShowMPowerActiveUIStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowMPowerActiveUIStepFragmentInjector
          .ShowMPowerActiveUIStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowMPowerActiveUIStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowMPowerActiveUIStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowMPowerActiveUIStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowMPowerActiveUIStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowMPowerActiveUIStepFragmentSubcomponent
      extends AndroidInjector<ShowMPowerActiveUIStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowMPowerActiveUIStepFragment> {}
  }
}
