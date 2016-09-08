package com.ttyooyu.market.utils;


import android.os.Environment;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.ttyooyu.market.core.MainFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016-07-30.
 */
public class DownloadUtils {

    public static void download(String version){
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/ttyooyu";
        final File file = new File(path, "ttyooyu_"+ version +".apk");
        if(!file.exists()){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(MainFactory.HOST_DOWNLOAD).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
//                        sum += len;
//                        int progress = (int) (sum * 1.0f / total * 100);
//                        Log.d("jwen", String.valueOf(progress));
                    }
                    fos.flush();
//                    Log.d("jwen", "文件下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
//                    Log.d("jwen", "文件下载失败");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }
        });
        }
    }

}
