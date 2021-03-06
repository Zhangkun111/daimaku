package com.bwie.hp.mytaobao.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bwie.hp.mytaobao.R;
import com.bwie.hp.mytaobao.fragment.FragmentPage1;
import com.bwie.hp.mytaobao.fragment.FragmentPage2;
import com.bwie.hp.mytaobao.fragment.FragmentPage3;
import com.bwie.hp.mytaobao.fragment.FragmentPage4;
import com.bwie.hp.mytaobao.fragment.FragmentPage5;

public class Main2Activity extends AppCompatActivity {
    private FragmentTabHost mTabHost;
    //定义一个布局
    private LayoutInflater layoutInflater;
    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class,FragmentPage5.class};
    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_firstpage,R.drawable.tab_weitao,R.drawable.tab_xiaoxi,
            R.drawable.tab_che,R.drawable.tab_wode};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "微淘", "消息", "购物车", "我的淘宝"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView iv=new ImageView(this);
        initView();


    }
    private void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        //得到fragment的个数
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec spec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));

            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(spec, fragmentArray[i], null);

            //设置Tab按钮的背景
            //mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }

    }
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tabitem, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }
}
