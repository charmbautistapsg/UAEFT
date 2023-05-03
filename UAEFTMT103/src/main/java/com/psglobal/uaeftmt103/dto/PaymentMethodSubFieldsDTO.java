
/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 */

package com.psglobal.uaeftmt103.dto;


/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodSubFieldsDTO {

    public String paymentMessageSubFieldsPK;
    public String subFieldName;
    public String subFieldType;
    public String subFieldValue;
    public String subFieldExecutableType;
    public String subFieldExecutableName;
    public String createUserId;
    public String updateUserId;
    public String createTimeStamp;
    public String updateTimeStamp;
    public String createCountry;
    public String updateCountry;
    public String createLocation;
    public String createIp;
    public String updateIp;
}
