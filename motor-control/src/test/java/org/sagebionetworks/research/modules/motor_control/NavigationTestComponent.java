package org.sagebionetworks.research.modules.motor_control;

import org.sagebionetworks.research.domain.inject.TaskModule;
import org.sagebionetworks.research.domain.task.navigation.StepNavigatorFactory;

import dagger.Component;

@Component(modules = TaskModule.class)
public interface NavigationTestComponent {
    StepNavigatorFactory stepNavigatorFactory();
}
