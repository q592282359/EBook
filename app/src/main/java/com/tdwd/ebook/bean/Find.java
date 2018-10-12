package com.tdwd.ebook.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * @author :Leew
 * @date ：2018/10/12 on 16:25
 * Description:
 */
public class Find extends BmobObject {

    private BmobFile userhead;
    private String username;
    private BmobFile img1;
    private BmobFile img2;
    private BmobFile img3;
    private String from;


    public BmobFile getUserhead() {
        return userhead;
    }

    public void setUserhead(BmobFile userhead) {
        this.userhead = userhead;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BmobFile getImg1() {
        return img1;
    }

    public void setImg1(BmobFile img1) {
        this.img1 = img1;
    }

    public BmobFile getImg2() {
        return img2;
    }

    public void setImg2(BmobFile img2) {
        this.img2 = img2;
    }

    public BmobFile getImg3() {
        return img3;
    }

    public void setImg3(BmobFile img3) {
        this.img3 = img3;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
