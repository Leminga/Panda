package mailer;

import org.apache.commons.mail.*;

import play.Logger;

public class Mail {
	
	
	// Methode für die Email Einstellungen - besser in Conifg file?!
	private static Email setMailSettings() throws EmailException{
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("SportEVIT@gmail.com", "ppanda!1"));
		email.setSSL(true);
		email.setFrom("SportEVIT@gmail.com");
		return email;
		
		
	}
	
//	public static void sendMail() throws EmailException
//	{
//		Email email = setMailSettings();
//		
//		email.setSubject("TestMail");
//		email.setMsg("This is a test mail ... :-)");
//		email.addTo("markus.s@deflagratio.at");
//		email.send();
//	};
	
	
	// Sendet nach der Registrierung eine Bestätigungsmail - wenn bestätigt kann man sich einloggen
	public static void confirmationMail(String prename, String surname,String mailaddress, String token) throws EmailException
	{
		Email email = setMailSettings();
		
		//Text später mulitlingual
		email.setSubject("Bestätigungsmail YOG 2016");
		String link = "localhost:9000/verify";
		
		String text = "Servus "+prename+" "+surname+","+System.lineSeparator()+"willkommen bei den YOG 2016!"+System.lineSeparator()+
		"bitte folgenden Link bestätigen: "+System.lineSeparator()+link+"/"+token;
		
		try {
			email.setMsg(text);
			email.addTo(mailaddress);
			email.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.debug("confirmationMail caught exception: "+e);
		}
	};
}
