package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.ShowTappingCompletionStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowTappingCompletionStepFragmentInjector
          .ShowTappingCompletionStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowTappingCompletionStepFragmentInjector {
  private
  MotorControlShowStepFragmentsModule_ContributeShowTappingCompletionStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowTappingCompletionStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowTappingCompletionStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowTappingCompletionStepFragmentSubcomponent
      extends AndroidInjector<ShowTappingCompletionStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowTappingCompletionStepFragment> {}
  }
}
