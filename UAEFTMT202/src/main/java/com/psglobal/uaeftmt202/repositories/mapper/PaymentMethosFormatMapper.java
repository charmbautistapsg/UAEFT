package com.psglobal.uaeftmt202.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.psglobal.uaeftmt202.domain.PaymentMethodFormat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethosFormatMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        PaymentMethodFormat paymentMethodFormat= new PaymentMethodFormat();

        paymentMethodFormat.setBlockId(rs.getString("pmf_cde_block_id"));
        paymentMethodFormat.setPaymentMessageFormatId(rs.getString("pmf_rid_message_format"));
        paymentMethodFormat.setFieldsName(rs.getString("pmf_txt_field_name"));
        paymentMethodFormat.setFieldType(rs.getString("pmf_txt_field_type"));
        paymentMethodFormat.setFieldValue(rs.getString("pmf_txt_fields_value"));
        //paymentMethodFormat.setPaymentMethodMessage(rs.getString("pmf_txt_fields_value"));

        return paymentMethodFormat;
    }
}
