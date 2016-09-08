package com.ttyooyu.market.utils;

/**
 * Created by Administrator on 2016/1/4.
 */
public class PhoneNumberUtils {

    /*
     * 移动: 2G号段(GSM网络)有139,138,137,136,135,134,159,158,152,151,150,
     * 3G号段(TD-SCDMA网络)有157,182,183,188,187 147是移动TD上网卡专用号段. 联通:
     * 2G号段(GSM网络)有130,131,132,155,156 3G号段(WCDMA网络)有186,185 电信:
     * 2G号段(CDMA网络)有133,153 3G号段(CDMA网络)有189,180
     */
    static String YD = "^[1]{1}(([3]{1}[4-9]{1})|([5]{1}[012789]{1})|([8]{1}[2378]{1})|([4]{1}[7]{1}))[0-9]{8}$";
    static String LT = "^[1]{1}(([3]{1}[0-2]{1})|([5]{1}[56]{1})|([8]{1}[56]{1}))[0-9]{8}$";
    static String DX = "^[1]{1}(([3]{1}[3]{1})|([5]{1}[3]{1})|([8]{1}[09]{1}))[0-9]{8}$";

    public int matchNum(String mPhoneNumber) {
        /**
         * flag = 1 YD 2 LT 3 DX
         */
        int flag = 0;// 存储匹配结果
        // 判断手机号码是否是11位
        if (mPhoneNumber.length() == 11) {
            // 判断手机号码是否符合中国移动的号码规则
            if (mPhoneNumber.matches(YD)) {
                flag = 1;
            }
            // 判断手机号码是否符合中国联通的号码规则
            else if (mPhoneNumber.matches(LT)) {
                flag = 2;
            }
            // 判断手机号码是否符合中国电信的号码规则
            else if (mPhoneNumber.matches(DX)) {
                flag = 3;
            }
            // 都不合适 未知
            else {
                flag = 4;
            }
        }
        // 不是11位
        else {
            flag = 0;
        }
        return flag;
    }

    public String isPhoneNumber(String mPhoneNumber){
        String str = "";
        int flag = matchNum(mPhoneNumber);
        if(flag == 4 || flag == 0){
            str = "请输入正确的手机号码,请重新输入";
        }
        return str;
    }

}
