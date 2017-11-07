package Remote;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public class MainUtils  {
    public static final String BASE_URL = " http://ams-api.astro.com.my/";

    public static MainService getServiceMain(){
        return MainRetrofitClient.getClientMain(BASE_URL).create(MainService.class);
    }

}
