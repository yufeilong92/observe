package com.example.dell.myapplication3;

import android.util.Log;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: BinaryObserver.java
 * @Package com.example.dell.myapplication3
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 19:57
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class BinaryObserver extends Observer {
    public static final String TAG = "BinaryObserver.class";

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
   private int a=0;
    @Override
    public void updata() {
        Log.e(TAG, "updata: "+(++a));
    }
}
