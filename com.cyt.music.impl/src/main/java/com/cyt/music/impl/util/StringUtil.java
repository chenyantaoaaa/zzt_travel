package com.cyt.music.impl.util;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 字符串工具类
 *
 * @author liyunfeng
 * @date 2016年4月11日-下午1:34:54
 */
public class StringUtil {

    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");

    private static Pattern numericStringPattern = Pattern.compile("^[0-9\\-\\-]+$");

    public static boolean isNull(String arg) {
        return arg == null ? true : false;
    }

    public static boolean isEmpty(String arg) {
        if (arg != null && !arg.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 判断两个字符串是否相等 如果都为null则判断为相等,一个为null另一个not null则判断不相等 否则如果s1=s2则相等
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equals(String s1, String s2) {
        if (StringUtil.isEmpty(s1) && StringUtil.isEmpty(s2)) {
            return true;
        } else if (!StringUtil.isEmpty(s1) && !StringUtil.isEmpty(s2)) {
            return s1.equals(s2);
        }
        return false;
    }

    public static boolean isNullStr(String arg) {
        return "null".equals(arg) ? true : false;
    }

    public static boolean isEmpty(Object str) {
        return null == str || "".equals(str.toString().trim());
    }

    public static boolean isLong(String s) {
        try {
            if (s != null && !"".equals(s.trim()))
                Long.parseLong(s);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    /**
     * 判断对象是否是Long
     *
     * @param obj
     *           判断对象
     * @param returnLong
     *           不是Long 类型返回值
     * @return
     */
    public static Long isLong(Object obj, Long returnLong) {
        try {
            String s = obj + "";
            if (s != null && !"".equals(s.trim()))
                return Long.parseLong(s);
        } catch (Exception exception) {
        }
        return returnLong;
    }

    public static Long converLong(Object obj) {
        try {
            String s = obj + "";
            if (s != null && !"".equals(s.trim()))
                return Long.parseLong(s);
        } catch (Exception exception) {
        }
        return null;
    }

    public static Integer converInteger(Object obj) {
        try {
            String s = obj + "";
            if (s != null && !"".equals(s.trim()))
                return Integer.valueOf(s);
        } catch (Exception exception) {
        }
        return null;
    }

    /**
     * 判断对象是否是Long
     *
     * @param obj
     *           判断对象
     * @return
     */
    public static Long isLong(Object obj) {
        return isLong(obj, null);
    }

    /**
     * 检查字符串不是null, "", "null"
     *
     * @param arg
     * @return true/非空, false/验证不通过
     */
    public static boolean isNotEmptyStr(String arg) {
        return !(isNull(arg) || isEmpty(arg) || isNullStr(arg)) ? true : false;
    }

    /**
     * 截取字符串后面部分字符.
     *
     * @param str
     * @param length
     *           表示双字节长度,比如4,表示返回的字符串长度为8字节.
     * @param addPoints
     * @return
     */
    public static String trimWords(String str, int length, boolean addPoints) {
        String wordStr = str;
        if (wordStr == null || wordStr.equals("")) {
            return "";
        }
        int byteLen = length * 2;
        byte[] strBytes = wordStr.getBytes();
        if (strBytes.length == str.length()) {
            if (strBytes.length <= byteLen) {
                return wordStr;
            }
            byte[] trimBytes = new byte[byteLen];
            System.arraycopy(strBytes, 0, trimBytes, 0, byteLen);
            wordStr = new String(trimBytes);
        } else {
            if (wordStr.length() <= length) {
                return str;
            }
            wordStr = left(str, length);
        }
        if (addPoints) {
            wordStr += "...";
        }
        return wordStr;
    }

    /**
     * 从左起取字符串前n位。
     *
     * @param str
     * @param length
     * @return
     */
    public static String left(String str, int length) {
        if (str == null) {
            throw new IllegalArgumentException("字符串参数值不能为null");
        }
        if (length < 0) {
            throw new IllegalArgumentException("整型参数长度不能小于0");
        }
        if (str.length() < length) {
            throw new IllegalArgumentException("字符串参数长度不能小于" + length);
        }
        return str.substring(0, length);
    }

    /**
     * 过滤html代码
     *
     * @param content
     * @return
     */
    public static String htmlContentConvert(String content) {
        content = content.replace("<", "&lt;");
        content = content.replace(">", "&gt;");
        content = content.replace("&", "&amp;");
        content = content.replace("\"", "&quot;");
        content = content.replace("'", "&apos;");
        content = content.replace("'", "&quot;");
        return content;
    }

    /**
     * 将数据库表字段字符串转换为驼峰标识字符串
     *
     * @param fieldName
     * @return
     */
    public static String convertField(String fieldName) {
        // check参数
        if (!isNotEmptyStr(fieldName)) {
            return null;
        }
        // buffer
        StringBuffer tmpData = new StringBuffer();
        // 转换为小写, 分割字符串
        // fieldName = fieldName.toLowerCase();
        String[] tmpDatas = fieldName.split("_");
        if ((null == tmpDatas) || (0 == tmpDatas.length)) {
            return null;
        }
        int length = tmpDatas.length;
        if (1 == length) {
            tmpData.append(tmpDatas[0]);
            return tmpData.toString();
        } else {
            String data = "";
            tmpData.append(tmpDatas[0]);
            for (int index = 1; index < length; index++) {
                data = tmpDatas[index];
                // 将第一个字母转换为大写
                if (StringUtils.isNotEmpty(data)) {
                    if (data.length() > 1) {
                        data = data.substring(0, 1).toUpperCase() + data.substring(1);
                    } else {
                        data = data.substring(0, 1).toUpperCase();
                    }
                }
                tmpData.append(data);
            }
        }
        return tmpData.toString();
    }

    /**
     * 将字符串的第index字符转换为大写
     *
     * @param data
     * @param index
     * @return
     */
    public static String convertString(String data, int index) {
        // check
        if (StringUtil.isNull(data) || StringUtil.isEmpty(data)) {
            return data;
        }
        // 字符串长度
        int length = data.length();
        if ((index < 0) || (length < index)) {
            return data;
        }
        // 取出第index字母并进行替换
        char beginOld = data.charAt(0);
        char beginNew = (beginOld + "").toUpperCase().charAt(0);
        data = data.replace(beginOld, beginNew);
        return data;
    }

    public static BigDecimal converBigDecimal(Object obj) {
        BigDecimal res = new BigDecimal(0);
        if (obj == null) {
            return res;
        }
        try {
            res = new BigDecimal(obj.toString());
        } catch (Exception e) {
            res = new BigDecimal(0);
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 判断是否数字表示
     *
     * @param src
     *           源字符串
     * @return 是否数字的标志
     */
    public static boolean isNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否数字表示
     *
     * @param src
     *           源字符串
     * @return 是否数字的标志
     */
    public static boolean isNumericString(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericStringPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断一个字符串是否是汉字
     *
     * @return true/是, false/不是
     */
    public static boolean isHanzi(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        return temp;
    }

    /**
     * 判断一个字符串是否是字母
     *
     * @return true/是, false/不是
     */
    public static boolean isZimu(String fstrData) {
        char c = fstrData.charAt(0);
        if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断一个字符串是否是整数数字，包括负数
     *
     * @param number
     * @return
     */
    public static boolean isInteger(String number) {
        String model = "-?[0-9]*";
        Pattern pattern = Pattern.compile(model);
        Matcher isNum = pattern.matcher(number);
        return isNum.matches();
    }

    /**
     * 判断字符串是否为 "" 或 null
     *
     * @param str
     * @return boolean true表示为 "" 或 null,false表示不为"" 或 null
     */
    public static boolean isBlank(String str) {
        return isNull(str) || str.trim().length() == 0 || str.trim().equals("null");
    }

    /**
     * 判断字符串是否是有效的商品编码
     *
     * @param upc
     * @return
     */
    public static boolean isValidUpc(String upc) {
        if (null != upc) {
            upc = upc.trim();
            if (upc.length() == 13 || upc.length() == 8) {
                if (upc.length() == 8) {
                    upc = "00000" + upc;
                }
                String code = upc.substring(0, 12);
                int sumj = 0, sume = 0;
                int result = 0;
                for (int i = 0; i < code.length() - 1; i = i + 2) {
                    sumj += code.charAt(i) - '0';
                    sume += code.charAt(i + 1) - '0';
                }
                result = sumj + sume * 3;
                result = result % 10;
                result = 10 - result;
                if (result == 10) {
                    result = 0;
                }
                String calUpc = code + result;
                return calUpc.equals(upc);
            }
        }
        return false;
    }

    /**
     * 获取字符串的非null格式,字符串为空则返回""
     *
     * @param str
     *           String
     * @return
     */
    public static String getStr(String str) {
        if (null == str) {
            return "";
        }
        return str;
    }

    /**
     * 判断多个字符串中是否有一个字符串为空
     *
     * @param strs
     * @return boolean 有一个字符串为空则或数组为空则返回true,反之,返回false
     */
    public static boolean hasBlankStr(String... strs) {
        if (null != strs) {
            for (String str : strs) {
                if (isBlank(str)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    /**
     * 随机生成销售流水单号
     *
     * @return
     */
    public static String generateRandId() {
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random rd = new Random();
        String n = "";
        int getNum;
        do {
            getNum = Math.abs(rd.nextInt()) % 10 + 48;// 产生数字0-9的随机数
            // getNum = Math.abs(rd.nextInt())%26 + 97;//产生字母a-z的随机数
            char num1 = (char) getNum;
            String dn = Character.toString(num1);
            n += dn;
        } while (n.length() < 6);
        return dateStr + n;
    }

    /**
     * 随机生成入库流水单号
     *
     * @return
     */
    public static String generatePurchaseRandId() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append('0' + rnd.nextInt(10));
        }
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ":" + sb.toString();
    }

    /**
     * 设置对象的字符串的默认值为""
     *
     * @return 若str为null,返回"",反之返回str
     */
    public static String defaultEmptyStr(Object obj) {
        return defaultStr(obj, null);
    }

    /**
     * 设置对象的字符串的默认值
     *
     * @param defaultStr
     * @return str为null,defaultStr不为null,返回defaultStr,反之返回"";否则返回str
     */
    public static String defaultStr(Object obj, String defaultStr) {
        if (null == obj) {
            if (null != defaultStr) {
                return defaultStr;
            } else {
                return "";
            }
        } else {
            return obj.toString();
        }
    }

    /**
     * 判断字符串是否是有效的会员卡号
     *
     * @param cardNum
     * @return
     */
    public static boolean isValidCardNum(String cardNum) {
        if (isBlank(cardNum) || !isInteger(cardNum) || cardNum.length() != 14) {
            return false;
        }
        // 过滤已经发放无规则邮掌柜会员卡
        String prefix = cardNum.substring(0, 2);
        String prefixStr = "45,47,35,23,36,33,34,13,00,14,37,12,21,43,42,41,51,52,62,61,50";
        List<String> prefixList = Arrays.asList(prefixStr.split(","));
        if (prefixList.contains(prefix)) {
            return true;
        }
        if (!cardNum.startsWith("800")) {
            return false;
        }
        try {
            Long k = Long.valueOf(cardNum.charAt(0) + "") * 1;
            k += Long.valueOf(cardNum.charAt(1) + "") * 2;
            k += Long.valueOf(cardNum.charAt(2) + "") * 3;
            k += Long.valueOf(cardNum.charAt(3) + "") * 4;
            k += Long.valueOf(cardNum.charAt(4) + "") * 5;
            k += Long.valueOf(cardNum.charAt(5) + "") * 6;
            k += Long.valueOf(cardNum.charAt(6) + "") * 7;
            k += Long.valueOf(cardNum.charAt(7) + "") * 8;
            k += Long.valueOf(cardNum.charAt(8) + "") * 9;
            k += Long.valueOf(cardNum.charAt(9) + "") * 10;
            k += Long.valueOf(cardNum.charAt(10) + "") * 11;
            k += Long.valueOf(cardNum.charAt(11) + "") * 12;
            k += Long.valueOf(cardNum.charAt(12) + "") * 13;
            Long key = k % 11 == 10 ? 0 : (k % 11);
            if (key.equals(Long.valueOf(cardNum.charAt(13) + ""))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @description: 字符串首字母大写
     *
     * @param str
     * @return
     */
    public static String captureName(String str) {
        // name = name.substring(0, 1).toUpperCase() + name.substring(1);
        // return name;
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String genRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    public static String trim(String s) {
        if (null != s) {
            s = s.trim();
        }
        return s;
    }

    public static String getShortStr(String s) {
        if (s.length() > 100) {
            s.subSequence(0, 100);
        }
        return s;
    }

    /**
     * 对象null 转为""
     *
     * @param object
     * @return
     */
    public static String convertNull(Object object) {
        if (object == null)
            return "";
        return object.toString();
    }

    /**
     * 获取远程地址
     *
     * @param request
     * @return
     */
    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static void main(String[] args) {
    }

    /**
     * Doubel类型转String
     *
     * @param d
     * @return
     */
    public static String doubleConversionString(Double d) {
        String s = "0.00";

        if (null != d) {
            DecimalFormat df = new DecimalFormat("#####0.00");
            s = df.format(d);
        }

        return s;
    }

    public static String columnToProperty(String column) {
        StringBuilder result = new StringBuilder();

        if (StringUtils.isNotBlank(column)) {
            String[] columns = column.split("_");
            for (int i = 0; i < columns.length; i++) {
                String columnSplit = columns[i].toLowerCase();
                if (i > 0)
                    columnSplit = columnSplit.substring(0, 1).toUpperCase() + columnSplit.substring(1);
                result.append(columnSplit);
            }
        }

        return result.toString();
    }

    /**
     * 获取随机字符串 a-z,A-Z,0-9
     *
     * @param length
     *           长度
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);// [0,62)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String compatibleHTTPS(String sourceStr) {
        if (sourceStr != null) {
            return sourceStr.replaceAll("http:", "https:");
        }
        return sourceStr;
    }

    public static Object compatibleHTTPS(Object sourceStr) {
        if (sourceStr != null) {
            return sourceStr.toString().replaceAll("http:", "https:");
        }
        return sourceStr;
    }

    /**
     * app 方式调用 接口
     * @param request
     * @return
     */
    public static boolean isAPPCall(HttpServletRequest request) {
        try {
            String clentCallType = request.getParameter("clientCallType");
            return "APP".equalsIgnoreCase(clentCallType);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * h5 方式调用 接口
     * @param request
     * @return
     */
    public static boolean isH5Call(HttpServletRequest request) {
        try {
            String clentCallType = request.getParameter("clientCallType");
            return "H5".equalsIgnoreCase(clentCallType);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * jsonp 转为 json
     * @param jsonp
     * @return
     */
    public static String jsonpToJson(String jsonp) {
        if (isNotEmptyStr(jsonp)) {
            if ((jsonp.indexOf("(") < jsonp.indexOf("{") || jsonp.indexOf("(") < jsonp.indexOf("["))
                    && jsonp.indexOf("(") > -1 && jsonp.lastIndexOf(")") > -1)
                jsonp = jsonp.substring(jsonp.indexOf("(") + 1, jsonp.lastIndexOf(")"));
            return jsonp;
        }
        return jsonp;
    }
}