package com.showTime.aiservice.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class IdGenerationUtil {

    public static  String generateUserIdentifier(String fName){
        return "US_"+fName.substring(0,2).toLowerCase()+ LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public static  String generateMovieIdentifier(String m_name){
        return "MO_"+m_name.substring(0,2).toLowerCase()+ LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}
