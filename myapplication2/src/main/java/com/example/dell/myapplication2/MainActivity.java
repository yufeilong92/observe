package com.example.dell.myapplication2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Obover {

    private Button mBtnNight;
    private Button mBtnDaytime;
    private TextView mTvContentOne;
    private TextView mTvContentTwo;
    private TextView mTvContentThree;
    private RecyclerView mRlvContent;
    private Subject subject;
    private Context mContext;
    private ColorManger mColorManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        subject = new MainActivity().subject();
        subject.attch(this);
        subject.notofyChanger();
    }

    private void initView() {
        mContext = this;
        mBtnNight = (Button) findViewById(R.id.btn_night);
        mBtnDaytime = (Button) findViewById(R.id.btn_daytime);

        mBtnNight.setOnClickListener(this);
        mBtnDaytime.setOnClickListener(this);
        mTvContentOne = (TextView) findViewById(R.id.tv_content_one);
        mTvContentOne.setOnClickListener(this);
        mTvContentTwo = (TextView) findViewById(R.id.tv_content_two);
        mTvContentTwo.setOnClickListener(this);
        mTvContentThree = (TextView) findViewById(R.id.tv_content_three);
        mTvContentThree.setOnClickListener(this);
        mRlvContent = (RecyclerView) findViewById(R.id.rlv_content);
        mRlvContent.setOnClickListener(this);
        mColorManger = new ColorManger(mContext);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_night:
                mColorManger.setColor(1);
                subject.notofyChanger();
                break;
            case R.id.btn_daytime:
                mColorManger.setColor(2);
                subject.notofyChanger();
                break;
        }
    }

    @Override
    public Subject subject() {
        return new Subject();
    }

    @Override
    public void refresh() {
        initColor();
        Toast.makeText(MainActivity.this, "测试成功", Toast.LENGTH_SHORT).show();
    }

    private void initColor() {
        int color = mColorManger.getColor();
        mTvContentOne.setTextColor(color);
        mTvContentTwo.setTextColor(color);
        mTvContentThree.setTextColor(color);
    }
}
