package com.tqkj.retrofitrxjavahttp.http;


import com.tqkj.retrofitrxjavahttp.bean.WangYiNewsBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * * 请求方法类接口
 */
public interface ApiService {
    //https://api.apiopen.top/musicDetails?id=604392760  接口完整路径


    /**
     * get请求方式（这个是根请求链接）
     *
     * @Query 形成单个查询参数, 将接口url中追加类似于"page=1"的字符串,形成提交给服务器端的参数,
     * 主要用于Get请求数据，用于拼接在拼接在url路径后面的查询参数，一个@Query相当于拼接一个参数
     */
    String HOST = "https://api.apiopen.top/";

    @GET("/musicDetails")
    Observable<BaseResponse<List<String>>> getString(@Query("id") String id);


    @FormUrlEncoded  //post请求必须要申明该注解
    @POST("/musicDetails")//方法名
    Observable<BaseResponse<List<String>>> getStr(@Field("id") String id);

    /**
     * 获取网易新闻
     * @param page
     * @param count
     * @return
     */
    @FormUrlEncoded//post请求必须要申明该注解
    @POST("getWangYiNews")
    Observable<BaseResponse<List<WangYiNewsBean>>> getNews(@Field("page") String page, @Field("count") String count);


}
