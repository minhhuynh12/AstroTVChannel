package Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vitinhHienAnh on 05-11-17.
 */

public class MainItems {
    private String responseMessage;
    private String responseCode;
    @SerializedName("channels")
    private List<ChannelItems> channels;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<ChannelItems> getChannels() {
        return channels;
    }

    public void setChannels(List<ChannelItems> channels) {
        this.channels = channels;
    }

    public MainItems(List<ChannelItems> channels) {
        this.channels = channels;
    }
}
