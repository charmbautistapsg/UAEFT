/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.jmsQueues.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.psglobal.uaeftmt202.jmsQueues.JMSQueueSender202;

@Component
@Slf4j
public class JMSQueueSender202Impl implements JMSQueueSender202 {

    final JmsTemplate jmsTemplate;

    JMSQueueSender202Impl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Value("${ibm.mq.queueName}")
    private String queueName;

    @Override
    public void sendMessage(String message) {
        log.info("send message starts ");
        jmsTemplate.convertAndSend(queueName, message);
        log.info("send message ends ");
    }
}
