/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 * Description : This payment service is developed to support Different payment forms like
 *
 * SWIFT MT 103
 * SWIFT MT 202
 * UAEFT MT 103
 * UAEFT MT 202
 *
 */

package com.psglobal.uaeftmt103;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class UaeftMt103Application {

	public static void main(String[] args) {
		SpringApplication.run(UaeftMt103Application.class, args);
	}

}
