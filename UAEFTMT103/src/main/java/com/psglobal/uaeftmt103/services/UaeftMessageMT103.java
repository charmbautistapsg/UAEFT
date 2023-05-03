/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 */

package com.psglobal.uaeftmt103.services;

import java.util.List;
import java.util.Map;

import com.psglobal.uaeftmt103.config.UaeftMT130Configuration;
import com.psglobal.uaeftmt103.domain.PaymentMethodMessage;

public interface UaeftMessageMT103 {
	
    PaymentMethodMessage getUaeftMT103MessageFormat();

    List<Map<String, Object>> getAllLoanIQOutData(UaeftMT130Configuration uaeftMT130Configuration);

    void constructAndSendUaeft103Message(PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap);
    
    void savePaymentMessageOut(String message,PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap);

    void updateStatusOfLoanIQOut(Map<String, Object> loanIQMap);
}
