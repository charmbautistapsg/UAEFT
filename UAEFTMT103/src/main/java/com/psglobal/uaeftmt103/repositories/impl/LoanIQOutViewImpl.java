/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT103 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt103.repositories.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt103.repositories.LoanIQOutView;
import com.psglobal.uaeftmt103.repositories.Queries.PaymentQueries;
import com.psglobal.uaeftmt103.repositories.mapper.LoanIQOutRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class LoanIQOutViewImpl implements LoanIQOutView {


    final JdbcTemplate jdbcTemplate;

    LoanIQOutViewImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllLoanIQOutData(String messageType,String messageStatus) {
        log.info("getAllLoanIQOutData start ");

        return jdbcTemplate.query(new PaymentQueries().LoanIQOutQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, messageStatus);
                ps.setString(2, messageType);
            }
        }, new LoanIQOutRowMapper());
    }

    @Override
    public void updateLoanIQOutStatus(String status, String loanIQId) {
        jdbcTemplate.update(PaymentQueries.updateQuery,new Object[]{status,loanIQId});
    }


}

