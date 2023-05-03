/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 */


package com.psglobal.uaeftmt103.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.domain.PaymentMethodFormat;

import java.util.UUID;



@Repository
public interface PaymentMethodFormatRepo extends JpaRepository<PaymentMethodFormat, UUID> {
}
