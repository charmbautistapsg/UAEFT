/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 */

package com.psglobal.uaeftmt202.services;

import java.util.Map;

import com.psglobal.uaeftmt202.domain.PaymentMethodMessage;

public interface UaeftMessageMT202 {
	
    PaymentMethodMessage getUaeftMT202PaymentConfiguration();

    //List<Map<String, Object>> getAllLoanIQOutData(SwiftConfiguration uaeftMT130Configuration);

    void constructAndSendUaeft202Message(Map<String, Object> loanIQMap);
    
    void savePaymentMessageOut(String message,PaymentMethodMessage paymentMethodMessage, Map<String, Object> loanIQMap);

    //void updateStatusOfLoanIQOut(Map<String, Object> loanIQMap);
}