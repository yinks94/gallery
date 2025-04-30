package kr.ink94.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtils {

    public static void setSession(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public static Object getSessionValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public static void removeSession(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
