/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 */

package com.psglobal.uaeftmt103.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.domain.PaymentMethodMessage;

import java.util.UUID;

@Repository
public interface PaymentMethodMessageRepo extends JpaRepository<PaymentMethodMessage, UUID> {

    PaymentMethodMessage findByPaymentMethodAndMessageTypeAndMessageFormat(String paymentMethod,String messageType,String messageFormat);

}
