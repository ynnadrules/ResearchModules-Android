package org.sagebionetworks.research.motor_control_module.result;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.sagebionetworks.research.motor_control_module.show_step_fragment.tapping.TappingSample;
import org.threeten.bp.Instant;
import org.threeten.bp.ZonedDateTime;

final class AutoValue_TappingResult extends $AutoValue_TappingResult {
  AutoValue_TappingResult(String identifier, Instant startTime, int[] buttonBoundLeft,
      int[] buttonBoundRight, Instant endTime, int hitButtonCount,
      ImmutableList<TappingSample> samples, int[] stepViewSize, ZonedDateTime zonedEndTime,
      ZonedDateTime zonedStartTime) {
    super(identifier, startTime, buttonBoundLeft, buttonBoundRight, endTime, hitButtonCount, samples, stepViewSize, zonedEndTime, zonedStartTime);
  }

  public static final class GsonTypeAdapter extends TypeAdapter<TappingResult> {
    private volatile TypeAdapter<String> string_adapter;
    private volatile TypeAdapter<Instant> instant_adapter;
    private volatile TypeAdapter<int[]> array__int_adapter;
    private volatile TypeAdapter<Integer> int__adapter;
    private volatile TypeAdapter<ImmutableList<TappingSample>> immutableList__tappingSample_adapter;
    private volatile TypeAdapter<ZonedDateTime> zonedDateTime_adapter;
    private final Gson gson;
    private String defaultIdentifier = null;
    private Instant defaultStartTime = null;
    private int[] defaultButtonBoundLeft = null;
    private int[] defaultButtonBoundRight = null;
    private Instant defaultEndTime = null;
    private int defaultHitButtonCount = 0;
    private ImmutableList<TappingSample> defaultSamples = null;
    private int[] defaultStepViewSize = null;
    private ZonedDateTime defaultZonedEndTime = null;
    private ZonedDateTime defaultZonedStartTime = null;
    public GsonTypeAdapter(Gson gson) {
      this.gson = gson;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void write(JsonWriter jsonWriter, TappingResult object) throws IOException {
      if (object == null) {
        jsonWriter.nullValue();
        return;
      }
      jsonWriter.beginObject();
      jsonWriter.name("identifier");
      if (object.getIdentifier() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getIdentifier());
      }
      jsonWriter.name("startTime");
      if (object.getStartTime() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<Instant> instant_adapter = this.instant_adapter;
        if (instant_adapter == null) {
          this.instant_adapter = instant_adapter = gson.getAdapter(Instant.class);
        }
        instant_adapter.write(jsonWriter, object.getStartTime());
      }
      jsonWriter.name("buttonBoundLeft");
      if (object.getButtonBoundLeft() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
        if (array__int_adapter == null) {
          this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
        }
        array__int_adapter.write(jsonWriter, object.getButtonBoundLeft());
      }
      jsonWriter.name("buttonBoundRight");
      if (object.getButtonBoundRight() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
        if (array__int_adapter == null) {
          this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
        }
        array__int_adapter.write(jsonWriter, object.getButtonBoundRight());
      }
      jsonWriter.name("endTime");
      if (object.getEndTime() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<Instant> instant_adapter = this.instant_adapter;
        if (instant_adapter == null) {
          this.instant_adapter = instant_adapter = gson.getAdapter(Instant.class);
        }
        instant_adapter.write(jsonWriter, object.getEndTime());
      }
      jsonWriter.name("tapCount");
      {
        TypeAdapter<Integer> int__adapter = this.int__adapter;
        if (int__adapter == null) {
          this.int__adapter = int__adapter = gson.getAdapter(Integer.class);
        }
        int__adapter.write(jsonWriter, object.getHitButtonCount());
      }
      jsonWriter.name("samples");
      if (object.getSamples() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableList<TappingSample>> immutableList__tappingSample_adapter = this.immutableList__tappingSample_adapter;
        if (immutableList__tappingSample_adapter == null) {
          this.immutableList__tappingSample_adapter = immutableList__tappingSample_adapter = (TypeAdapter<ImmutableList<TappingSample>>) gson.getAdapter(TypeToken.getParameterized(ImmutableList.class, TappingSample.class));
        }
        immutableList__tappingSample_adapter.write(jsonWriter, object.getSamples());
      }
      jsonWriter.name("stepViewSize");
      if (object.getStepViewSize() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
        if (array__int_adapter == null) {
          this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
        }
        array__int_adapter.write(jsonWriter, object.getStepViewSize());
      }
      jsonWriter.name("zonedEndTime");
      if (object.getZonedEndTime() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ZonedDateTime> zonedDateTime_adapter = this.zonedDateTime_adapter;
        if (zonedDateTime_adapter == null) {
          this.zonedDateTime_adapter = zonedDateTime_adapter = gson.getAdapter(ZonedDateTime.class);
        }
        zonedDateTime_adapter.write(jsonWriter, object.getZonedEndTime());
      }
      jsonWriter.name("zonedStartTime");
      if (object.getZonedStartTime() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ZonedDateTime> zonedDateTime_adapter = this.zonedDateTime_adapter;
        if (zonedDateTime_adapter == null) {
          this.zonedDateTime_adapter = zonedDateTime_adapter = gson.getAdapter(ZonedDateTime.class);
        }
        zonedDateTime_adapter.write(jsonWriter, object.getZonedStartTime());
      }
      jsonWriter.endObject();
    }
    @Override
    @SuppressWarnings("unchecked")
    public TappingResult read(JsonReader jsonReader) throws IOException {
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        return null;
      }
      jsonReader.beginObject();
      String identifier = this.defaultIdentifier;
      Instant startTime = this.defaultStartTime;
      int[] buttonBoundLeft = this.defaultButtonBoundLeft;
      int[] buttonBoundRight = this.defaultButtonBoundRight;
      Instant endTime = this.defaultEndTime;
      int hitButtonCount = this.defaultHitButtonCount;
      ImmutableList<TappingSample> samples = this.defaultSamples;
      int[] stepViewSize = this.defaultStepViewSize;
      ZonedDateTime zonedEndTime = this.defaultZonedEndTime;
      ZonedDateTime zonedStartTime = this.defaultZonedStartTime;
      while (jsonReader.hasNext()) {
        String _name = jsonReader.nextName();
        if (jsonReader.peek() == JsonToken.NULL) {
          jsonReader.nextNull();
          continue;
        }
        switch (_name) {
          case "identifier": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            identifier = string_adapter.read(jsonReader);
            break;
          }
          case "startTime": {
            TypeAdapter<Instant> instant_adapter = this.instant_adapter;
            if (instant_adapter == null) {
              this.instant_adapter = instant_adapter = gson.getAdapter(Instant.class);
            }
            startTime = instant_adapter.read(jsonReader);
            break;
          }
          case "buttonBoundLeft": {
            TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
            if (array__int_adapter == null) {
              this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
            }
            buttonBoundLeft = array__int_adapter.read(jsonReader);
            break;
          }
          case "buttonBoundRight": {
            TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
            if (array__int_adapter == null) {
              this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
            }
            buttonBoundRight = array__int_adapter.read(jsonReader);
            break;
          }
          case "endTime": {
            TypeAdapter<Instant> instant_adapter = this.instant_adapter;
            if (instant_adapter == null) {
              this.instant_adapter = instant_adapter = gson.getAdapter(Instant.class);
            }
            endTime = instant_adapter.read(jsonReader);
            break;
          }
          case "tapCount": {
            TypeAdapter<Integer> int__adapter = this.int__adapter;
            if (int__adapter == null) {
              this.int__adapter = int__adapter = gson.getAdapter(Integer.class);
            }
            hitButtonCount = int__adapter.read(jsonReader);
            break;
          }
          case "samples": {
            TypeAdapter<ImmutableList<TappingSample>> immutableList__tappingSample_adapter = this.immutableList__tappingSample_adapter;
            if (immutableList__tappingSample_adapter == null) {
              this.immutableList__tappingSample_adapter = immutableList__tappingSample_adapter = (TypeAdapter<ImmutableList<TappingSample>>) gson.getAdapter(TypeToken.getParameterized(ImmutableList.class, TappingSample.class));
            }
            samples = immutableList__tappingSample_adapter.read(jsonReader);
            break;
          }
          case "stepViewSize": {
            TypeAdapter<int[]> array__int_adapter = this.array__int_adapter;
            if (array__int_adapter == null) {
              this.array__int_adapter = array__int_adapter = gson.getAdapter(int[].class);
            }
            stepViewSize = array__int_adapter.read(jsonReader);
            break;
          }
          case "zonedEndTime": {
            TypeAdapter<ZonedDateTime> zonedDateTime_adapter = this.zonedDateTime_adapter;
            if (zonedDateTime_adapter == null) {
              this.zonedDateTime_adapter = zonedDateTime_adapter = gson.getAdapter(ZonedDateTime.class);
            }
            zonedEndTime = zonedDateTime_adapter.read(jsonReader);
            break;
          }
          case "zonedStartTime": {
            TypeAdapter<ZonedDateTime> zonedDateTime_adapter = this.zonedDateTime_adapter;
            if (zonedDateTime_adapter == null) {
              this.zonedDateTime_adapter = zonedDateTime_adapter = gson.getAdapter(ZonedDateTime.class);
            }
            zonedStartTime = zonedDateTime_adapter.read(jsonReader);
            break;
          }
          default: {
            jsonReader.skipValue();
          }
        }
      }
      jsonReader.endObject();
      return new AutoValue_TappingResult(identifier, startTime, buttonBoundLeft, buttonBoundRight, endTime, hitButtonCount, samples, stepViewSize, zonedEndTime, zonedStartTime);
    }
    public GsonTypeAdapter setDefaultIdentifier(String defaultIdentifier) {
      this.defaultIdentifier = defaultIdentifier;
      return this;
    }
    public GsonTypeAdapter setDefaultStartTime(Instant defaultStartTime) {
      this.defaultStartTime = defaultStartTime;
      return this;
    }
    public GsonTypeAdapter setDefaultButtonBoundLeft(int[] defaultButtonBoundLeft) {
      this.defaultButtonBoundLeft = defaultButtonBoundLeft;
      return this;
    }
    public GsonTypeAdapter setDefaultButtonBoundRight(int[] defaultButtonBoundRight) {
      this.defaultButtonBoundRight = defaultButtonBoundRight;
      return this;
    }
    public GsonTypeAdapter setDefaultEndTime(Instant defaultEndTime) {
      this.defaultEndTime = defaultEndTime;
      return this;
    }
    public GsonTypeAdapter setDefaultHitButtonCount(int defaultHitButtonCount) {
      this.defaultHitButtonCount = defaultHitButtonCount;
      return this;
    }
    public GsonTypeAdapter setDefaultSamples(ImmutableList<TappingSample> defaultSamples) {
      this.defaultSamples = defaultSamples;
      return this;
    }
    public GsonTypeAdapter setDefaultStepViewSize(int[] defaultStepViewSize) {
      this.defaultStepViewSize = defaultStepViewSize;
      return this;
    }
    public GsonTypeAdapter setDefaultZonedEndTime(ZonedDateTime defaultZonedEndTime) {
      this.defaultZonedEndTime = defaultZonedEndTime;
      return this;
    }
    public GsonTypeAdapter setDefaultZonedStartTime(ZonedDateTime defaultZonedStartTime) {
      this.defaultZonedStartTime = defaultZonedStartTime;
      return this;
    }
  }
}
