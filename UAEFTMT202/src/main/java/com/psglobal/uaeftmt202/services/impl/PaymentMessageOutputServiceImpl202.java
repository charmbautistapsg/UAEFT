/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */


package com.psglobal.uaeftmt202.services.impl;

import org.springframework.stereotype.Service;

import com.psglobal.uaeftmt202.commonutil.UniqueIDGenerator202;
import com.psglobal.uaeftmt202.services.PaymentMessageOutputService202;

@Service
public class PaymentMessageOutputServiceImpl202 implements PaymentMessageOutputService202 {

    //final private PaymentMessageOutputRepo paymentMessageOutputRepo;
    final private UniqueIDGenerator202 idGenerator;

    PaymentMessageOutputServiceImpl202(UniqueIDGenerator202 idGenerator) {
        this.idGenerator = idGenerator;
        //this.paymentMessageOutputRepo = paymentMessageOutputRepo;
    }

//    @Override
//    public List<PaymentMessageOutput> findAll() {
//        return paymentMessageOutputRepo.findAll();
//    }
//
//    @Override
//    public PaymentMessageOutput findById(String id) {
//        return paymentMessageOutputRepo.findById(id).orElse(null);
//    }

//    @Override
//    public PaymentMessageOutput save(PaymentMessageOutput entity) {
//        entity.setOutputMessageId(idGenerator.generateID());
//        return paymentMessageOutputRepo.save(entity);
//    }
//
//    @Override
//    public PaymentMessageOutput update(PaymentMessageOutput entity) {
//        return paymentMessageOutputRepo.save(entity);
//    }
//
//    public Page<PaymentMessageOutput> findAllWithPagination(int offset, int pageSize) {
//        Page<PaymentMessageOutput> entities = paymentMessageOutputRepo.findAll(PageRequest.of(offset, pageSize));
//        return entities;
//    }
//
//    public Page<PaymentMessageOutput> findAllWithPaginationAndSorting(int offset, int pageSize, String field) {
//        Page<PaymentMessageOutput> entities = paymentMessageOutputRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return entities;
//    }
//
//
//    @Override
//    public PaymentMessageOutput findPaymentMessageOutputByOutputSourceId(String outputSourceId) {
//        return paymentMessageOutputRepo.findPaymentMessageOutputByOutputSourceId(outputSourceId);
//    }
}
