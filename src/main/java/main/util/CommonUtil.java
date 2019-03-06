package main.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public static Map<String, Integer> loginTable = new HashMap<>();

    public static Map<String, Object> getResult() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("message", "success");
        return result;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    public static String replaceBlank(String str) {

        String dest = "";
        /*正则表达式是一个可以用于匹配字符串的模版， 可以匹配一批字符串， 所以创建正则表达式就是创建一个特殊的字符串*/
        if (str != null) {
            /* | :指定两项之间任选一项
            * \t :制表符
            * \r:回车符
            * \n:换行符 */
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
