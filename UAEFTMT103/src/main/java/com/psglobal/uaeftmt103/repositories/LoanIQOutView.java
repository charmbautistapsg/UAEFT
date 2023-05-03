package com.psglobal.uaeftmt103.repositories;

import java.util.List;
import java.util.Map;

public interface LoanIQOutView {
    List<Map<String, Object>> getAllLoanIQOutData(String messageType, String messageStatus);

    void updateLoanIQOutStatus(String status, String loanIQId);
}
