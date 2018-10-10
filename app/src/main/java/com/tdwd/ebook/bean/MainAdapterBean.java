package com.tdwd.ebook.bean;

/**
 * @author :Leew
 * @date ：2018/10/10 on 9:29
 * Description:
 */
public class MainAdapterBean {

    private String msg;
    private boolean ischecked;

    public MainAdapterBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }
}
