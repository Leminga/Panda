package mailer;

import org.apache.commons.mail.*;

public class Mail {
	
	public static void sendMail() throws EmailException
	{
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("SportEVIT@gmail.com", "ppanda!1"));
		email.setSSL(true);
		email.setFrom("SportEVIT@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("markus.s@deflagratio.at");
		email.send();
	};
	
//	public static void sendMail(String address, String name) throws EmailException
//	{
//		
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(465);
//		email.setAuthenticator(new DefaultAuthenticator("SportEVIT@gmail.com", "ppanda!1"));
//		email.setSSL(true);
//		email.setFrom("SportEVIT@gmail.com");
//		email.setSubject("Panda Mail");
//		email.setMsg("Hallo "+name+System.lineSeparator()+"Überraschung eurer Programm kann schon zeitgesteuert Emails versenden! :-)"+System.lineSeparator()+"Beste grüße Team Panda");
//		email.addTo(address);
//		email.send();
//	};
}
