/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.jmsQueues.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.psglobal.uaeftmt103.jmsQueues.JMSQueueSender;

@Component
@Slf4j
public class JMSQueueSenderImpl implements JMSQueueSender {

    final JmsTemplate jmsTemplate;

    JMSQueueSenderImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
//@Value("${ibm.mq.queueName}")
//String queueName;

    @Override
    public void sendMessage(String message) {
        log.info("send message starts ");
        jmsTemplate.convertAndSend("LNQKSA_GTF_OUT", message);
        log.info("send message ends ");
    }
}
