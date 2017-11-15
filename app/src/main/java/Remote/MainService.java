package Remote;

import java.util.ArrayList;
import java.util.List;

import Model.DetailChannelItems;
import Model.EventSearchChannelItems;
import Model.FieldsSearchChannelItems;
import Model.GetEventItems;
import Model.MainItems;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public interface MainService  {
    @GET("ams/v3/getChannelList")
    Call<MainItems> getMainListChannel();

    @GET("ams/v3/getEvents")
    Call<DetailChannelItems> getDetailChannel(@Query("channelId")String channelID
            , @Query("periodStart") String periodStart
            , @Query("periodEnd") String periodEnd);

    @GET("ams/v3/searchEvents")
    Call<EventSearchChannelItems> getDataSearch(@Query("keyword") String keyword);

}
