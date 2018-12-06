package com.example.dell.myapplication2;

import android.content.Context;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: ColorManger.java
 * @Package com.example.dell.myapplication2
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 20:25
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ColorManger {
    private Context mContext;
    private  int color;

    public ColorManger(Context mContext) {
        this.mContext = mContext;
        color = mContext.getResources().getColor(R.color.colorPrimary);
    }


    public void setColor(int number) {
        switch (number) {
            case 0:
                color = mContext.getResources().getColor(R.color.black);
                break;
            case 1:
                color = mContext.getResources().getColor(R.color.colorAccent);
                break;
            case 2:
                color = mContext.getResources().getColor(R.color.green);
                break;
            default:
                break;
        }
    }

    public int getColor() {
        return color;
    }
}
