package com.example.ad.util;

import java.util.UUID;
/**
 * @author 林雨欣
 */
public class UUIDUtils {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
