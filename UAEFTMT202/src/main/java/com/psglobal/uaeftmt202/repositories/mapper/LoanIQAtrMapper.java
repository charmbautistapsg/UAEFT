package com.psglobal.uaeftmt202.repositories.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoanIQAtrMapper implements RowMapper<Map<String,Object>> {
    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("key",rs.getString(1));
        return map;
    }
}
