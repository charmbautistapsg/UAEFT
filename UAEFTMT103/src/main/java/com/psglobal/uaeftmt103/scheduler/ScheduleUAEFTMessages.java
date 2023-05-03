/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.psglobal.uaeftmt103.config.UaeftMT130Configuration;
import com.psglobal.uaeftmt103.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt103.services.UaeftMessageMT103;
import com.psglobal.uaeftmt103.services.core.UaeftMT103MsgCore;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ScheduleUAEFTMessages {
    final UaeftMessageMT103 uaeftMessageMT103;
    final UaeftMT130Configuration uaeftMT130Configuration;

    PaymentMethodMessage paymentMethodMessage;

    public ScheduleUAEFTMessages(UaeftMessageMT103 uaeftMessageMT103, UaeftMT130Configuration uaeftMT130Configuration, UaeftMT103MsgCore uaeftMT103MsgCore) {
        this.uaeftMessageMT103 = uaeftMessageMT103;
        this.uaeftMT130Configuration = uaeftMT130Configuration;
    }

    @Scheduled(initialDelay = 12, fixedDelay = 30000)
    public void composeAndSendUaeftMT103() {
        log.info("scheduler started ");

        List<Map<String, Object>> loanIdMap = uaeftMessageMT103.getAllLoanIQOutData(uaeftMT130Configuration);

        if (paymentMethodMessage == null) {
            paymentMethodMessage = uaeftMessageMT103.getUaeftMT103MessageFormat();
        }
        loanIdMap.stream().forEach(q -> uaeftMessageMT103.constructAndSendUaeft103Message(paymentMethodMessage, q));

        log.info("scheduler stopped ");
    }
}
