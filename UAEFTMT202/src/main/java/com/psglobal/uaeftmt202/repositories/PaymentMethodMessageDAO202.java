package com.psglobal.uaeftmt202.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;
import com.psglobal.uaeftmt202.domain.PaymentMethodMessage;
import com.psglobal.uaeftmt202.domain.PaymentMethodSubFields;
import com.psglobal.uaeftmt202.repositories.mapper.PaymentMethodMessageMapper;
import com.psglobal.uaeftmt202.repositories.mapper.PaymentMethosFormatMapper;
import com.psglobal.uaeftmt202.repositories.mapper.PaymentmethodSubMapper;

@Repository
public class PaymentMethodMessageDAO202 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PaymentMethodMessage getPaymentConfig(String paymentMethod, String messageType, String messageFormat) {
        PaymentMethodMessage paymentMethodMessage = null;
        String query = "select * from TPI_PAYMENT_METHOD_MESSAGE_TYPES where pmt_cde_payment_method=? and pmt_cde_payment_message_type_format=? \n" +
                "and pmt_cde_payment_message_type=? ; ";

        String queryType = "select * from TPI_PAYMENT_MESSAGE_FORMAT where pmt_rid_method_message_types=?;";

        String querySub="select * from TPI_PAYMENT_SUB_FIELDS where pmf_rid_message_format=? ;";

        List<PaymentMethodMessage> paymentMethodMessageLst = jdbcTemplate.
                query(query, new PaymentMethodMessageMapper(), new Object[]{paymentMethod, messageType, messageFormat});

        if (!paymentMethodMessageLst.isEmpty()) {
            paymentMethodMessage = paymentMethodMessageLst.get(0);
            List<PaymentMethodFormat> paymentMethodFormatList = (List<PaymentMethodFormat>) jdbcTemplate.
                    query(queryType, new PaymentMethosFormatMapper(), new Object[]{paymentMethodMessage.getPaymentMethodMessageId()});
            paymentMethodMessage.setPaymentMessageFormat(paymentMethodFormatList.stream().collect(Collectors.toSet()));

            List<PaymentMethodFormat> subList=paymentMethodFormatList.stream().filter(a->a.getFieldType().equals("sub")).collect(Collectors.toList());
            for (PaymentMethodFormat paymentMethodFormat : subList) {
                List<PaymentMethodSubFields> sub=jdbcTemplate.query(querySub,new PaymentmethodSubMapper(),new Object[]{paymentMethodFormat.getPaymentMessageFormatId()});
                paymentMethodFormat.setPaymentMessageSubFields(sub.stream().collect(Collectors.toSet()));
            }


        }

        return paymentMethodMessage;
    }
}
