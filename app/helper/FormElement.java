package helper;

import play.libs.Json;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;

public class FormElement {

    private String label;
    private String value = "";
    private String type = "Text";
    private boolean required;
    private List<String> options;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFieldType() {
        return type;
    }

    public void setFieldType(String fieldType) {
        this.type = fieldType;
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
        return options;
    }

    /**
     * @return the options
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(List<String> options) {
        this.options = options;
    }
}
