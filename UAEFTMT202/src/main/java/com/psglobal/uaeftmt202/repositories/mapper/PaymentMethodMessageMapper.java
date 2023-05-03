package com.psglobal.uaeftmt202.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.psglobal.uaeftmt202.domain.PaymentMethodMessage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodMessageMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        PaymentMethodMessage paymentMethodMessage = new PaymentMethodMessage();

        paymentMethodMessage.setBranch(rs.getString("pmt_cde_payment_method"));
        paymentMethodMessage.setMessageType(rs.getString("pmt_cde_payment_message_type"));
        paymentMethodMessage.setMessageFormat(rs.getString("pmt_cde_payment_message_type_format"));
        paymentMethodMessage.setCurrency(rs.getString("pmt_cde_currency"));
        paymentMethodMessage.setBranch(rs.getString("pmt_cde_branch_code"));
        paymentMethodMessage.setPaymentMethodMessageId(rs.getString("pmt_rid_method_message_types"));

        return paymentMethodMessage;
    }
}
