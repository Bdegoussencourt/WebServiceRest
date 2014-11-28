package fr.treeptik.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import fr.treeptik.model.Stagiaire;

@Stateless
public class MailsMDBQueue {

	@Resource(mappedName = "java:/queue/test2")
	private Destination printingQueue;

	@Resource(name = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	private Connection connection;

	@PostConstruct
	private void initConnection() {
		try {
			connection = connectionFactory.createConnection();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@PreDestroy
	private void closeConnection() {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void sendPrintingMessage(Stagiaire stagiaire) throws JMSException {
		Session session = connection.createSession(false,
			    Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(printingQueue);
		
		connection.start();
//		TextMessage message = session.createTextMessage();
//		message.setText("ce message est renvoye une nouvelle fois");
		System.out.println("mail stagiaire  :: " + stagiaire.getEmail());
		ObjectMessage objectMessage = session.createObjectMessage();
		objectMessage.setObject(stagiaire);
		
		producer.send(objectMessage);
		System.out.println("that's good baby");
		session.close();
	}
}