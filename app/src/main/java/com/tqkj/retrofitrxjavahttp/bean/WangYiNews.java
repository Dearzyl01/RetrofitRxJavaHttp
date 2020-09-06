package com.tqkj.retrofitrxjavahttp.bean;

import java.util.List;

public class WangYiNews {


    /**
     * code : 200
     * message : 成功!
     * result : [{"path":"https://news.163.com/19/0308/05/E9NLBIT30001875O.html","image":"http://cms-bucket.ws.126.net/2019/03/08/cdf92f27b0c54b59a7fa5a43789af2f6.png?imageView&thumbnail=140y88&quality=85","title":"科恩起诉特朗普集团：拖欠我190万美元法律费用","passtime":"2019-03-08 10:00:35"},{"path":"https://news.163.com/19/0308/05/E9NL6N950001875O.html","image":"http://cms-bucket.ws.126.net/2019/03/08/d41c98c5380647d498d7750a252d6d50.png?imageView&thumbnail=140y88&quality=85","title":"8项罪名被判成立 特朗普前竞选经理或在狱中度余生","passtime":"2019-03-08 10:00:35"},{"path":"https://news.163.com/19/0308/04/E9NIC6FI000187R2.html","image":"http://cms-bucket.ws.126.net/2019/03/08/4e847fe7b19a4c4491d070019bdb94b5.png?imageView&thumbnail=140y88&quality=85","title":"外媒:洛马公司获多份合同 成美中俄导弹竞赛大赢家","passtime":"2019-03-08 10:00:35"},{"path":"https://news.163.com/19/0308/04/E9NH2IH00001875P.html","image":"http://cms-bucket.ws.126.net/2019/03/08/4349ab34f7ad47ca953846d238110412.png?imageView&thumbnail=140y88&quality=85","title":"云南临沧市永德县发生4.4级地震 震源深度11千米","passtime":"2019-03-08 10:00:35"},{"path":"https://news.163.com/19/0308/03/E9NESUVP0001875P.html","image":"http://cms-bucket.ws.126.net/2019/03/08/24be838d8be944e18b063b57b914b707.png?imageView&thumbnail=140y88&quality=85","title":"四川乐山共享单车堆满2亩农田 农田主:租金还没付","passtime":"2019-03-08 10:00:35"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * path : https://news.163.com/19/0308/05/E9NLBIT30001875O.html
         * image : http://cms-bucket.ws.126.net/2019/03/08/cdf92f27b0c54b59a7fa5a43789af2f6.png?imageView&thumbnail=140y88&quality=85
         * title : 科恩起诉特朗普集团：拖欠我190万美元法律费用
         * passtime : 2019-03-08 10:00:35
         */

        private String path;
        private String image;
        private String title;
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
}
