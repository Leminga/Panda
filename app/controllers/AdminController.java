package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;

/**
 * @author Manuel Dorfer
 *AdminController verwendet für die Frontend Admin-Mask
 *
 *Folgende Funktionen sollen im AdminController realisiert werden:
 *	-Alle Volunteers ausgeben
 *		-Übersicht mit Vorname-Nachname-ThumbnailBild-mailAdresse
 *		-Ausgabe eventspezifisch
 *	-Volunteers löschen, hinzufügen oder bearbeiten
 *		-Wenn ein Volunteer bearbeitet wird - Daten updaten
 *	-Feld im Frontend wo Admin an den gewünschten User eine Mail senden kann
 *	-"labels" sprachenabhängig füllen
 *		
 *
 */
public class AdminController extends Controller {

	/** Logger to log VolunteerController events. */
	private static Logger LOGGER = LoggerFactory
			.getLogger(AdminController.class);
	/** The authentication token header for the Play framework. */
	protected final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
	/** The authentication token for the Play framework. */
	protected static final String AUTH_TOKEN = "authToken";


}
