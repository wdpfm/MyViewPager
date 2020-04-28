package com.wdpfm.myviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {
    private ArrayList<View> viewLists;
    private Context context;

    public MyPagerAdapter() {
    }

    public MyPagerAdapter(ArrayList<View> viewLists, Context context) {
        super();
        this.viewLists = viewLists;
        this.context = context;
    }

    public MyPagerAdapter(ArrayList<View> aList) {
        super();
        this.viewLists = viewLists;
    }

    //返回子页面的数量
    @Override
    public int getCount() {
        return viewLists.size();
    } //获得viewpager中有多少个view

    //判断instantiateItem方法返回的子页面对象是否是View视图对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //根据position位置序号，预加载第position个子页面到父容器(ViewPager)对象中，并返回这个子页面对象
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        container.addView(viewLists.get(position));
//        return viewLists.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.view_one, container,false);
        TextView tv = view.findViewById(R.id.textView1);
        tv.setText("第"+position+"个Page");
        container.addView(view);
        return view;
    }

    //销毁第position个子页面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewLists.get(position));
        container.removeView((View)object);
    }
}