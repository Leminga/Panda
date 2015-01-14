/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 *
 * @author danningersebastian
 */
public class FormsController extends Controller
{
        public static Result getRegistrationForm()
        {
                ObjectNode result = Json.newObject();
                ObjectNode schema = result.putObject("schema");
                ObjectNode data = result.putObject("data");
                
                return ok();
                
                /*for (FormElement element : CMISForms.newContactForm()) {
                        schema.put(element.getName(), element.schema());
                        data.put(element.getName(), element.getValue());
                    }
                    return ok(result);*/
        }
}
