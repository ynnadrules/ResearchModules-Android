package org.sagebionetworks.research.motor_control_module.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepFragmentScope;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.ShowCompletionStepFragment;

@Module(
  subcomponents =
      MotorControlShowStepFragmentsModule_ContributeShowCompletionStepFragmentInjector
          .ShowCompletionStepFragmentSubcomponent.class
)
public abstract
class MotorControlShowStepFragmentsModule_ContributeShowCompletionStepFragmentInjector {
  private MotorControlShowStepFragmentsModule_ContributeShowCompletionStepFragmentInjector() {}

  @Binds
  @IntoMap
  @ClassKey(ShowCompletionStepFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ShowCompletionStepFragmentSubcomponent.Builder builder);

  @Subcomponent
  @ShowStepFragmentScope
  public interface ShowCompletionStepFragmentSubcomponent
      extends AndroidInjector<ShowCompletionStepFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ShowCompletionStepFragment> {}
  }
}
