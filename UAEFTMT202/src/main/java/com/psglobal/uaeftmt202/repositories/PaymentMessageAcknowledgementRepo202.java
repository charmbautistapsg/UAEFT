/**
 * Author: Sylvanus Ikpugbu
 * Company: PSGlobal
 * Purpose: Repository interface for Payment message acknowledgement
 */

package com.psglobal.uaeftmt202.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt202.domain.PaymentMessageAcknowledgement;

@Repository
public interface PaymentMessageAcknowledgementRepo202 extends JpaRepository<PaymentMessageAcknowledgement, String> {

}
