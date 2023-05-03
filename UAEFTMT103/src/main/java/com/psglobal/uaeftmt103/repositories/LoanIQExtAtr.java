package com.psglobal.uaeftmt103.repositories;

import java.util.List;
import java.util.Map;

public interface LoanIQExtAtr {

    List<Map<String, Object>> getExtAtr(String strFieldName, String strImtRid,
                                        String strImtOwnerType, Boolean isOwnerTypeOtr);

    List<Map<String, Object>>  getOstRid(String strOtrRid);
}
