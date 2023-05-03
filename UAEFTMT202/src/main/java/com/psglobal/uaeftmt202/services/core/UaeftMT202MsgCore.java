/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.services.core;

import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt202.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt202.services.util.MessageUtil202;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class UaeftMT202MsgCore {
    final MessageUtil202 messageUtil;
    final Message202Block1 messageBlock1;
    final Message202Block2 messageBlock2;
    final Message202Block3 messageBlock3;
    final Message202Block4 messageBlock4;
    final Message202Block5 messageBlock5;

    UaeftMT202MsgCore(Message202Block1 messageBlock1,
                      Message202Block2 messageBlock2,
                      Message202Block4 messageBlock4,
                      MessageUtil202 messageUtil,
                      Message202Block3 messageBlock3,
                      Message202Block5 messageBlock5

    ) {
        this.messageUtil = messageUtil;
        this.messageBlock1 = messageBlock1;
        this.messageBlock2 = messageBlock2;
        this.messageBlock3 = messageBlock3;
        this.messageBlock4 = messageBlock4;
        this.messageBlock5 = messageBlock5;
    }

    public String constructUaeft202Message(PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap) {
        log.info("loan Iq" + loanIQMap);

        MT202 mt202 = new MT202();
        Set<PaymentMethodFormat> paymentMethodFormatList = paymentMethodMessage.getPaymentMessageFormat();
        log.info("constructUaeft202Message called ");
        messageBlock1.constructBlock1(paymentMethodFormatList, mt202, loanIQMap);
        messageBlock2.constructBlock2(paymentMethodFormatList, mt202, loanIQMap);
        messageBlock3.constructBlock3(paymentMethodFormatList, mt202, loanIQMap);
        messageBlock4.constructBlock4(paymentMethodFormatList, mt202, loanIQMap);
        messageBlock5.constructBlock5(paymentMethodFormatList, mt202, loanIQMap);

        //log.info("message-->" + mt202.message());
        return mt202.message();
    }


}
