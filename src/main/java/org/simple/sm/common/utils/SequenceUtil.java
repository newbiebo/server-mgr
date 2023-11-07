package org.simple.sm.common.utils;

import java.util.UUID;

public class SequenceUtil {

    // todo Later upgrade to Snowflake ID
    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
