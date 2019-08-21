package org.sagebionetworks.research.motor_control_module.step;

import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

final class AutoValue_Icon extends $AutoValue_Icon {
  AutoValue_Icon(String icon, @Nullable String title) {
    super(icon, title);
  }

  public static final class GsonTypeAdapter extends TypeAdapter<Icon> {
    private volatile TypeAdapter<String> string_adapter;
    private final Gson gson;
    private String defaultIcon = null;
    private String defaultTitle = null;
    public GsonTypeAdapter(Gson gson) {
      this.gson = gson;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void write(JsonWriter jsonWriter, Icon object) throws IOException {
      if (object == null) {
        jsonWriter.nullValue();
        return;
      }
      jsonWriter.beginObject();
      jsonWriter.name("icon");
      if (object.getIcon() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getIcon());
      }
      jsonWriter.name("title");
      if (object.getTitle() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getTitle());
      }
      jsonWriter.endObject();
    }
    @Override
    @SuppressWarnings("unchecked")
    public Icon read(JsonReader jsonReader) throws IOException {
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        return null;
      }
      jsonReader.beginObject();
      String icon = this.defaultIcon;
      String title = this.defaultTitle;
      while (jsonReader.hasNext()) {
        String _name = jsonReader.nextName();
        if (jsonReader.peek() == JsonToken.NULL) {
          jsonReader.nextNull();
          continue;
        }
        switch (_name) {
          case "icon": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            icon = string_adapter.read(jsonReader);
            break;
          }
          case "title": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            title = string_adapter.read(jsonReader);
            break;
          }
          default: {
            jsonReader.skipValue();
          }
        }
      }
      jsonReader.endObject();
      return new AutoValue_Icon(icon, title);
    }
    public GsonTypeAdapter setDefaultIcon(String defaultIcon) {
      this.defaultIcon = defaultIcon;
      return this;
    }
    public GsonTypeAdapter setDefaultTitle(String defaultTitle) {
      this.defaultTitle = defaultTitle;
      return this;
    }
  }
}
