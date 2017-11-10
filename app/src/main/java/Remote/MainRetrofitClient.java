package Remote;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public class MainRetrofitClient  {
    private static Retrofit retrofit = null;

    public static Retrofit getClientMain(String baseUrl){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
    return retrofit;
    }
}
