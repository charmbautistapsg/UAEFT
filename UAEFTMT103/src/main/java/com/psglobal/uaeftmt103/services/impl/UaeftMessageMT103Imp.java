/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.services.impl;

import org.springframework.stereotype.Service;

import com.psglobal.uaeftmt103.commonutil.UniqueIDGenerator;
import com.psglobal.uaeftmt103.config.UaeftMT130Configuration;
import com.psglobal.uaeftmt103.domain.PaymentMessageOutput;
import com.psglobal.uaeftmt103.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt103.domain.enums.MessageOutputStatus;
import com.psglobal.uaeftmt103.jmsQueues.JMSQueueSender;
import com.psglobal.uaeftmt103.repositories.LoanIQOutView;
import com.psglobal.uaeftmt103.repositories.PaymentMethodMessageRepo;
import com.psglobal.uaeftmt103.services.PaymentMessageOutputService;
import com.psglobal.uaeftmt103.services.UaeftMessageMT103;
import com.psglobal.uaeftmt103.services.core.UaeftMT103MsgCore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UaeftMessageMT103Imp implements UaeftMessageMT103 {
    final UaeftMT103MsgCore uaeftMT103MsgCore;
    final PaymentMethodMessageRepo paymentMethodMessageRepo;
    final JMSQueueSender jmsQueueSender;
    final LoanIQOutView loanIQOutView;
    final PaymentMessageOutputService paymentMessageOutputService;

    UaeftMessageMT103Imp(PaymentMessageOutputService paymentMessageOutputService, LoanIQOutView loanIQOutView, PaymentMethodMessageRepo paymentMethodMessageRepo, UaeftMT103MsgCore uaeftMT103MsgCore, JMSQueueSender jmsQueueSender) {
        this.paymentMethodMessageRepo = paymentMethodMessageRepo;
        this.uaeftMT103MsgCore = uaeftMT103MsgCore;
        this.jmsQueueSender = jmsQueueSender;
        this.loanIQOutView = loanIQOutView;
        this.paymentMessageOutputService = paymentMessageOutputService;
    }

    @Override
    public PaymentMethodMessage getUaeftMT103MessageFormat() {
        return paymentMethodMessageRepo.findByPaymentMethodAndMessageTypeAndMessageFormat("UAEFT", "103", "MT");
    }

    @Override
    public List<Map<String, Object>> getAllLoanIQOutData(UaeftMT130Configuration uaeftMT130Configuration) {
        return loanIQOutView.getAllLoanIQOutData(uaeftMT130Configuration.getMessageType(), uaeftMT130Configuration.getMessageStatus());
    }

    @Override
    public void constructAndSendUaeft103Message(PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap) {
        try {
            String message = uaeftMT103MsgCore.constructUAEFT103Message(paymentMethodMessage, loanIQMap);
            savePaymentMessageOut(message, paymentMethodMessage, loanIQMap);
            updateStatusOfLoanIQOut(loanIQMap);
            jmsQueueSender.sendMessage(message);
        } catch (Exception e) {
            System.out.println("Message with id " + loanIQMap.get("imt_rid_imt_out") + " failed with error");
            e.printStackTrace();
        }
    }

    @Override
    public void savePaymentMessageOut(String message, PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap) {

        PaymentMessageOutput paymentMessageOutput = new PaymentMessageOutput(new UniqueIDGenerator().generateID(), message, paymentMethodMessage.getPaymentMethodMessageId(),
                (String) loanIQMap.get("imt_rid_imt_out"), MessageOutputStatus.SENT, LocalDateTime.now(), "ADMIN", LocalDate.now());

        paymentMessageOutputService.save(paymentMessageOutput);
    }

    @Override
    public void updateStatusOfLoanIQOut(Map<String, Object> loanIQMap) {
        loanIQOutView.updateLoanIQOutStatus("DELV", (String) loanIQMap.get("imt_rid_imt_out"));
    }

}
