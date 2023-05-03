package com.psglobal.uaeftmt202.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.psglobal.uaeftmt202.domain.PaymentMethodSubFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentmethodSubMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        PaymentMethodSubFields paymentMethodSubFields = new PaymentMethodSubFields();

        paymentMethodSubFields.setSubFieldName(rs.getString("psf_txt_sub_field_name"));
        paymentMethodSubFields.setSubFieldType(rs.getString("psf_txt_sub_field_type"));
        paymentMethodSubFields.setSubFieldValue(rs.getString("psf_txt_sub_fields_value"));
        paymentMethodSubFields.setPaymentMessageSubFieldsId(rs.getString("psf_rid_payment_sub_fields"));

        return paymentMethodSubFields;
    }
}
