package Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vitinhHienAnh on 11-11-17.
 */

public class DetailChannelItems  {
    @SerializedName("getevent")
    private List<GetEventItems> getevent;

    public List<GetEventItems> getGetEvent() {
        return getevent;
    }

    public void setGetEvent(List<GetEventItems> getEvent) {
        this.getevent = getEvent;
    }
}
