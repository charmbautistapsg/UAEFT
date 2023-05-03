/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 */

/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.domain;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
//@Entity(name = "TPI_PAYMENT_SUB_FIELDS")
public class PaymentMethodSubFields {

    //@Id
    //@Column(name = "PSF_RID_PAYMENT_SUB_FIELDS")
    private String paymentMessageSubFieldsId;

    //@Column(name = "PSF_TXT_SUB_FIELD_NAME")
    private String subFieldName;

    //@Column(name = "PSF_TXT_SUB_FIELD_TYPE")
    private String subFieldType;

    //@Column(name = "PSF_TXT_SUB_FIELDS_VALUE")
    private String subFieldValue;

    //@Column(name = "PSF_TXT_SUB_FIELD_EXECUTABLE_TYPE")
    private String subFieldExecutableType;

    //@Column(name = "PSF_TXT_SUB_FIELD_EXECUTABLE_NAME")
    private String subFieldExecutableName;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "PMF_RID_MESSAGE_FORMAT")
    private PaymentMethodFormat paymentMethodFormat;

    //@Column(name = "PSF_UID_REC_CREATE_USERID")
    private String createUserId;

    //@Column(name = "PSF_UID_REC_UPDATE_USERID")
    private String updateUserId;

    //@Column(name = "PSF_TSP_REC_CREATE_TIMESTAMP")
    private String createTimeStamp;

    //@Column(name = "PSF_TSP_REC_UPDATE_TIMESTAMP")
    private String updateTimeStamp;

    //@Column(name = "PSF_CDE_REC_CREATE_COUNTRY")
    private String createCountry;

    //@Column(name = "PSF_CDE_REC_UPDATE_COUNTRY")
    private String updateCountry;

    //@Column(name = "PSF_CDE_REC_CREATE_LOCATION")
    private String createLocation;

    //@Column(name = "PSF_CDE_REC_UPDATE_LOCATION")
    private String updateLocation;

    //@Column(name = "PSF_TXT_REC_CREATE_IP")
    private String createIp;

    //@Column(name = "PSF_TXT_REC_UPDATE_IP")
    private String updateIp;


}
