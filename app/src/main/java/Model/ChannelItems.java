package Model;

import java.io.Serializable;

/**
 * Created by vitinhHienAnh on 07-11-17.
 */

public class ChannelItems implements Serializable{
    private String channelId;
    private String channelTitle;
    private String channelStbNumber;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelStbNumber() {
        return channelStbNumber;
    }

    public void setChannelStbNumber(String channelStbNumber) {
        this.channelStbNumber = channelStbNumber;
    }

    public ChannelItems(String channelId, String channelTitle) {
        this.channelId = channelId;
        this.channelTitle = channelTitle;
    }
}
