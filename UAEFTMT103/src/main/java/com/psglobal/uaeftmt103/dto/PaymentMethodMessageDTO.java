/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.dto;

import java.util.ArrayList;


public class PaymentMethodMessageDTO {

    public String branch;
    public String currency;
    public String paymentMethod;
    public String messageType;
    public String messageFormat;
    public ArrayList<PaymentMethodFormatDTO> paymentMessageFormat;

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
