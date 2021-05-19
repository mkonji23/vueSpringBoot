package com.common.util;
import java.util.HashMap;

import org.springframework.jdbc.support.JdbcUtils;

@SuppressWarnings("serial")
public class CamelMap extends HashMap<String, Object> {

    @Override
    public Object put(String key, Object value) {
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(key), value);
    }
    
}