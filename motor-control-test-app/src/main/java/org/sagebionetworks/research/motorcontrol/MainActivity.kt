package org.sagebionetworks.research.motorcontrol

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.tapping
import kotlinx.android.synthetic.main.activity_main.tremor
import kotlinx.android.synthetic.main.activity_main.walk_and_balance
import org.sagebionetworks.research.domain.repository.TaskRepository
import org.sagebionetworks.research.mobile_ui.perform_task.PerformTaskActivity
import org.sagebionetworks.research.motor_control_module.MotorControlTask.TAPPING
import org.sagebionetworks.research.motor_control_module.MotorControlTask.TREMOR
import org.sagebionetworks.research.motor_control_module.MotorControlTask.WALK_AND_BALANCE
import org.sagebionetworks.research.presentation.model.TaskView
import java.util.UUID
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var taskRepository: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapping.setOnClickListener {
            launchTask(TAPPING, UUID.randomUUID())
        }
        tremor.setOnClickListener {
            launchTask(TREMOR, UUID.randomUUID())
        }
        walk_and_balance.setOnClickListener {
            launchTask(WALK_AND_BALANCE, UUID.randomUUID())
        }
    }

    private fun launchTask(taskIdentifier: String,
            taskRunUUID: UUID?) {
        val taskInfoView = taskRepository.getTaskInfo(taskIdentifier).blockingGet()

        //TODO: mapper
        val taskView = TaskView.builder().setIdentifier(taskInfoView.identifier).build()

        val intent = PerformTaskActivity.createIntent(applicationContext, taskView, taskRunUUID)
        this.startActivity(intent)
    }
}
