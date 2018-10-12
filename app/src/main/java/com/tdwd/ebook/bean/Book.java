package com.tdwd.ebook.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * @author :Leew
 * @date ：2018/10/12 on 10:04
 * Description:
 */
public class Book extends BmobObject {
    private String name;
    private String author;
    private String content;
    private BmobFile imgpic;
    private BmobFile imgbigpic;
    private String fromuser;
    private String fromusername;
    private String touser;
    private String tousername;
    private String money;
    private String place;
    private int status;
    private boolean ischecked;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BmobFile getImgpic() {
        return imgpic;
    }

    public void setImgpic(BmobFile imgpic) {
        this.imgpic = imgpic;
    }

    public BmobFile getImgbigpic() {
        return imgbigpic;
    }

    public void setImgbigpic(BmobFile imgbigpic) {
        this.imgbigpic = imgbigpic;
    }

    public String getFromuser() {
        return fromuser;
    }

    public void setFromuser(String fromuser) {
        this.fromuser = fromuser;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

