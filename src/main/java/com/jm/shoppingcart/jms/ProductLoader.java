package com.jm.shoppingcart.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class ProductLoader  implements MessageListener{

	public void onMessage(Message message)
	{
		TextMessage msg = (TextMessage) message;
		try {

			System.out.println("received: " + msg.getText());

		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}

}
