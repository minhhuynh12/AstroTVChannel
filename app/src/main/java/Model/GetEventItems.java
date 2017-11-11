package Model;

/**
 * Created by vitinhHienAnh on 11-11-17.
 */

public class GetEventItems {
    private String channelTitle;
    private String disPlayDatetimeUTC;
    private String disPlayDatetime;
    private String programeTitle;
    private String shortSynopsis;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getDisPlayDatetimeUTC() {
        return disPlayDatetimeUTC;
    }

    public void setDisPlayDatetimeUTC(String disPlayDatetimeUTC) {
        this.disPlayDatetimeUTC = disPlayDatetimeUTC;
    }

    public String getDisPlayDatetime() {
        return disPlayDatetime;
    }

    public void setDisPlayDatetime(String disPlayDatetime) {
        this.disPlayDatetime = disPlayDatetime;
    }

    public String getProgrameTitle() {
        return programeTitle;
    }

    public void setProgrameTitle(String programeTitle) {
        this.programeTitle = programeTitle;
    }

    public String getShortSynopsis() {
        return shortSynopsis;
    }

    public void setShortSynopsis(String shortSynopsis) {
        this.shortSynopsis = shortSynopsis;
    }
}
