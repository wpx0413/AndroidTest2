package chapter.android.aweme.ss.com.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    private List<Message> Data=null;
    private MessageAdapter mAdapter=null;
    private ListView listMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_tips,null);
        setContentView(view);
        listMessage=findViewById(R.id.rv_list);
        //读取消息队列
        try {
            Data = PullParser.getMessage(Exercises3.this);
        }
        catch(Exception e){
            System.out.println("打开文件失败");
        }
        mAdapter=new MessageAdapter((ArrayList<Message>) Data,this);
        listMessage.setAdapter(mAdapter);
        //点击事件
        listMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Exercises3.this, NewsActivity.class);
                intent.putExtra("friend", Data.get(position).getTitle());
                intent.putExtra("news", Data.get(position).getDescription());
                startActivity(intent);
            }
        });
    }


    /**
     * 自定义适配器
     */
    public class MessageAdapter extends BaseAdapter {

        private ArrayList<Message> mData;
        private Context mContext;

        public MessageAdapter(ArrayList<Message> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                view = inflater.inflate(R.layout.im_list_item, null);
            } else {
                //!=null
                view = convertView;
            }
            TextView title =  view.findViewById(R.id.tv_title);
            TextView description =  view.findViewById(R.id.tv_description);
            TextView time =  view.findViewById(R.id.tv_time);

            title.setText(mData.get(position).getTitle());
            description.setText(mData.get(position).getDescription());
            time.setText(mData.get(position).getTime());

            return view;
        }
    }

}
