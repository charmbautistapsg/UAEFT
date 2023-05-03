/**
 * Author: Shanawaj Khan
 * Company: PSGlobal
 * Purpose: UAEFT MT202 message implementation  .
 * Company: PS Global
 * Version : 1
 * Date :27/April/2023
 */

package com.psglobal.uaeftmt202.repositories.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psglobal.uaeftmt202.repositories.LoanIQOutView202;

@Repository
public class LoanIQOutViewImpl202 implements LoanIQOutView202 {
    final JdbcTemplate jdbcTemplate;

    LoanIQOutViewImpl202(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public void updateLoanIQOutStatus(String status, String loanIQId) {
//        jdbcTemplate.update(PaymentQueries.updateQuery, status, loanIQId);
//    }
}

