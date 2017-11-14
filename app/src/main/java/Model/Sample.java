package Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vitinhHienAnh on 14-11-17.
 */

public class Sample implements Serializable{
    public List<ChannelItems> list;

    public List<ChannelItems> getList() {
        return list;
    }

    public void setList(List<ChannelItems> list) {
        this.list = list;
    }
}
