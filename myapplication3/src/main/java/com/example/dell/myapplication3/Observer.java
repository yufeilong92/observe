package com.example.dell.myapplication3;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: Observer.java
 * @Package com.example.dell.myapplication3
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 19:37
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void updata();

    public static void addUpdataListener(ObserverListener listener) {
        if (listener != null)
            listener.refresh();
    }

    public interface ObserverListener {
        public void refresh();
    }
}
