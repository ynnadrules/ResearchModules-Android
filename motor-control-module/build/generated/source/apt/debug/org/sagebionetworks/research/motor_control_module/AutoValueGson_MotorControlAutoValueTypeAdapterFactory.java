package org.sagebionetworks.research.motor_control_module;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.Override;
import java.lang.SuppressWarnings;
import org.sagebionetworks.research.motor_control_module.result.TappingResult;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.tapping.TappingSample;
import org.sagebionetworks.research.motor_control_module.step.Icon;
import org.sagebionetworks.research.motor_control_module.step.InstructionStep;
import org.sagebionetworks.research.motor_control_module.step.MPowerActiveUIStep;
import org.sagebionetworks.research.motor_control_module.step.MtcCountdownStep;
import org.sagebionetworks.research.motor_control_module.step.TappingCompletionStep;
import org.sagebionetworks.research.motor_control_module.step.TappingStep;

public final class AutoValueGson_MotorControlAutoValueTypeAdapterFactory extends MotorControlAutoValueTypeAdapterFactory {
  @Override
  @SuppressWarnings("unchecked")
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    Class<?> rawType = type.getRawType();
    if (Icon.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) Icon.typeAdapter(gson);
    } else if (InstructionStep.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) InstructionStep.typeAdapter(gson);
    } else if (MPowerActiveUIStep.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) MPowerActiveUIStep.typeAdapter(gson);
    } else if (MtcCountdownStep.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) MtcCountdownStep.typeAdapter(gson);
    } else if (TappingCompletionStep.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) TappingCompletionStep.typeAdapter(gson);
    } else if (TappingResult.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) TappingResult.typeAdapter(gson);
    } else if (TappingSample.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) TappingSample.typeAdapter(gson);
    } else if (TappingStep.class.isAssignableFrom(rawType)) {
      return (TypeAdapter<T>) TappingStep.typeAdapter(gson);
    } else {
      return null;
    }
  }
}
