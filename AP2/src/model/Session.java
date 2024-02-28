package model;

import controller.mainMVC;
import java.util.HashMap;
import java.util.Map;

public class Session {
    private static final Map<String, Object> sessionData = new HashMap<>();

    public static void setAttribute(String key, Object value) {
        sessionData.put(key, value);
    }

    public static Object getAttribute(String key) {
        return sessionData.get(key);
    }

    public static void invalidate() {
        sessionData.clear();
    }
}

