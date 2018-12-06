package com.example.dell.myapplication2;

import java.util.ArrayList;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: Subject.java
 * @Package com.example.dell.myapplication2
 * @Description: todo
 * @author: YFL
 * @date: 2018/12/6 20:10
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/12/6 星期四
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Subject {
    private ArrayList<Obover> lists = new ArrayList<>();

    public void attch(Obover subject) {
        lists.add(subject);
    }

    public void notofyChanger() {
        if (!lists.isEmpty()) {
            for (int i = 0; i < lists.size(); i++) {
                Obover obover = lists.get(i);
                obover.refresh();
            }
        }
    }
}
