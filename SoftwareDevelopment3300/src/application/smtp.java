//Author: Leonardo Mazuran
// secure smtp port 465 to google email server.
// change google security setting to allow unknown software to access account
package application;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class smtp {
		public static void connect(String email_a, String email_b, String email_c){
	Properties props = new Properties();
	
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	
	props.put("mail.smtp.port", "465");

	Session session = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			
				return new PasswordAuthentication("email, password");
			}
		});
	try{
		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress("email"));
	
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email_a));
		message.setSubject(email_b);
		
		message.setText(email_c);
	
		Transport.send(message);
	}catch(Exception e){
		System.out.println(e);
	}
}
}