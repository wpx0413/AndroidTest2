package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 * 结果:onCreate,onStart,onResume,onPause,onStop,onDestroy,onCreate,onStart,onResume,onPause...
 * 可以看到，每一次旋转屏幕，都会将界面的生命周期重新进行一遍，占用资源提高
 */
public class Exercises1 extends AppCompatActivity {

    public static final String TAG="Exercises1";

    /**
     * 用户界面被创建
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }


    /**
     * 界面用户可见
     */
    @Override protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * 界面获得焦点
     */
    @Override protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    /**
     * 界面失去焦点
     */
    @Override protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    /**
     * 用户不可见
     */
    @Override protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
    *界面被销毁
     */
    @Override protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    /**
     * 界面重新可见
     */
    @Override protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

}
