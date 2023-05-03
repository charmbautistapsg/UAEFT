/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.psglobal.uaeftmt202.commonutil.UniqueIDGenerator202;
import com.psglobal.uaeftmt202.domain.PaymentMessageOutput;
import com.psglobal.uaeftmt202.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt202.domain.enums.MessageOutputStatus;
import com.psglobal.uaeftmt202.jmsQueues.JMSQueueSender202;
import com.psglobal.uaeftmt202.repositories.LoanIQOutView202;
import com.psglobal.uaeftmt202.repositories.PaymentMethodMessageDAO202;
import com.psglobal.uaeftmt202.services.PaymentMessageOutputService202;
import com.psglobal.uaeftmt202.services.UaeftMessageMT202;
import com.psglobal.uaeftmt202.services.core.UaeftMT202MsgCore;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UaeftMessageMT202Imp implements UaeftMessageMT202 {
	
    final UaeftMT202MsgCore uaeftmt202MsgCore;
    final PaymentMethodMessageDAO202 paymentMethodMessageDAO;
    final JMSQueueSender202 jmsQueueSender;
    final LoanIQOutView202 loanIQOutView;

    final PaymentMessageOutputService202 paymentMessageOutputService;

    UaeftMessageMT202Imp(PaymentMessageOutputService202 paymentMessageOutputService,
                         LoanIQOutView202 loanIQOutView ,
                         UaeftMT202MsgCore uaeftmt202MsgCore,
                         PaymentMethodMessageDAO202 paymentMethodMessageDAO,
                         JMSQueueSender202 jmsQueueSender) {

        this.uaeftmt202MsgCore = uaeftmt202MsgCore;
        this.jmsQueueSender = jmsQueueSender;
        this.loanIQOutView = loanIQOutView;
        this.paymentMethodMessageDAO=paymentMethodMessageDAO;
        this.paymentMessageOutputService = paymentMessageOutputService;
    }

    @Override
    public PaymentMethodMessage getUaeftMT202PaymentConfiguration() {

       return  paymentMethodMessageDAO.getPaymentConfig("UAEFT","MT","202");
    }

    @Override
    public void constructAndSendUaeft202Message(Map<String, Object> loanIQMap) {
        try {
            log.info("construct called 202");
            PaymentMethodMessage paymentMethodMessage= getUaeftMT202PaymentConfiguration();
            String message = uaeftmt202MsgCore.constructUaeft202Message(paymentMethodMessage, loanIQMap);
            log.info("message_---->"+message);

   //         savePaymentMessageOut(message, paymentMethodMessage, loanIQMap);
//            updateStatusOfLoanIQOut(loanIQMap);
            jmsQueueSender.sendMessage(message);
        } catch (Exception e) {
            System.out.println("Message with id " + loanIQMap.get("imt_rid_imt_out") + " failed with error");
            e.printStackTrace();
        }
    }

    @Override
    public void savePaymentMessageOut(String message, PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap) {

        PaymentMessageOutput paymentMessageOutput = new PaymentMessageOutput(new UniqueIDGenerator202().generateID(), message, paymentMethodMessage.getPaymentMethodMessageId(),
                (String) loanIQMap.get("imt_rid_imt_out"), MessageOutputStatus.SENT, LocalDateTime.now(), "ADMIN", LocalDate.now());

        //paymentMessageOutputService.save(paymentMessageOutput);
    }

//    @Override
//    public void updateStatusOfLoanIQOut(Map<String, Object> loanIQMap) {
//        loanIQOutView.updateLoanIQOutStatus("DELV", (String) loanIQMap.get("imt_rid_imt_out"));
//    }

}
