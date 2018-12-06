package com.example.dell.myapplication4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: ItemAdapter.java
 * @Package com.example.dell.myapplication4
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 21:03
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList mData;
    private final LayoutInflater mInflater;
    private ArrayList<addOnclick> addOnclicks;

    public ItemAdapter(Context mContext, ArrayList mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    public abstract static class addOnclick {
        public void onItemCLick(String msg) {
        }

        public void onItemLong(String msg) {
        }

        ;
    }

    public void addListener(addOnclick onclick) {
        if (addOnclicks == null)
            addOnclicks = new ArrayList<>();
        addOnclicks.add(onclick);
    }

    ;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addOnclicks != null && !addOnclicks.isEmpty()) {
                    for (int i = 0; i < addOnclicks.size(); i++) {
                        addOnclick onclick = addOnclicks.get(i);
                        onclick.onItemCLick(holder.mTvContent.getText().toString().trim());
                        onclick.onItemLong(holder.mTvContent.getText().toString().trim());
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mTvContent = (TextView) itemView.findViewById(R.id.tv_content);

        }
    }
}
