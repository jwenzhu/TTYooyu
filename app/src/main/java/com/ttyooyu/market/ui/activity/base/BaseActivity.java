package com.ttyooyu.market.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.squareup.leakcanary.watcher.RefWatcher;
import com.ttyooyu.market.MyApplication;
import com.ttyooyu.market.R;
import com.ttyooyu.market.presenter.base.BasePresenter;


/**
 * BaseActivity
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {


    public P mPresenter;
    public Intent mIntent;

    /**
     * 获取布局
     */
    public abstract int getLayout();

    /**
     * 初始化控制器
     */
    public abstract void initPresenter();

    /**
     * 获取数据
     */
    public abstract void requestData();

    /**
     * 初始化view
     */
    public abstract void initView();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);

        initPresenter();
        initView();
        requestData();
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            return false;
        }
        return true;
    }

    /**
     * 返回
     */
    public void onBack(){
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
