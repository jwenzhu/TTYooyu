package com.ttyooyu.market.core;

/**
 * Created by Administrator on 2016-08-25.
 */
public class Constant {


    /**
     * ttyouyu
     */
    public static final String TTYOUYU_SUPER = "ttyouyuSuper";
    public static final String SRC_PATH = "ttyouyu/";
    public static final String TTYOUYU_URL_WECHAT = "http://www.ttyouyu.cn/wx/index";

    /**
     * SharePreferences
     */
    public static final String FILE_NAME = "ttyouyu";//数据库
    public static final String UID = "uid";//用户uid
    public static final String ACCESS_TOKEN = "access_token";//用户access_token

    /**
     * bundle
     */
    public static final String BUNDLE = "bundle";

    /**
     * message
     */
    public static final int MESSAGE_STATE_CHANGE = 0x01;
    public static final int MESSAGE_READ = 0x02;
    public static final int MESSAGE_WRITE = 0x03;
    public static final int MESSAGE_DEVICE_NAME = 0x04;
    public static final int MESSAGE_TOAST = 0x05;

    // Key names received from the BluetoothService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";



    /**
     * sqlite
     */
    public static final String SQLITE_NAME = "ttyouyu";//数据库名称
    public static final int SQLITE_VERSION = 1;//数据库版本
}
