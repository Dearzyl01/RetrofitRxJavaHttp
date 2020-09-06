package com.tqkj.retrofitrxjavahttp.bean;

import com.google.gson.annotations.SerializedName;


public class WangYiNewsBean {

    /**
     * path : https://news.163.com/19/0308/05/E9NLBIT30001875O.html
     * image : http://cms-bucket.ws.126.net/2019/03/08/cdf92f27b0c54b59a7fa5a43789af2f6.png?imageView&thumbnail=140y88&quality=85
     * title : 科恩起诉特朗普集团：拖欠我190万美元法律费用
     * passtime : 2019-03-08 10:00:35
     */
    @SerializedName("path")
    private String path;
    @SerializedName("image")
    private String image;
    @SerializedName("title")
    private String title;
    @SerializedName("passtime")
    private String passtime;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }
}
