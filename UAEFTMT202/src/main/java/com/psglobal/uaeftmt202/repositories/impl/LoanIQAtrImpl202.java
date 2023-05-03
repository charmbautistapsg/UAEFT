/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt202.repositories.LoanIQExtAtr202;
import com.psglobal.uaeftmt202.repositories.mapper.LoanIQAtrMapper;

@Repository
public class LoanIQAtrImpl202 implements LoanIQExtAtr202 {

    final JdbcTemplate jdbcTemplate;

    @Value("${queries.queryForOst}")
    private String queryForOst;

    @Value("${queries.queryExtAtr}")
    private String queryExtAtr;

    @Value("${queries.queryOstRid}")
    private String queryOstRid;

    LoanIQAtrImpl202(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getExtAtr(String strFieldName, String strImtRid,
                                               String strImtOwnerType, Boolean isOwnerTypeOtr) {
        String query = isOwnerTypeOtr ? queryForOst : queryExtAtr;

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
        return jdbcTemplate.query(queryOstRid, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, strOtrRid);
            }
        }, new LoanIQAtrMapper());

    }
}
