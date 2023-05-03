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
import com.psglobal.uaeftmt103.services.util.MessageUtil;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageBlock1 {


    private static final String BLOCK1 = "1";
    final MessageUtil messageUtil;

    MessageBlock1(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    void constructBlock1(Set<PaymentMethodFormat> paymentMethodFormatList, MT103 mt130, Map<String, Object> loanIQMap) {
        List<PaymentMethodFormat> block1List = paymentMethodFormatList.stream().filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK1)).collect(Collectors.toList());

        messageUtil.getPaymentMethodFormat(block1List, "applicationId", loanIQMap).ifPresent(a -> mt130.getSwiftMessage().getBlock1().setApplicationId((String) a));

        messageUtil.getPaymentMethodFormat(block1List, "serviceId", loanIQMap).ifPresent(a -> mt130.getSwiftMessage().getBlock1().setServiceId((String) a));

        Optional ltAddress = messageUtil.getPaymentMethodFormat(block1List, "logicalTerminalAddress", loanIQMap);
        if (ltAddress.isPresent()) {
            String ltAddressStr = messageUtil.padXToString((String) ltAddress.get());
            mt130.getSwiftMessage().getBlock1().setLogicalTerminal(ltAddressStr);
        }
        Optional sessionNumber = messageUtil.getPaymentMethodFormat(block1List, "sessionNumber", loanIQMap);
        mt130.getSwiftMessage().getBlock1().setSessionNumber((String) sessionNumber.orElseGet(() -> messageUtil.generateRandomFourNumber()));

        Optional sequenceNumber = messageUtil.getPaymentMethodFormat(block1List, "sequenceNumber", loanIQMap);
        mt130.getSwiftMessage().getBlock1().setSequenceNumber((String) sequenceNumber.orElseGet(() -> messageUtil.generateRandomSixNumber()));

    }
}
