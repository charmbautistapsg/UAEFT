/**
 * Author: Sylvanus Ikpugbu
 * Company: PSGlobal
 * Purpose: Repository interface for Payment message output
 */

package com.psglobal.uaeftmt103.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.domain.PaymentMessageOutput;

@Repository
public interface PaymentMessageOutputRepo extends JpaRepository<PaymentMessageOutput, String>
{
	@Query("select u from PaymentMessageOutput u where u.outputSourceId = :outputSourceId")
	public PaymentMessageOutput findPaymentMessageOutputByOutputSourceId(@Param("outputSourceId") String outputSourceId);

}
