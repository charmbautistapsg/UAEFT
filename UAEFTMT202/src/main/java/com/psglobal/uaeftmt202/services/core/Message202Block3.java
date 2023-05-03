/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */
package com.psglobal.uaeftmt202.services.core;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.mt2xx.MT202;
import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt202.services.util.MessageUtil202;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class Message202Block3 {
    private static final String BLOCK3 = "3";
    final MessageUtil202 messageUtil;

    Message202Block3(MessageUtil202 messageUtil) {
        this.messageUtil = messageUtil;
    }

    void constructBlock3(Set<PaymentMethodFormat> paymentMethodFormatList, MT202 mt202, Map<String, Object> loanIQMap) {

        List<PaymentMethodFormat> block3ValueList = paymentMethodFormatList.stream().filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK3)).collect(Collectors.toList());
        List<Tag> block3List = new ArrayList<>();
        Optional<?> tag103 = messageUtil.getPaymentMethodFormat(block3ValueList, "tag103", loanIQMap);

        tag103.ifPresent(a -> block3List.add(new Tag("103", (String) a)));

        mt202.getSwiftMessage().getBlock3().addTags(block3List);
    }

}
