/**
 * Author: Sylvanus Ikpugbu
 * Company: PSGlobal
 * Purpose: Repository interface for Payment message acknowledgement
 */

package com.psglobal.uaeftmt103.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.domain.PaymentMessageAcknowledgement;

@Repository
public interface PaymentMessageAcknowledgementRepo extends JpaRepository<PaymentMessageAcknowledgement, String> {

}
