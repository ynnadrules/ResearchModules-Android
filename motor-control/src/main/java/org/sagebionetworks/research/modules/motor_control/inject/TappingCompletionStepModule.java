package org.sagebionetworks.research.modules.motor_control.inject;

import org.sagebionetworks.research.domain.inject.StepModule.StepClassKey;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepModule.ShowStepFragmentFactory;
import org.sagebionetworks.research.mobile_ui.inject.ShowStepModule.StepViewKey;
import org.sagebionetworks.research.modules.motor_control.show_step_fragment.ShowTappingCompletionStepFragment;
import org.sagebionetworks.research.modules.motor_control.show_step_view_model.ShowTappingCompletionStepViewModelFactory;
import org.sagebionetworks.research.modules.motor_control.step.AppStepType;
import org.sagebionetworks.research.modules.motor_control.step.TappingCompletionStep;
import org.sagebionetworks.research.modules.motor_control.step_view.TappingCompletionStepView;
import org.sagebionetworks.research.presentation.inject.ShowStepViewModelModule.StepViewClassKey;
import org.sagebionetworks.research.presentation.inject.StepViewModule.InternalStepViewFactory;
import org.sagebionetworks.research.presentation.inject.StepViewModule.StepTypeKey;
import org.sagebionetworks.research.presentation.model.interfaces.StepView;
import org.sagebionetworks.research.presentation.show_step.show_step_view_model_factories.ShowStepViewModelFactory;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class TappingCompletionStepModule {
    @Provides
    @IntoMap
    @StepViewKey(TappingCompletionStepView.TYPE)
    static ShowStepFragmentFactory provideTappingCompletionStepFragmentFactory() {
        return ShowTappingCompletionStepFragment::newInstance;
    }

    @Provides
    @IntoMap
    @StepViewClassKey(TappingCompletionStepView.TYPE)
    static ShowStepViewModelFactory<?, ? extends StepView> provideTappingCompletionStepVMF() {
        return new ShowTappingCompletionStepViewModelFactory();
    }

    @Provides
    @IntoMap
    @StepClassKey(TappingCompletionStep.class)
    static String provideTappingCompletionStepTypeKey() {
        return TappingCompletionStep.TYPE_KEY;
    }

    @Provides
    @IntoMap
    @StepTypeKey(AppStepType.TAPPING_COMPLETION)
    static InternalStepViewFactory provideTappingCompletionStepViewFactory() {
        return TappingCompletionStepView::fromTappingCompletionStep;
    }
}
