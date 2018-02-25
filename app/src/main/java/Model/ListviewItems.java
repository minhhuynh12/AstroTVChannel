package Model;

/**
 * Created by vitinhHienAnh on 20-02-18.
 */

public class ListviewItems {
    private String tv1;
    private String tv2;

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public ListviewItems(String tv1, String tv2) {
        this.tv1 = tv1;
        this.tv2 = tv2;
    }
}
