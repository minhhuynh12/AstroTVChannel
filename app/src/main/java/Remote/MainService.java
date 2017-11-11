package Remote;

import java.util.ArrayList;
import java.util.List;

import Model.DetailChannelItems;
import Model.MainItems;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public interface MainService  {
    @GET("ams/v3/getChannelList")
    Call<MainItems> getMainListChannel();

    @GET("v3/getEvents")
    Call<DetailChannelItems> getDetailChannel(@Query("channelId") ArrayList<String> channelID
            , @Query("periodStart") String periodStart
            , @Query("periodEnd") String periodEnd);



}
