package hello.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CodeHeper {
    public static void main(String[] args) {
        System.out.println(CodeHeper.getNowDateTime());
        System.out.println(CodeHeper.getUUID());
    }
    public static String getBase64(String str){
        byte[] b=null;
        String s=null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(b!=null){
            s=new BASE64Encoder().encode(b);
        }
        return s;
    }
    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 将当前日期转换成yyyy-MM-dd的字符串格式
     *
     // @param date
     //@param templet
     * @return
     */
    public static String getDefalutNowDate() {
        return getDate(null, null);
    }

    /**
     * 将日期转换成yyyy-MM-dd的字符串格式
     *
     * @param //date
     * @param //templet
     * @return
     */
    public static String getDate(Date date) {
        return getDate(date, null);
    }

    /**
     * 将当前日期转换成的字符串格式
     *
     * @param //date
     * @param //templet
     * @return
     */
    public static String getDate(String templet) {
        return getDate(null, templet);
    }

    /**
     * 将当前时间日期转换成的字符串格式
     *
     * @param //date
     * @param //templet
     * @return
     */
    public static String getNowDateTime() {
        return getDate(null, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期转换成相应的字符串格式
     *
     * @param date
     * @param templet
     *            例如 yyyyMMddHHmmssSSS
     * @return
     */
    public static String getDate(Date date, String templet) {
        if (templet == null || templet.isEmpty()) {
            templet = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(templet);
        if (date != null) {
            return sdf.format(date);
        } else {
            return sdf.format(new Date());
        }
    }

    /**
     * 将字符串的stringDate 转换成 templet 格式的日期
     *
     * @param stringDate
     * @param templet
     *            （例如 yyyyMMddHHmmssSSS）
     * @return
     * @throws Exception
     */
    public static Date convertToDate(String stringDate, String templet)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(templet);
        Date date = null;
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new Exception("日期转换错误");
        }
        return date;
    }
    /**
     * 将字符串的stringDate 转换成 templet 格式的日期
     *
     * @param //stringDate
     * @param //templet
     *            （例如 yyyyMMddHHmmssSSS）
     * @return
     * @throws Exception
     */
    public static Date convertNowDate(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(getNowDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static String getTimeInterval(Date endtime, Date begintime) {
        String s = "";
        String interval = "";
        // 用现在距离1970年的时间间隔new
        // Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔
        long time = endtime.getTime() - begintime.getTime();// 得出的时间间隔是毫秒
        if (time / 1000 < 60 && time / 1000 > 0) {
            int se = (int) ((time % 60000) / 1000);
            interval = se + "秒";
        } else if (time / 60000 < 60 && time / 60000 > 0) {
            // 如果时间间隔小于60分钟则显示多少分钟前
            int m = (int) ((time % 3600000) / 60000);// 得出的时间间隔的单位是分钟\
            int mm = (int) (((time) - ((time % 3600000) / 60000) * 60000) % 60000 / 1000);
            interval = m + "分钟" + mm + "秒";
        } else if (time / 3600000 < 24 && time / 3600000 >= 0) {
            // 如果时间间隔小于24小时则显示多少小时前
            int h = (int) (time / 3600000);// 得出的时间间隔的单位是小时
            interval = h + "小时";

        }
        return interval;
    }

    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * long类型转换为String类型
     * @param currentTime 要转换的long类型的时间
     * @param formatType 要转换的string类型的时间格式
     * @return
     * @throws ParseException
     */
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    /**
     * string类型转换为date类型
     * @param strTime 要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
     * @param formatType HH时mm分ss秒，的时间格式必须要与formatType的时间格式相同
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * 转换为Date类型
     * @param currentTime 要转换的long类型的时间
     * @param formatType 要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * @return
     * @throws ParseException
     */
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    /**
     * strTime的时间格式和formatType的时间格式必须相同
     * @param strTime 要转换的String类型的时间
     * @param formatType 时间格式
     * @return strTime的时间格式和formatType的时间格式必须相同
     * @throws ParseException
     */
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    /**
     * date类型转换为long类型
     * @param date date要转换的date类型的时间
     * @return date类型转换为long类型
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
