package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        TextView freiendText=findViewById(R.id.tv_friend);
        TextView newsText=findViewById(R.id.tv_news);
        Intent intent=getIntent();
        String friend=intent.getStringExtra("friend");
        String news=intent.getStringExtra("news");
        freiendText.setText(friend);
        newsText.setText(news);
    }
}
