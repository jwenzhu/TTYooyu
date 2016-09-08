package com.ttyooyu.market.core;

/**
 * Created by Administrator on 2016-08-25.
 */
public class MainFactory {

    /**
     * host url
     */
    public static final String HOST = "www.baidu.com";
    public static final String HOST_DOWNLOAD ="";

    private static TTYooYu mTTYooYu;

    protected static final Object monitor = new Object();

    public static TTYooYu getTTYooYuInstance(){
        synchronized (monitor){
            if(mTTYooYu ==null){
                mTTYooYu = new MainRetrofit().getService();
            }
            return mTTYooYu;
        }
    }
}
