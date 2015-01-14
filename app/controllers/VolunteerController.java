/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.avaje.ebean.Ebean;
import models.human.Volunteer;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 *
 * @author danningersebastian
 */
public class VolunteerController extends Controller
{
        @Security.Authenticated(Secured.class)
        public static Result getVolunteer(Long id)
        {
                return ok(Json.toJson(Ebean.find(Volunteer.class, id)));
        }
        
        @Security.Authenticated(Secured.class)
        public static Result getVolunteers()
        {
                return ok(Json.toJson(Ebean.find(Volunteer.class)));
        }
}
