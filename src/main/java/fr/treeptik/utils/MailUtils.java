package fr.treeptik.utils;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import fr.treeptik.model.Stagiaire;

@Stateless
public class MailUtils {

	@Resource(mappedName = "java:jboss/mail/gmail")
	Session session;

	@Asynchronous
	public void mailSenderToStagiaire(Stagiaire stagiaire) {
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO, stagiaire.getEmail());
			msg.setSubject(stagiaire.getPrenom() + " bienvenue sur le site");
			msg.setSentDate(new Date());
			msg.setText("Bonjour " + stagiaire.getPrenom() + " "
					+ stagiaire.getNom() + ", \n"
					+ "Vos identifiants : \n Login : " + stagiaire.getEmail()
					+ "\n Password : " + stagiaire.getPassword());
			Transport.send(msg);
			System.out.println("mailenvoi");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}