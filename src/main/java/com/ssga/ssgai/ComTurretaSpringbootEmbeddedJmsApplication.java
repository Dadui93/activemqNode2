package com.ssga.ssgai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ComTurretaSpringbootEmbeddedJmsApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(ComTurretaSpringbootEmbeddedJmsApplication.class, args);

		MessageSender msgSender = (MessageSender)ctx.getBean("messageSender");

		// Send message to a JMS queue
		for(int i=0; i<5000; i++){
			msgSender.sendMessage("This is the msg from node2 | No Broker \n");
			System.out.print("send message");
			// Give it some time to process
			TimeUnit.SECONDS.sleep(5);
		}
	}
}
