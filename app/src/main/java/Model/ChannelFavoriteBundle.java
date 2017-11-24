package Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vitinhHienAnh on 24-11-17.
 */

public class ChannelFavoriteBundle implements Serializable {
    public String channelId;
    public List<ChannelFavorite> list;

    public List<ChannelFavorite> getList() {
        return list;
    }

    public void setList(List<ChannelFavorite> list) {
        this.list = list;
    }

    public boolean isFavorite;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
