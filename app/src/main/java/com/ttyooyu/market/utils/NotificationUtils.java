package com.ttyooyu.market.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;


import com.ttyooyu.market.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-08-19.
 */
public class NotificationUtils {


    private Context mContext;
    public NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    int notifyId = 0x101;

    private NotificationUtils(Context context){
        this.mContext = context;
        mNotificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
    }
    private static NotificationUtils instance;
    public static NotificationUtils getInstance(Context context){
        if(instance == null){
            instance = new NotificationUtils(context);
        }
        return  instance;
    }


    /**
     * 下线通知
     * @param title
     * @param content
     */
    public void unLoginNotification(String title,String content){
//        RemoteViews view_custom = new RemoteViews(mContext.getPackageName(), R.layout.layout_notification);
//        view_custom.setImageViewResource(R.id.custom_icon, R.mipmap.ic_launcher);
//        view_custom.setTextViewText(R.id.tv_custom_title, title);
//        view_custom.setTextViewText(R.id.tv_custom_time, getCurrentTime());
//        view_custom.setTextViewText(R.id.tv_custom_content, content);
//        mBuilder = new Builder(mContext);
//        mBuilder.setContent(view_custom)
//                .setContentIntent(getDefaultIntent(Notification.FLAG_AUTO_CANCEL))
//                .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
//                .setTicker("通知提示")
//                .setPriority(Notification.PRIORITY_DEFAULT)// 设置该通知优先级
//                .setDefaults(Notification.DEFAULT_VIBRATE)
//                .setOngoing(false)//不是正在进行的   true为正在进行  效果和.flag一样
//                .setSmallIcon(R.mipmap.ic_launcher);
//        Notification notify = mBuilder.build();
//        notify.contentView = view_custom;
//        mNotificationManager.notify(notifyId, notify);
    }

    /**
     * 普通通知
     * @param title
     * @param content
     */
    public void normalNotification(String title,String content){

    }

    /**
     * 点击事件
     * @param flags
     * @return
     */
    private PendingIntent getDefaultIntent(int flags){
        PendingIntent pendingIntent= PendingIntent.getActivity(mContext, 1, new Intent(), flags);
        return pendingIntent;
    }

    private String getCurrentTime(){
        long timestamp = System.currentTimeMillis();
        String time = new SimpleDateFormat("HH:mm").
                format(new Date(timestamp));
        return time;
    }

}
