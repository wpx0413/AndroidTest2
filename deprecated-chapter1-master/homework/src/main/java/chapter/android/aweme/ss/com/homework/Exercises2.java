package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_chatroom,null);
        setContentView(view);
        int viewCount=getViewCount(view)+1;
        Toast.makeText(Exercises2.this,"viewCount: " + viewCount,Toast.LENGTH_SHORT).show();
    }

    public static int getViewCount(View view) {
        int count=0;
        ViewGroup viewgroup=(ViewGroup)view;
        int n=viewgroup.getChildCount();
        count+=n;
        int i;
        for(i=0;i<n;i++) {
            View view1=viewgroup.getChildAt(i);
            if(view1 instanceof ViewGroup) {
                count += getViewCount(view1);
            }
        }
        //todo 补全你的代码
        return count;
    }
}
