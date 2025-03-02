package io.github.snoozy10.softwarepatterns;

import java.util.HashMap;
import java.util.Map;

// Simplified HttpRequest class for demonstration
public class HttpRequest {
    private Map<String, String> headers;
    private Map<String, String> cookies;

    public HttpRequest() {
        this.headers = new HashMap<>();
        this.cookies = new HashMap<>();
    }

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void addCookie(String name, String value) {
        cookies.put(name, value);
    }

    public String getCookie(String name) {
        return cookies.get(name);
    }

    public Map<String, String> getCookies() {
        return cookies;
    }
}
