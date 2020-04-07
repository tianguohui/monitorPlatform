package com.ph.monitorPlatform.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String createUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");
        return uuidString;
    }
}
