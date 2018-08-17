package com.ssga.ssgai;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

import javax.jms.JMSException;

/**
 * Created by SANG018 on 26/1/2017.
 */
@Component
public class MessageReceiver {

    @JmsListener(destination = MyConfig.COMMENT_TOPIC)
    public void receiveMessage(final Message<String> message) throws JMSException {
        String response = message.getPayload();
        System.out.print("receive:"+response);
    }
}
