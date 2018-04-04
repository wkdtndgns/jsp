
package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {

    int pg = 1;  // 현재 페이지

    int sb;      // search by
    String st;   // search text

    int recordCount;

    public String getQueryString() {
        String url = null;
        try {
            String temp = (st == null) ? "" : URLEncoder.encode(st, "UTF-8");
            url = String.format("pg=%d&sb=%d&st=%s", pg, sb, temp);
        } catch (UnsupportedEncodingException e) { }
        return url;
    }
}



