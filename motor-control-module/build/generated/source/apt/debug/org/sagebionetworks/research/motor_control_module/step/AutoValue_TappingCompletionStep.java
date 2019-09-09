package org.sagebionetworks.research.motor_control_module.step;

import android.support.annotation.Nullable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.sagebionetworks.research.domain.async.AsyncActionConfiguration;
import org.sagebionetworks.research.domain.step.ui.action.Action;
import org.sagebionetworks.research.domain.step.ui.theme.ColorTheme;
import org.sagebionetworks.research.domain.step.ui.theme.ImageTheme;

final class AutoValue_TappingCompletionStep extends $AutoValue_TappingCompletionStep {
  AutoValue_TappingCompletionStep(ImmutableSet<AsyncActionConfiguration> asyncActions,
      String identifier, ImmutableMap<String, Action> actions, ImmutableSet<String> hiddenActions,
      @Nullable String detail, @Nullable String footnote, @Nullable String text,
      @Nullable String title, @Nullable ColorTheme colorTheme, @Nullable ImageTheme imageTheme) {
    super(asyncActions, identifier, actions, hiddenActions, detail, footnote, text, title, colorTheme, imageTheme);
  }

  public static final class GsonTypeAdapter extends TypeAdapter<TappingCompletionStep> {
    private volatile TypeAdapter<ImmutableSet<AsyncActionConfiguration>> immutableSet__asyncActionConfiguration_adapter;
    private volatile TypeAdapter<String> string_adapter;
    private volatile TypeAdapter<ImmutableMap<String, Action>> immutableMap__string_action_adapter;
    private volatile TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter;
    private volatile TypeAdapter<ColorTheme> colorTheme_adapter;
    private volatile TypeAdapter<ImageTheme> imageTheme_adapter;
    private final Gson gson;
    private ImmutableSet<AsyncActionConfiguration> defaultAsyncActions = null;
    private String defaultIdentifier = null;
    private ImmutableMap<String, Action> defaultActions = null;
    private ImmutableSet<String> defaultHiddenActions = null;
    private String defaultDetail = null;
    private String defaultFootnote = null;
    private String defaultText = null;
    private String defaultTitle = null;
    private ColorTheme defaultColorTheme = null;
    private ImageTheme defaultImageTheme = null;
    public GsonTypeAdapter(Gson gson) {
      this.gson = gson;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void write(JsonWriter jsonWriter, TappingCompletionStep object) throws IOException {
      if (object == null) {
        jsonWriter.nullValue();
        return;
      }
      jsonWriter.beginObject();
      jsonWriter.name("asyncActions");
      if (object.getAsyncActions() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableSet<AsyncActionConfiguration>> immutableSet__asyncActionConfiguration_adapter = this.immutableSet__asyncActionConfiguration_adapter;
        if (immutableSet__asyncActionConfiguration_adapter == null) {
          this.immutableSet__asyncActionConfiguration_adapter = immutableSet__asyncActionConfiguration_adapter = (TypeAdapter<ImmutableSet<AsyncActionConfiguration>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, AsyncActionConfiguration.class));
        }
        immutableSet__asyncActionConfiguration_adapter.write(jsonWriter, object.getAsyncActions());
      }
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
      jsonWriter.name("actions");
      if (object.getActions() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableMap<String, Action>> immutableMap__string_action_adapter = this.immutableMap__string_action_adapter;
        if (immutableMap__string_action_adapter == null) {
          this.immutableMap__string_action_adapter = immutableMap__string_action_adapter = (TypeAdapter<ImmutableMap<String, Action>>) gson.getAdapter(TypeToken.getParameterized(ImmutableMap.class, String.class, Action.class));
        }
        immutableMap__string_action_adapter.write(jsonWriter, object.getActions());
      }
      jsonWriter.name("hiddenActions");
      if (object.getHiddenActions() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter = this.immutableSet__string_adapter;
        if (immutableSet__string_adapter == null) {
          this.immutableSet__string_adapter = immutableSet__string_adapter = (TypeAdapter<ImmutableSet<String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, String.class));
        }
        immutableSet__string_adapter.write(jsonWriter, object.getHiddenActions());
      }
      jsonWriter.name("detail");
      if (object.getDetail() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getDetail());
      }
      jsonWriter.name("footnote");
      if (object.getFootnote() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getFootnote());
      }
      jsonWriter.name("text");
      if (object.getText() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<String> string_adapter = this.string_adapter;
        if (string_adapter == null) {
          this.string_adapter = string_adapter = gson.getAdapter(String.class);
        }
        string_adapter.write(jsonWriter, object.getText());
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
      jsonWriter.name("colorTheme");
      if (object.getColorTheme() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ColorTheme> colorTheme_adapter = this.colorTheme_adapter;
        if (colorTheme_adapter == null) {
          this.colorTheme_adapter = colorTheme_adapter = gson.getAdapter(ColorTheme.class);
        }
        colorTheme_adapter.write(jsonWriter, object.getColorTheme());
      }
      jsonWriter.name("image");
      if (object.getImageTheme() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImageTheme> imageTheme_adapter = this.imageTheme_adapter;
        if (imageTheme_adapter == null) {
          this.imageTheme_adapter = imageTheme_adapter = gson.getAdapter(ImageTheme.class);
        }
        imageTheme_adapter.write(jsonWriter, object.getImageTheme());
      }
      jsonWriter.endObject();
    }
    @Override
    @SuppressWarnings("unchecked")
    public TappingCompletionStep read(JsonReader jsonReader) throws IOException {
      if (jsonReader.peek() == JsonToken.NULL) {
        jsonReader.nextNull();
        return null;
      }
      jsonReader.beginObject();
      ImmutableSet<AsyncActionConfiguration> asyncActions = this.defaultAsyncActions;
      String identifier = this.defaultIdentifier;
      ImmutableMap<String, Action> actions = this.defaultActions;
      ImmutableSet<String> hiddenActions = this.defaultHiddenActions;
      String detail = this.defaultDetail;
      String footnote = this.defaultFootnote;
      String text = this.defaultText;
      String title = this.defaultTitle;
      ColorTheme colorTheme = this.defaultColorTheme;
      ImageTheme imageTheme = this.defaultImageTheme;
      while (jsonReader.hasNext()) {
        String _name = jsonReader.nextName();
        if (jsonReader.peek() == JsonToken.NULL) {
          jsonReader.nextNull();
          continue;
        }
        switch (_name) {
          case "asyncActions": {
            TypeAdapter<ImmutableSet<AsyncActionConfiguration>> immutableSet__asyncActionConfiguration_adapter = this.immutableSet__asyncActionConfiguration_adapter;
            if (immutableSet__asyncActionConfiguration_adapter == null) {
              this.immutableSet__asyncActionConfiguration_adapter = immutableSet__asyncActionConfiguration_adapter = (TypeAdapter<ImmutableSet<AsyncActionConfiguration>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, AsyncActionConfiguration.class));
            }
            asyncActions = immutableSet__asyncActionConfiguration_adapter.read(jsonReader);
            break;
          }
          case "identifier": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            identifier = string_adapter.read(jsonReader);
            break;
          }
          case "actions": {
            TypeAdapter<ImmutableMap<String, Action>> immutableMap__string_action_adapter = this.immutableMap__string_action_adapter;
            if (immutableMap__string_action_adapter == null) {
              this.immutableMap__string_action_adapter = immutableMap__string_action_adapter = (TypeAdapter<ImmutableMap<String, Action>>) gson.getAdapter(TypeToken.getParameterized(ImmutableMap.class, String.class, Action.class));
            }
            actions = immutableMap__string_action_adapter.read(jsonReader);
            break;
          }
          case "hiddenActions": {
            TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter = this.immutableSet__string_adapter;
            if (immutableSet__string_adapter == null) {
              this.immutableSet__string_adapter = immutableSet__string_adapter = (TypeAdapter<ImmutableSet<String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, String.class));
            }
            hiddenActions = immutableSet__string_adapter.read(jsonReader);
            break;
          }
          case "detail": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            detail = string_adapter.read(jsonReader);
            break;
          }
          case "footnote": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            footnote = string_adapter.read(jsonReader);
            break;
          }
          case "text": {
            TypeAdapter<String> string_adapter = this.string_adapter;
            if (string_adapter == null) {
              this.string_adapter = string_adapter = gson.getAdapter(String.class);
            }
            text = string_adapter.read(jsonReader);
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
          case "colorTheme": {
            TypeAdapter<ColorTheme> colorTheme_adapter = this.colorTheme_adapter;
            if (colorTheme_adapter == null) {
              this.colorTheme_adapter = colorTheme_adapter = gson.getAdapter(ColorTheme.class);
            }
            colorTheme = colorTheme_adapter.read(jsonReader);
            break;
          }
          case "image": {
            TypeAdapter<ImageTheme> imageTheme_adapter = this.imageTheme_adapter;
            if (imageTheme_adapter == null) {
              this.imageTheme_adapter = imageTheme_adapter = gson.getAdapter(ImageTheme.class);
            }
            imageTheme = imageTheme_adapter.read(jsonReader);
            break;
          }
          default: {
            jsonReader.skipValue();
          }
        }
      }
      jsonReader.endObject();
      return new AutoValue_TappingCompletionStep(asyncActions, identifier, actions, hiddenActions, detail, footnote, text, title, colorTheme, imageTheme);
    }
    public GsonTypeAdapter setDefaultAsyncActions(
        ImmutableSet<AsyncActionConfiguration> defaultAsyncActions) {
      this.defaultAsyncActions = defaultAsyncActions;
      return this;
    }
    public GsonTypeAdapter setDefaultIdentifier(String defaultIdentifier) {
      this.defaultIdentifier = defaultIdentifier;
      return this;
    }
    public GsonTypeAdapter setDefaultActions(ImmutableMap<String, Action> defaultActions) {
      this.defaultActions = defaultActions;
      return this;
    }
    public GsonTypeAdapter setDefaultHiddenActions(ImmutableSet<String> defaultHiddenActions) {
      this.defaultHiddenActions = defaultHiddenActions;
      return this;
    }
    public GsonTypeAdapter setDefaultDetail(String defaultDetail) {
      this.defaultDetail = defaultDetail;
      return this;
    }
    public GsonTypeAdapter setDefaultFootnote(String defaultFootnote) {
      this.defaultFootnote = defaultFootnote;
      return this;
    }
    public GsonTypeAdapter setDefaultText(String defaultText) {
      this.defaultText = defaultText;
      return this;
    }
    public GsonTypeAdapter setDefaultTitle(String defaultTitle) {
      this.defaultTitle = defaultTitle;
      return this;
    }
    public GsonTypeAdapter setDefaultColorTheme(ColorTheme defaultColorTheme) {
      this.defaultColorTheme = defaultColorTheme;
      return this;
    }
    public GsonTypeAdapter setDefaultImageTheme(ImageTheme defaultImageTheme) {
      this.defaultImageTheme = defaultImageTheme;
      return this;
    }
  }
}
