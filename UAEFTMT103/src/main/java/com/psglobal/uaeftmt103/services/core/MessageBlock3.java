
/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */
package com.psglobal.uaeftmt103.services.core;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.psglobal.uaeftmt103.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt103.services.util.MessageUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MessageBlock3 {
    private static final String BLOCK3 = "3";
    final MessageUtil messageUtil;

    MessageBlock3(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    void constructBlock3(Set<PaymentMethodFormat> paymentMethodFormatList, MT103 mt130, Map<String, Object> loanIQMap) {

        List<PaymentMethodFormat> block3ValueList = paymentMethodFormatList.stream().filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK3)).collect(Collectors.toList());
        List<Tag> block3List = new ArrayList<>();
        Optional<?> tag103 = messageUtil.getPaymentMethodFormat(block3ValueList, "tag103", loanIQMap);

        tag103.ifPresent(a -> block3List.add(new Tag("103", (String) a)));

        mt130.getSwiftMessage().getBlock3().addTags(block3List);
    }


}
