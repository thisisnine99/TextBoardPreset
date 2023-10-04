package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    static public String getDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
