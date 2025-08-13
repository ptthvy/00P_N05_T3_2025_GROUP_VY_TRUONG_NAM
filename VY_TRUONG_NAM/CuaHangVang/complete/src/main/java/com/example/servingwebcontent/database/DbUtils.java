package com.example.servingwebcontent.database;

import java.sql.*;
import java.util.*;

/** Tiện ích nhỏ để map ResultSet -> List<Map<String,Object>> */
public class DbUtils {
    public static List<Map<String, Object>> toList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();
        while (rs.next()) {
            Map<String, Object> row = new LinkedHashMap<>();
            for (int i = 1; i <= cols; i++) {
                row.put(md.getColumnLabel(i), rs.getObject(i));
            }
            list.add(row);
        }
        return list;
    }
    public static Optional<Map<String, Object>> first(List<Map<String, Object>> list) {
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }
}

