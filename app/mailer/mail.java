package mailer;

import org.apache.commons.mail.*;

public class mail {
	
	public static void sendMail() throws EmailException
	{
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com.");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("SportEVIT@gmail.com", "ppanda!1"));
		email.setSSL(true);
		email.setFrom("SportEVIT@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("markus.s@deflagratio.at");
		email.send();
	};
}