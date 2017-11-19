package Model;

/**
 * Created by vitinhHienAnh on 19-11-17.
 */

public class ChannelFavorite {

    public String channelId;
    public boolean isFavorite;

    public ChannelFavorite(String channelId) {
        this.channelId = channelId;
        isFavorite = false;
    }
}
