/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "uaeftmt202")
public class UaeftConfiguration202 {

    public int interval;
    public int length;
    public String messageType;
    public String messageStatus;
}
