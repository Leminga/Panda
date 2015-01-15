package controllers;

import com.avaje.ebean.Ebean;
import forms.CoreDataForm;
import forms.RegisterForm;
import models.User;
import models.human.Volunteer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * @author Manuel Dorfer
 *
 * Folgende Funktionen sollen im VolunteerController realisiert werden:
 * -Aulsesen der DB und übergaben an das Frontend in JSOn (helper.JSONHelper)
 * -Speichern der geänderten/hinzugefügen Daten (PATCH - geplant) vom Frontend
 * in der DB speichern -Speichern und Auslesen der Dateien(photo/waiver etc) im
 * Base64 format (String) -> wird bereits im FileHandler erledigt -> bei der
 * Übergabe an den FileHandler sollen die Metadaten des Base64 herausgenommen
 * werden - nur String code. - Befüllen der "labels" im Frontend
 * sprachenabhängig mit IDs und den Strings
 *
 *
 *
 */
public class VolunteerController extends Controller {

    /**
     * Logger to log VolunteerController events.
     */
    private static Logger LOGGER = LoggerFactory
            .getLogger(VolunteerController.class);
    /**
     * The authentication token header for the Play framework.
     */
    protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
    /**
     * The authentication token for the Play framework.
     */
    protected static final String AUTH_TOKEN = "authToken";

    @Security.Authenticated(Secured.class)
    public static Result returnUserData() {

        String authHeader = request().getHeader("X-AUTH-TOKEN");
        User user = User.findByAuthToken(authHeader);

        LOGGER.info(" username is: " + user);
        //Soll dan den passenden user mit all seinen ausprägungen zurückgeben

        LOGGER.info(" userRequest successfully by : " + "user xx");
        return ok();

    }

    public static Result saveUserData() {

        Form<CoreDataForm> form = Form.form(CoreDataForm.class).bindFromRequest();
        RegisterForm CoreDataForm = form.get();

        return ok();
    }

    public static Result getVolunteer(long id) {
        return ok();
    }

    public static Result getVolunteers() {
        return ok();
    }
}
