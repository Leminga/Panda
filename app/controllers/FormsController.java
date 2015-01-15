/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.fixed.Gender;
import org.json.JSONArray;
import play.Play;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 *
 * @author danningersebastian
 */
public class FormsController extends Controller {

    private static Properties getPropertyFile() {
        Properties properties = new Properties();
        InputStream stream = Play.application().classloader().getResourceAsStream("forms_en.properties");
        try {
            properties.load(stream);
            stream.close();
            return properties;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormsController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(FormsController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(FormsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Result getRegistrationForm() {
        JSONArray elements = new JSONArray();
        elements.put(generateFieldFromProperty("prename"));
        elements.put(generateFieldFromProperty("surname"));
        elements.put(generateFieldFromProperty("gender"));
        return ok(Json.toJson(elements));
    }

    private static JsonNode generateFieldFromProperty(String fieldName) {
        Properties props = getPropertyFile();
        ObjectNode formElememt = Json.newObject();

        formElememt.put("name", fieldName);
        formElememt.put("label", props.getProperty(fieldName + "_label"));
        formElememt.put("type", props.getProperty(fieldName + "_type"));

        if (formElememt.get("type").asText().equalsIgnoreCase("list")) {
            try {
                Class<?> cl = Class.forName("models.fixed." + Character.toString(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1));
                List<?> l = Ebean.find(cl).findList();
                formElememt.put("options", Json.toJson(l));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ObjectNode validations = Json.newObject();
        validations.put("required", props.getProperty(fieldName + "_validations_required"));
        validations.put("pattern", props.getProperty(fieldName + "_validations_pattern"));
        formElememt.put("validations", validations);

        ObjectNode messages = Json.newObject();
        messages.put("invalid", props.getProperty(fieldName + "_validationmessages_invalid"));
        messages.put("required", props.getProperty(fieldName + "_validationmessages_required"));
        messages.put("pattern", props.getProperty(fieldName + "_validationmessages_pattern"));
        formElememt.put("validationmessages", messages);

        return Json.toJson(formElememt);
    }

}
