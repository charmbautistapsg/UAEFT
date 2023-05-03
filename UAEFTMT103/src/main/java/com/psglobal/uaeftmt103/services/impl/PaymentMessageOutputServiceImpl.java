/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */


package com.psglobal.uaeftmt103.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.psglobal.uaeftmt103.commonutil.UniqueIDGenerator;
import com.psglobal.uaeftmt103.domain.PaymentMessageOutput;
import com.psglobal.uaeftmt103.repositories.PaymentMessageOutputRepo;
import com.psglobal.uaeftmt103.services.PaymentMessageOutputService;

import java.util.List;

@Service
public class PaymentMessageOutputServiceImpl implements PaymentMessageOutputService {

    final private PaymentMessageOutputRepo paymentMessageOutputRepo;
    final private UniqueIDGenerator idGenerator;

    PaymentMessageOutputServiceImpl(PaymentMessageOutputRepo paymentMessageOutputRepo, UniqueIDGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.paymentMessageOutputRepo = paymentMessageOutputRepo;
    }

    @Override
    public List<PaymentMessageOutput> findAll() {
        return paymentMessageOutputRepo.findAll();
    }

    @Override
    public PaymentMessageOutput findById(String id) {
        return paymentMessageOutputRepo.findById(id).orElse(null);
    }

    @Override
    public PaymentMessageOutput save(PaymentMessageOutput entity) {
        entity.setOutputMessageId(idGenerator.generateID());
        return paymentMessageOutputRepo.save(entity);
    }

    @Override
    public PaymentMessageOutput update(PaymentMessageOutput entity) {
        return paymentMessageOutputRepo.save(entity);
    }

    public Page<PaymentMessageOutput> findAllWithPagination(int offset, int pageSize) {
        Page<PaymentMessageOutput> entities = paymentMessageOutputRepo.findAll(PageRequest.of(offset, pageSize));
        return entities;
    }

    public Page<PaymentMessageOutput> findAllWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<PaymentMessageOutput> entities = paymentMessageOutputRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return entities;
    }


    @Override
    public PaymentMessageOutput findPaymentMessageOutputByOutputSourceId(String outputSourceId) {
        return paymentMessageOutputRepo.findPaymentMessageOutputByOutputSourceId(outputSourceId);
    }
}
