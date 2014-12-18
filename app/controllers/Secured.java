package controllers;

import controllers.routes;
import models.UserLogin;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

/**
 * The Secure authenticator protects actions 
 * with authentication. 
 * 
 * Play allows us to do this using action composition. 
 * Action composition is the ability to compose 
 * multiple actions together in a chain. Each action 
 * can do something to the request before delegating 
 * to the next action, and can also modify the result. 
 * An action can also decide not to pass the request 
 * onto the next action, and instead generate the 
 * result itself. We use this mechanism to protect
 * and limit secure actions.
 * 
 * Play already comes with a built in authenticator 
 * action, which we will extend to add our logic.
 * 
 * @author Michael Bredel <michael.bredel@fh-kufstein.ac.at>
 */
public class Secured extends Security.Authenticator {

	/*
	 * Method used to get the username of the current logged in user.
	 * If this method returns a value, then the authenticator 
	 * considers the user to be logged in, and lets the request proceed.
	 * If however the method returns null, then the authenticator will 
	 * block the request, and instead invoke onUnathorized.
	 * 
	 * (non-Javadoc)
	 * @see play.mvc.Security.Authenticator#getUsername(play.mvc.Http.Context)
	 */
    @Override
    public String getUsername(Context ctx) {
        UserLogin user = null;
        String[] authTokenHeaderValues = ctx.request().headers().get(SecurityController.AUTH_TOKEN_HEADER);
        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
            user = UserLogin.findByAuthToken(authTokenHeaderValues[0]);
            if (user != null) {
                ctx.args.put("user", user);
                return user.getUsername();
            }
        }
        // If the user was not authenticated.
        return null;
    }

    /*
     * Redirects to the login screen.
     * 
     * (non-Javadoc)
     * @see play.mvc.Security.Authenticator#onUnauthorized(play.mvc.Http.Context)
     */
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.SecurityController.login());
    }
}