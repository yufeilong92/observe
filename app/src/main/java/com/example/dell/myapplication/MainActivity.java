package com.example.dell.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnToast;
    private Context mContext;
    private Context mContext1;
    private DatePicker mDatapickeOne;
    private DatePicker mDatapickeTwo;
    private Gallery mGallery;
    private ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        list = initEvent();
        initapater();
    }

    private void initapater() {
         mGallery.setAdapter(new BaseAdapter() {
             @Override
             public int getCount() {
                 return list.size();
             }

             @Override
             public Object getItem(int position) {
                 return list.get(position);
             }

             @Override
             public long getItemId(int position) {
                 return position;
             }

             @Override
             public View getView(int position, View convertView, ViewGroup parent) {
                 ImageView imageView = new ImageView(mContext);
                 imageView.setImageResource(list.get(position));
                 imageView.setLayoutParams(new Gallery.LayoutParams(100,100));
                 imageView.setScaleType(ImageView.ScaleType.CENTER);
                 return imageView;
             }
         });
    }

    private ArrayList<Integer> initEvent() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        list.add(R.mipmap.d);
        return list;
    }

    private void initData() {
        mDatapickeOne.init(2010, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        });
        mDatapickeTwo.init(2011, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        });

    }

    private void initView() {
        mContext = this;
        mBtnToast = (Button) findViewById(R.id.btn_toast);

        mBtnToast.setOnClickListener(this);
        mDatapickeOne = (DatePicker) findViewById(R.id.datapicke_one);
        mDatapickeOne.setOnClickListener(this);
        mDatapickeTwo = (DatePicker) findViewById(R.id.datapicke_two);
        mDatapickeTwo.setOnClickListener(this);
        mGallery = (Gallery) findViewById(R.id.gallery);
        mGallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                Toast toast = Toast.makeText(mContext, "带图片", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout view = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(mContext);
                imageView.setImageResource(R.drawable.ic_launcher_background);
                view.addView(imageView, 0);
                toast.show();
                break;
        }
    }
}
