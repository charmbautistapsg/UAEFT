/**
 * Author: Sylvanus Ikpugbu
 * Company: PSGlobal
 * Purpose: Payment message output interface. specifies methods to be implemented
 */

package com.psglobal.uaeftmt103.services;

import org.springframework.data.domain.Page;

import com.psglobal.uaeftmt103.domain.PaymentMessageOutput;

import java.util.List;

public interface PaymentMessageOutputService {
	
	public Page<PaymentMessageOutput> findAllWithPagination(int offset, int pageSize);
	
	public Page<PaymentMessageOutput> findAllWithPaginationAndSorting(int offset,int pageSize,String field);

	public List<PaymentMessageOutput> findAll();
	
	public PaymentMessageOutput findById(String id);
	
	public PaymentMessageOutput save(PaymentMessageOutput entity);	
	
	public PaymentMessageOutput update(PaymentMessageOutput entity);
	
	public PaymentMessageOutput findPaymentMessageOutputByOutputSourceId(String outputSourceId);
}
