/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 */

/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodFormatDTO {

    public String paymentMessageFormatPK;
    public String fieldsName;
    public String fieldType;
    public String fieldValue;
    public String fieldExecutableType;
    public String fieldExecutableName;
    public String blockId;
    public String createUserId;
    public String updateUserId;
    public String createTimeStamp;
    public String updateTimeStamp;
    public String createCountry;
    public String updateCountry;
    public String createLocation;
    public String createIp;
    public String updateIp;

    public ArrayList<PaymentMethodSubFieldsDTO> paymentMessageSubFields;
}
