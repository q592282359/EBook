package com.tdwd.ebook.bean;

import java.util.List;

/**
 * @author :Leew
 * @date ：2018/10/10 on 10:05
 * Description:
 */
public class PlaceBean {



        /**
         * code : A
         * cityList : ["阿城市","阿尔山市","阿克苏市","阿勒泰市","阿图什市","安达市","安国市","安康市","安陆市","安宁市","安庆市","安丘市","安顺市","安阳市","鞍山市","澳门"]
         */

        private String code;
        private List<String> cityList;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<String> getCityList() {
            return cityList;
        }

        public void setCityList(List<String> cityList) {
            this.cityList = cityList;
        }

}
