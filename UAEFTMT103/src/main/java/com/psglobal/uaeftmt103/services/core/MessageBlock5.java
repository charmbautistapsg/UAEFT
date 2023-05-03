/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.services.core;

import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftBlock5Field;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.psglobal.uaeftmt103.constants.BLock5Constants;
import com.psglobal.uaeftmt103.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt103.services.util.MessageUtil;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageBlock5 {

    private static final String BLOCK5 = "5";
    final MessageUtil messageUtil;

    MessageBlock5(MessageUtil messageUtil) {
        this.messageUtil = messageUtil;
    }

    void constructBlock5(Set<PaymentMethodFormat> paymentMethodFormatList, MT103 mt103, Map<String, Object> loanIQMap) {

        List<PaymentMethodFormat> block5ValueList = paymentMethodFormatList.stream().filter(a -> a.getBlockId().equalsIgnoreCase(BLOCK5)).collect(Collectors.toList());

        if (block5ValueList != null && !block5ValueList.isEmpty()) {

            SwiftBlock5 swiftBlock5 = mt103.getSwiftMessage().getBlock5();

            messageUtil.getPaymentMethodFormat(block5ValueList, BLock5Constants.CHK.getValue(), loanIQMap)
                    .ifPresent(a -> swiftBlock5.setTag(SwiftBlock5Field.CHK, (String) a));

            messageUtil.getPaymentMethodFormat(block5ValueList, BLock5Constants.TNG.getValue(), loanIQMap)
                    .ifPresent(a -> swiftBlock5.setTag(SwiftBlock5Field.TNG, (String) a));

            messageUtil.getPaymentMethodFormat(block5ValueList, BLock5Constants.PDE.getValue(), loanIQMap)
                    .ifPresent(a -> swiftBlock5.setTag(SwiftBlock5Field.PDE, constructPDEAndPDM(loanIQMap, mt103)));

            messageUtil.getPaymentMethodFormat(block5ValueList, BLock5Constants.PDM.getValue(), loanIQMap)
                    .ifPresent(a -> swiftBlock5.setTag(SwiftBlock5Field.PDM, constructPDEAndPDM(loanIQMap, mt103)));
        }
    }

    private String constructPDEAndPDM(Map loanIQMap, MT103 mt103) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HHmm");

        Object createdDate = loanIQMap.get("imt_tsp_rec_create");

        StringBuffer str = new StringBuffer();

        str.append(timeFormatter.format(createdDate));
        str.append(dateFormatter.format(createdDate));
        str.append(mt103.getSwiftMessage().getBlock1().getLogicalTerminal());
        str.append(mt103.getSwiftMessage().getBlock1().getSessionNumber());
        str.append(mt103.getSwiftMessage().getBlock1().getSequenceNumber());

        return str.toString();
    }
}
