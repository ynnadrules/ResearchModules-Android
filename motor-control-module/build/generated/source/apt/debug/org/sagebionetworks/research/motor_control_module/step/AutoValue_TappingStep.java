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
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.sagebionetworks.research.domain.async.AsyncActionConfiguration;
import org.sagebionetworks.research.domain.step.ui.action.Action;
import org.sagebionetworks.research.domain.step.ui.theme.ColorTheme;
import org.sagebionetworks.research.domain.step.ui.theme.ImageTheme;

final class AutoValue_TappingStep extends $AutoValue_TappingStep {
  AutoValue_TappingStep(ImmutableSet<AsyncActionConfiguration> asyncActions, String identifier,
      ImmutableMap<String, Action> actions, ImmutableSet<String> hiddenActions,
      @Nullable String detail, @Nullable String footnote, @Nullable String text,
      @Nullable String title, @Nullable ColorTheme colorTheme, @Nullable ImageTheme imageTheme,
      @Nullable ImmutableSet<String> commands, @Nullable Double duration,
      @Nullable ImmutableMap<String, String> spokenInstructions, boolean backgroundAudioRequired) {
    super(asyncActions, identifier, actions, hiddenActions, detail, footnote, text, title, colorTheme, imageTheme, commands, duration, spokenInstructions, backgroundAudioRequired);
  }

  public static final class GsonTypeAdapter extends TypeAdapter<TappingStep> {
    private volatile TypeAdapter<ImmutableSet<AsyncActionConfiguration>> immutableSet__asyncActionConfiguration_adapter;
    private volatile TypeAdapter<String> string_adapter;
    private volatile TypeAdapter<ImmutableMap<String, Action>> immutableMap__string_action_adapter;
    private volatile TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter;
    private volatile TypeAdapter<ColorTheme> colorTheme_adapter;
    private volatile TypeAdapter<ImageTheme> imageTheme_adapter;
    private volatile TypeAdapter<Double> double__adapter;
    private volatile TypeAdapter<ImmutableMap<String, String>> immutableMap__string_string_adapter;
    private volatile TypeAdapter<Boolean> boolean__adapter;
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
    private ImmutableSet<String> defaultCommands = null;
    private Double defaultDuration = null;
    private ImmutableMap<String, String> defaultSpokenInstructions = null;
    private boolean defaultBackgroundAudioRequired = false;
    public GsonTypeAdapter(Gson gson) {
      this.gson = gson;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void write(JsonWriter jsonWriter, TappingStep object) throws IOException {
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
      jsonWriter.name("commands");
      if (object.getCommands() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter = this.immutableSet__string_adapter;
        if (immutableSet__string_adapter == null) {
          this.immutableSet__string_adapter = immutableSet__string_adapter = (TypeAdapter<ImmutableSet<String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, String.class));
        }
        immutableSet__string_adapter.write(jsonWriter, object.getCommands());
      }
      jsonWriter.name("duration");
      if (object.getDuration() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<Double> double__adapter = this.double__adapter;
        if (double__adapter == null) {
          this.double__adapter = double__adapter = gson.getAdapter(Double.class);
        }
        double__adapter.write(jsonWriter, object.getDuration());
      }
      jsonWriter.name("spokenInstructions");
      if (object.getSpokenInstructions() == null) {
        jsonWriter.nullValue();
      } else {
        TypeAdapter<ImmutableMap<String, String>> immutableMap__string_string_adapter = this.immutableMap__string_string_adapter;
        if (immutableMap__string_string_adapter == null) {
          this.immutableMap__string_string_adapter = immutableMap__string_string_adapter = (TypeAdapter<ImmutableMap<String, String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableMap.class, String.class, String.class));
        }
        immutableMap__string_string_adapter.write(jsonWriter, object.getSpokenInstructions());
      }
      jsonWriter.name("backgroundAudioRequired");
      {
        TypeAdapter<Boolean> boolean__adapter = this.boolean__adapter;
        if (boolean__adapter == null) {
          this.boolean__adapter = boolean__adapter = gson.getAdapter(Boolean.class);
        }
        boolean__adapter.write(jsonWriter, object.isBackgroundAudioRequired());
      }
      jsonWriter.endObject();
    }
    @Override
    @SuppressWarnings("unchecked")
    public TappingStep read(JsonReader jsonReader) throws IOException {
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
      ImmutableSet<String> commands = this.defaultCommands;
      Double duration = this.defaultDuration;
      ImmutableMap<String, String> spokenInstructions = this.defaultSpokenInstructions;
      boolean backgroundAudioRequired = this.defaultBackgroundAudioRequired;
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
          case "commands": {
            TypeAdapter<ImmutableSet<String>> immutableSet__string_adapter = this.immutableSet__string_adapter;
            if (immutableSet__string_adapter == null) {
              this.immutableSet__string_adapter = immutableSet__string_adapter = (TypeAdapter<ImmutableSet<String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableSet.class, String.class));
            }
            commands = immutableSet__string_adapter.read(jsonReader);
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
          case "spokenInstructions": {
            TypeAdapter<ImmutableMap<String, String>> immutableMap__string_string_adapter = this.immutableMap__string_string_adapter;
            if (immutableMap__string_string_adapter == null) {
              this.immutableMap__string_string_adapter = immutableMap__string_string_adapter = (TypeAdapter<ImmutableMap<String, String>>) gson.getAdapter(TypeToken.getParameterized(ImmutableMap.class, String.class, String.class));
            }
            spokenInstructions = immutableMap__string_string_adapter.read(jsonReader);
            break;
          }
          case "backgroundAudioRequired": {
            TypeAdapter<Boolean> boolean__adapter = this.boolean__adapter;
            if (boolean__adapter == null) {
              this.boolean__adapter = boolean__adapter = gson.getAdapter(Boolean.class);
            }
            backgroundAudioRequired = boolean__adapter.read(jsonReader);
            break;
          }
          default: {
            jsonReader.skipValue();
          }
        }
      }
      jsonReader.endObject();
      return new AutoValue_TappingStep(asyncActions, identifier, actions, hiddenActions, detail, footnote, text, title, colorTheme, imageTheme, commands, duration, spokenInstructions, backgroundAudioRequired);
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
    public GsonTypeAdapter setDefaultCommands(ImmutableSet<String> defaultCommands) {
      this.defaultCommands = defaultCommands;
      return this;
    }
    public GsonTypeAdapter setDefaultDuration(Double defaultDuration) {
      this.defaultDuration = defaultDuration;
      return this;
    }
    public GsonTypeAdapter setDefaultSpokenInstructions(
        ImmutableMap<String, String> defaultSpokenInstructions) {
      this.defaultSpokenInstructions = defaultSpokenInstructions;
      return this;
    }
    public GsonTypeAdapter setDefaultBackgroundAudioRequired(
        boolean defaultBackgroundAudioRequired) {
      this.defaultBackgroundAudioRequired = defaultBackgroundAudioRequired;
      return this;
    }
  }
}
