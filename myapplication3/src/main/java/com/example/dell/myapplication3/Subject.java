package com.example.dell.myapplication3;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: Subject.java
 * @Package com.example.dell.myapplication3
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 19:34
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObserver() {
        if (!observers.isEmpty()) {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = observers.get(i);
                observer.updata();
            }
        }
    }
}
