/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.services.core;

import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.field.Field202;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.psglobal.uaeftmt103.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt103.services.util.MessageUtil;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageBlock2 {

    private static final String BLOCK2 = "2";
    final MessageUtil messageUtil;

    MessageBlock2(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }


    void constructBlock2(Set<PaymentMethodFormat> paymentMethodFormatList, MT103 mt130, Map<String, Object> loanIQMap) {
        SwiftBlock2Input swiftBlock2Input = new SwiftBlock2Input();
        List<PaymentMethodFormat> block2List = paymentMethodFormatList
                .stream()
                .filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK2))
                .collect(Collectors.toList());

        if (messageUtil.getPaymentMethodFormat(block2List, "inputOutputId", loanIQMap)
                .equals(Optional.of("I"))) {
            swiftBlock2Input.setInput(true);
        } else if (messageUtil.getPaymentMethodFormat(block2List, "inputOutputId", loanIQMap)
                .equals(Optional.of("O"))) {
            swiftBlock2Input.setOutput(true);
        }

        Optional messageObj = messageUtil.getPaymentMethodFormat(block2List, "message", loanIQMap);
        if (messageObj.isPresent() && ((String) messageObj.get()).length() >= 5) {
            swiftBlock2Input.setMessageType(((String) messageObj.get()).substring(2, 5));
        }

        messageUtil.getPaymentMethodFormat(block2List, "messagePriority", loanIQMap).
                ifPresent(a -> swiftBlock2Input.setMessagePriority((String) a));

        messageUtil.getPaymentMethodFormat(block2List, "deliveryMonitoring", loanIQMap).
                ifPresent(a -> swiftBlock2Input.setDeliveryMonitoring((String) a));

        messageUtil.getPaymentMethodFormat(block2List, "obsolescencePeriod", loanIQMap).
                ifPresent(a -> swiftBlock2Input.setObsolescencePeriod((String) a));

        messageUtil.getPaymentMethodFormat(block2List, "destinationAddress", loanIQMap).
                ifPresent(a -> swiftBlock2Input.setReceiver((String) a));

        mt130.getSwiftMessage().setBlock2(swiftBlock2Input);

    }
}
