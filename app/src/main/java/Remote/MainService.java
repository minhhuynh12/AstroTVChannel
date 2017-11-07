package Remote;

import java.util.List;

import Model.MainItems;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public interface MainService  {
    @GET("ams/v3/getChannelList")
    Call<MainItems> getMainListChannel();

}
