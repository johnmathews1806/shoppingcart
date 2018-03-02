package com.jm.shoppingcart.jms;

import java.io.FileReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jm.shoppingcart.entities.AccountTransaction;
import com.jm.shoppingcart.entities.User;
import com.jm.shoppingcart.jms.jaxb.TransactionBinding;
import com.jm.shoppingcart.services.TransactionService;
import com.jm.shoppingcart.services.TransactionServiceImpl;
import com.jm.shoppingcart.services.UserService;
import com.jm.shoppingcart.services.UserServiceImpl;

@Component
public class ProductLoader  implements MessageListener{

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private JmsTemplate jmsTemplate;

	public void onMessage(Message message)
	{

		TextMessage msg = (TextMessage) message;
		String reference = "";
		try {
			JAXBContext context = JAXBContext.newInstance(TransactionBinding.class);
			//System.out.println("received: " + msg.getText());
			StringReader reader = new StringReader(msg.getText());
			Unmarshaller um = context.createUnmarshaller();
			TransactionBinding transactionBinding = (TransactionBinding) um.unmarshal(reader);       

			reference = transactionBinding.getReferenceNo();
			System.out.println("transaction: " + reference + " for amount "
					+ transactionBinding.getAmount());

			AccountTransaction accountTransaction = new AccountTransaction();
			accountTransaction.setAmount(new BigDecimal(transactionBinding.getAmount()));
			accountTransaction.setReferenceNo(transactionBinding.getReferenceNo());
			accountTransaction.setTranDate(Date.valueOf(transactionBinding.getTranDate()));	        

			User user = userService.getUserbyLoginId(transactionBinding.getUserId());
			
			transactionService.createTransaction(user, accountTransaction);				
			
			sendMessage("Transaction - "+transactionBinding.getReferenceNo()+" updated succesfully");

		} catch (JMSException ex) {
			ex.printStackTrace();
			sendMessage("Transaction message failed");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			sendMessage("Transaction - "+reference+" failed in unmarshalling");
			e.printStackTrace();
		}catch(Exception h){
			System.out.println("Database failure ");
			sendMessage("Transaction - "+reference+" failed with error: "+h);
			
		}
	}

	private void sendMessage(final String message){  
		jmsTemplate.send(new MessageCreator(){	  
			//@Override  
			public Message createMessage(Session session) throws JMSException {  
				return session.createTextMessage(message);  
			}  
		});  
	}  

}
