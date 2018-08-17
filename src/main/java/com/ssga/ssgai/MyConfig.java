package com.ssga.ssgai;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import java.net.URI;
import java.util.Arrays;

@Configuration
@EnableJms
public class MyConfig {

    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61619";
    public static final String COMMENT_TOPIC = "comment-topic";

    /**
     * This represents a JMS server. In this case, this is an embedded JMS server.
     * In production, you always connect to external JMS servers.
     *
     * @return
     * @throws Exception
     */

    /**
     * Part of JMS client
     *
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com.ssga"));
        return connectionFactory;
    }

    /**
     * Part of JMS client
     *
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(COMMENT_TOPIC);
        return template;
    }

}
