package com.ttyooyu.market.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


import com.ttyooyu.market.core.Constant;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016-07-05.
 */
public class ActivityUtils{

    /**
     *
     * @Description: 隐式启动,跳转
     * @param packageContext
     * @param action
     *            含操作的Intent
     */
    public static void startActivity(Context packageContext,
                                               Intent action) {
        PackageManager packageManager = packageContext.getPackageManager();
        List activities = packageManager.queryIntentActivities(action,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            packageContext.startActivity(action);
        }

    }

    /**
     * @Description: 跳转
     * @param packageContext
     *
     * @param cls
     *
     */
    public static void startActivity(Context packageContext, Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);
    }

    /**
     * @param packageContext
     * @param cls
     * @param keyValues
     *
     */
    public static void startActivity(Context packageContext, Class<?> cls,
                                     Map<String,String> keyValues) {
        Intent i = new Intent(packageContext, cls);
        Set<Map.Entry<String, String>> entrySet = keyValues.entrySet();
        for (Map.Entry<String, String> entry:entrySet){
            i.putExtra(entry.getKey(),entry.getValue());
        }
        packageContext.startActivity(i);

    }


    /**
     * @param packageContext
     * @param cls
     * @param obj
     *
     */
    public static <Object extends Serializable> void startActivity(Context packageContext, Class<?> cls,
                                                                   Object obj) {
        Intent i = new Intent(packageContext, cls);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.BUNDLE,obj);
        i.putExtras(bundle);
        packageContext.startActivity(i);

    }

    /**
     * finish
     * @param packageContext
     * @param cls
     */
    public static void startActivityFinish(Context packageContext,
                                               Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);
        ((Activity) packageContext).finish();
    }

    /**
     *
     * @param activity
     * @param cls
     * @param requestCode
     */
    public static void startActivityForResult(Activity activity, Class<?> cls,int requestCode){
        Intent intent = new Intent(activity,cls);
        activity.startActivityForResult(intent,requestCode);
    }

    public static<Object extends Serializable> void setResult( Activity activity,int requestCode,Object obj){
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.BUNDLE,obj);
        intent.putExtras(bundle);
        activity.setResult(requestCode,intent);
        activity.finish();
    }

}
