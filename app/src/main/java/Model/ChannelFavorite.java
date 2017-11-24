package Model;

import java.io.Serializable;

/**
 * Created by vitinhHienAnh on 19-11-17.
 */

public class ChannelFavorite implements Serializable {

    public String channelId;
    public boolean isFavorite;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public ChannelFavorite(String channelId) {
        this.channelId = channelId;
        isFavorite = false;
    }
}
