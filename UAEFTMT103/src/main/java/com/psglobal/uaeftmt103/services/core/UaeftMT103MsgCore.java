/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.services.core;

import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.psglobal.uaeftmt103.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt103.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt103.services.util.MessageUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class UaeftMT103MsgCore {
    final MessageUtil messageUtil;
    final MessageBlock1 messageBlock1;
    final MessageBlock2 messageBlock2;
    final MessageBlock3 messageBlock3;
    final MessageBlock4 messageBlock4;
    final MessageBlock5 messageBlock5;

    UaeftMT103MsgCore(MessageBlock1 messageBlock1,
                      MessageBlock2 messageBlock2,
                      MessageBlock4 messageBlock4,
                      MessageUtil messageUtil,
                      MessageBlock3 messageBlock3,
                      MessageBlock5 messageBlock5

    ) {
        this.messageUtil = messageUtil;
        this.messageBlock1 = messageBlock1;
        this.messageBlock2 = messageBlock2;
        this.messageBlock3 = messageBlock3;
        this.messageBlock4 = messageBlock4;
        this.messageBlock5 = messageBlock5;
    }

    public String constructUAEFT103Message(PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap) {
        log.info("loan Iq" + loanIQMap);

        MT103 mt130 = new MT103();
        Set<PaymentMethodFormat> paymentMethodFormatList = paymentMethodMessage.getPaymentMessageFormat();

        messageBlock1.constructBlock1(paymentMethodFormatList, mt130, loanIQMap);
        messageBlock2.constructBlock2(paymentMethodFormatList, mt130, loanIQMap);
        messageBlock3.constructBlock3(paymentMethodFormatList, mt130, loanIQMap);
        messageBlock4.constructBlock4(paymentMethodFormatList, mt130, loanIQMap);
        messageBlock5.constructBlock5(paymentMethodFormatList, mt130, loanIQMap);

        log.info("message-->" + mt130.message());
        return mt130.message();
    }
}
