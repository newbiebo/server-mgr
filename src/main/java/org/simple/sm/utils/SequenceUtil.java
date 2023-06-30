package org.simple.sm.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class SequenceUtil {

    // todo Later upgrade to Snowflake ID
    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
