package com.pyn.rtexchagerate.net;

import com.pyn.rtexchagerate.Bean.BaseCallResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * describtion:
 * Created by pengyn on 2016/9/7.
 */

public interface ApiService {

    public static final String HOST = "http://v.juhe.cn/";

    public static final String EXCHANGE = HOST + "onebox/exchange/";

    public static final String COIN_LIST = HOST + "onebox/exchange/";

    public static final String CURRENCY = HOST + "exchange/";

    @GET("query")
    Call<BaseCallResultBean> queryExchange(@Query("key") String key);

    @GET("list")
    Call<BaseCallResultBean> queryCoinList(@Query("key") String key);

    @GET("currency")
    Call<BaseCallResultBean> queryCurrency(@Query("key") String key);

}
