/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
//@Entity(name ="TPI_PAYMENT_MESSAGE_FORMAT")
public class PaymentMethodFormat {

    //@Id
    ////@Column(name = "PMF_RID_MESSAGE_FORMAT")
    private String paymentMessageFormatId;

    //@Column(name = "PMF_TXT_FIELD_NAME")
    private String fieldsName;

    //@Column(name = "PMF_TXT_FIELD_TYPE")
    private String fieldType;

    //@Column(name = "PMF_TXT_FIELDS_VALUE")
    private String fieldValue;

    //@Column(name = "PMF_TXT_FIELD_EXECUTABLE_TYPE")
    private String fieldExecutableType;

    //@Column(name = "PMF_TXT_FIELD_EXECUTABLE_NAME")
    private String fieldExecutableName;

    //@Column(name = "PMF_CDE_BLOCK_ID")
    private String blockId;

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethodFormat" , fetch = FetchType.EAGER)
    private Set<PaymentMethodSubFields> paymentMessageSubFields=new HashSet<>();;

   // @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "PMT_RID_METHOD_MESSAGE_TYPES")
    private PaymentMethodMessage paymentMethodMessage;

    //@Column(name = "PMF_UID_REC_CREATE_USERID")
    private String createUserId;

    //@Column(name = "PMF_UID_REC_UPDATE_USERID")
    private String updateUserId;

    //@Column(name = "PMF_TSP_REC_CREATE_TIMESTAMP")
    private String createTimeStamp;

    //@Column(name = "PMF_TSP_REC_UPDATE_TIMESTAMP")
    private String updateTimeStamp;

    //@Column(name = "PMF_CDE_REC_CREATE_COUNTRY")
    private String createCountry;

    //@Column(name = "PMF_CDE_REC_UPDATE_COUNTRY")
    private String updateCountry;

    //@Column(name = "PMF_CDE_REC_CREATE_LOCATION")
    private String createLocation;

    //@Column(name = "PMF_TXT_REC_CREATE_IP")
    private String createIp;

    //@Column(name = "PMF_TXT_REC_UPDATE_IP")
    private String updateIp;

    //@Column(name="PMF_CDE_REC_UPDATE_LOCATION")
    private String updateLocation;


}
