/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity(name = "TPI_PAYMENT_METHOD_MESSAGE_TYPES")
public class PaymentMethodMessage {


    @Id
    @Column(name = "PMT_RID_METHOD_MESSAGE_TYPES")
    private String paymentMethodMessageId;

    @Column(name = "PMT_CDE_BRANCH_CODE")
    private String branch;

    @Column(name = "PMT_CDE_CURRENCY")
    private String currency;

    @Column(name = "PMT_CDE_PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PMT_CDE_PAYMENT_MESSAGE_TYPE")
    private String messageType;

    @Column(name = "PMT_CDE_PAYMENT_MESSAGE_TYPE_FORMAT")
    private String messageFormat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethodMessage", fetch = FetchType.EAGER)
    private Set<PaymentMethodFormat> paymentMessageFormat = new HashSet<>();

    @Column(name = "PMT_UID_REC_CREATE_USERID")
    private String createUserId;

    @Column(name = "PMT_UID_REC_UPDATE_USERID")
    private String updateUserId;

    @Column(name = "PMT_TSP_REC_CREATE_TIMESTAMP")
    private String createTimeStamp;

    @Column(name = "PMT_TSP_REC_UPDATE_TIMESTAMP")
    private String updateTimeStamp;

    @Column(name = "PMT_CDE_REC_CREATE_COUNTRY")
    private String createCountry;

    @Column(name = "PMT_CDE_REC_UPDATE_COUNTRY")
    private String updateCountry;

    @Column(name = "PMT_CDE_REC_CREATE_LOCATION")
    private String createLocation;

    @Column(name = "PMT_TXT_REC_CREATE_IP")
    private String createIp;

    @Column(name = "PMT_TXT_REC_UPDATE_IP")
    private String updateIp;

    @Column(name = "PMT_CDE_REC_UPDATE_LOCATION")
    private String updateLocation;

}
