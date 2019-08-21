package org.sagebionetworks.research.motor_control_module.show_step_fragment.tapping;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

final class AutoValue_TappingSample extends $AutoValue_TappingSample {
  AutoValue_TappingSample(String buttonIdentifier, double duration, float[] location,
      String stepPath, double timestamp, double uptime) {
    super(buttonIdentifier, duration, location, stepPath, timestamp, uptime);
  }

  public static final class GsonTypeAdapter extends TypeAdapter<TappingSample> {
    private volatile TypeAdapter<String> string_adapter;
    private volatile TypeAdapter<Double> double__adapter;
    private volatile TypeAdapter<float[]> array__float_adapter;
    private final Gson gson;
    private String defaultButtonIdentifier = null;
    private double defaultDuration = 0.0d;
    private float[] defaultLocation = null;
    private String defaultStepPath = null;
    private double defaultTimestamp = 0.0d;
    private double defaultUptime = 0.0d;
    public GsonTypeAdapter(Gson gson) {
      this.gson = gson;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void write(JsonWriter jsonWriter, TappingSample object) throws IOException {
      if (object == null) {
        jsonWriter.nullValue();
        return;
      }
      jsonWriter.beginObject();
      jsonWriter.name("buttonIdentifier");
      if (object.getButtonIdentifier() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getButtonIdentifier());
      }
      jsonWriter.name("duration");
      {
        TypeAdapter<Double> double__adapter = this.double__adapter;
        if (double__adapter == null) {
          this.double__adapter = double__adapter = gson.getAdapter(Double.class);
        }
        double__adapter.write(jsonWriter, object.getDuration());
      }
      jsonWriter.name("location");
      if (object.getLocation() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<float[]> array__float_adapter = this.array__float_adapter;
        if (array__float_adapter == null) {
          this.array__float_adapter = array__float_adapter = gson.getAdapter(float[].class);
        }
        array__float_adapter.write(jsonWriter, object.getLocation());
      }
      jsonWriter.name("stepPath");
      if (object.getStepPath() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getStepPath());
      }
      jsonWriter.name("timestamp");
      {
        TypeAdapter<Double> double__adapter = this.double__adapter;
        if (double__adapter == null) {
          this.double__adapter = double__adapter = gson.getAdapter(Double.class);
        }
        double__adapter.write(jsonWriter, object.getTimestamp());
      }
      jsonWriter.name("uptime");
      {
        TypeAdapter<Double> double__adapter = this.double__adapter;
        if (double__adapter == null) {
          this.double__adapter = double__adapter = gson.getAdapter(Double.class);
        }
        double__adapter.write(jsonWriter, object.getUptime());
      }
      jsonWriter.endObject();
    }
    @Override
    @SuppressWarnings("unchecked")
    public TappingSample read(JsonReader jsonReader) throws IOException {
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        return null;
      }
      jsonReader.beginObject();
      String buttonIdentifier = this.defaultButtonIdentifier;
      double duration = this.defaultDuration;
      float[] location = this.defaultLocation;
      String stepPath = this.defaultStepPath;
      double timestamp = this.defaultTimestamp;
      double uptime = this.defaultUptime;
      while (jsonReader.hasNext()) {
        String _name = jsonReader.nextName();
        if (jsonReader.peek() == JsonToken.NULL) {
          jsonReader.nextNull();
          continue;
        }
        switch (_name) {
          case "buttonIdentifier": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            buttonIdentifier = string_adapter.read(jsonReader);
            break;
          }
          case "duration": {
            TypeAdapter<Double> double__adapter = this.double__adapter;
            if (double__adapter == null) {
              this.double__adapter = double__adapter = gson.getAdapter(Double.class);
            }
            duration = double__adapter.read(jsonReader);
            break;
          }
          case "location": {
            TypeAdapter<float[]> array__float_adapter = this.array__float_adapter;
            if (array__float_adapter == null) {
              this.array__float_adapter = array__float_adapter = gson.getAdapter(float[].class);
            }
            location = array__float_adapter.read(jsonReader);
            break;
          }
          case "stepPath": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            stepPath = string_adapter.read(jsonReader);
            break;
          }
          case "timestamp": {
            TypeAdapter<Double> double__adapter = this.double__adapter;
            if (double__adapter == null) {
              this.double__adapter = double__adapter = gson.getAdapter(Double.class);
            }
            timestamp = double__adapter.read(jsonReader);
            break;
          }
          case "uptime": {
            TypeAdapter<Double> double__adapter = this.double__adapter;
            if (double__adapter == null) {
              this.double__adapter = double__adapter = gson.getAdapter(Double.class);
            }
            uptime = double__adapter.read(jsonReader);
            break;
          }
          default: {
            jsonReader.skipValue();
          }
        }
      }
      jsonReader.endObject();
      return new AutoValue_TappingSample(buttonIdentifier, duration, location, stepPath, timestamp, uptime);
    }
    public GsonTypeAdapter setDefaultButtonIdentifier(String defaultButtonIdentifier) {
      this.defaultButtonIdentifier = defaultButtonIdentifier;
      return this;
    }
    public GsonTypeAdapter setDefaultDuration(double defaultDuration) {
      this.defaultDuration = defaultDuration;
      return this;
    }
    public GsonTypeAdapter setDefaultLocation(float[] defaultLocation) {
      this.defaultLocation = defaultLocation;
      return this;
    }
    public GsonTypeAdapter setDefaultStepPath(String defaultStepPath) {
      this.defaultStepPath = defaultStepPath;
      return this;
    }
    public GsonTypeAdapter setDefaultTimestamp(double defaultTimestamp) {
      this.defaultTimestamp = defaultTimestamp;
      return this;
    }
    public GsonTypeAdapter setDefaultUptime(double defaultUptime) {
      this.defaultUptime = defaultUptime;
      return this;
    }
  }
}
