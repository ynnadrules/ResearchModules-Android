package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.ShowOverviewStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowOverviewStepFragmentInjector
          .ShowOverviewStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowOverviewStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowOverviewStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowOverviewStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowOverviewStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowOverviewStepFragmentSubcomponent
      extends AndroidInjector<ShowOverviewStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowOverviewStepFragment> {}
  }
}
