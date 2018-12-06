package com.example.dell.myapplication4;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlvContent;
    private Context mContext;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initRecyclerView();
    }

    private void initRecyclerView() {

        mRlvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        itemAdapter.addListener(new ItemAdapter.addOnclick() {
            @Override
            public void onItemCLick(String msg) {
                super.onItemCLick(msg);
                Log.e("==", "onItemCLick: " + msg);
                Toast.makeText(MainActivity .this,""+msg,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLong(String msg) {
                super.onItemLong(msg);
                Log.e("==", "onItemLong: " + msg);
                Toast.makeText(MainActivity .this,""+msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initEvent() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRlvContent.setLayoutManager(manager);
        itemAdapter = new ItemAdapter(mContext, null);
        mRlvContent.setAdapter(itemAdapter);
    }

    private void initView() {
        mContext = this;
        mRlvContent = (RecyclerView) findViewById(R.id.rlv_content);
    }
}
