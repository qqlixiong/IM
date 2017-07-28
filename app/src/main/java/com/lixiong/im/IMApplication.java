package com.lixiong.im;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.lixiong.im.controller.NoStatusBar;
import com.lixiong.im.model.Model;
import com.lixiong.im.utils.BarUtils;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * Created by Administrator on 2016/9/23.
 */
public class IMApplication extends Application implements Application.ActivityLifecycleCallbacks {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化EaseUI
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);// 设置需要同意后才能接受邀请
        options.setAutoAcceptGroupInvitation(false);// 设置需要同意后才能接受群邀请

        EaseUI.getInstance().init(this,options);

        // 初始化数据模型层类
        Model.getInstance().init(this);

        // 初始化全局上下文对象
        mContext = this;
        registerActivityLifecycleCallbacks(this);
    }

    // 获取全局上下文对象
    public static Context getGlobalApplication(){
        return mContext;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        if(!(activity instanceof NoStatusBar))BarUtils.setColor(activity, ContextCompat.getColor(this,R.color.top_bar_normal_bg),0);
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
