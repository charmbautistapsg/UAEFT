/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.repositories.LoanIQExtAtr;
import com.psglobal.uaeftmt103.repositories.Queries.PaymentQueries;
import com.psglobal.uaeftmt103.repositories.mapper.LoanIQAtrMapper;

@Repository
public class LoanIQAtrImpl implements LoanIQExtAtr {

    final JdbcTemplate jdbcTemplate;

    LoanIQAtrImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getExtAtr(String strFieldName, String strImtRid,
                                               String strImtOwnerType, Boolean isOwnerTypeOtr) {
        String query = isOwnerTypeOtr ? PaymentQueries.queryForOst : PaymentQueries.queryExtAtr;

        return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, strFieldName);
                ps.setString(2, strImtOwnerType);
                ps.setString(3, strImtRid);

            }
        }, new LoanIQAtrMapper());
    }

    @Override
    public List<Map<String, Object>> getOstRid(String strOtrRid) {
        return jdbcTemplate.query(PaymentQueries.queryOstRid, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, strOtrRid);
            }
        }, new LoanIQAtrMapper());

    }
}
