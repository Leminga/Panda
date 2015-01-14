package helper;

import play.libs.Json;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

public class FormElement {

    private String name;
    private String label;
    private String value = "";
    private String fieldType = "Text";
    private boolean required;
    private ArrayList<String> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ObjectNode schema() {
        ObjectNode options = Json.newObject();

        options.put("title", getLabel());
        options.put("type", getFieldType());
        if (isRequired()) {
            ArrayNode vals = options.putArray("validators");
            vals.add("required");
        }
        if (hasOptions()) {
            ArrayNode vals = options.putArray("options");
        }
        return options;
    }

    /**
     * @return the hasOptions
     */
    public boolean hasOptions() {
        return hasOptions;
    }

    /**
     * @param hasOptions the hasOptions to set
     */
    public void setHasOptions(boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

}
