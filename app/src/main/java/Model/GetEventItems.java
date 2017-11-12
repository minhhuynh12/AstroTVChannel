package Model;

/**
 * Created by vitinhHienAnh on 11-11-17.
 */

public class GetEventItems {
    private String channelTitle;
    private String displayDateTimeUtc;
    private String displayDateTime;
    private String programmeTitle;
    private String shortSynopsis;
    private String epgEventImage;

    public String getEpgEventImage() {
        return epgEventImage;
    }

    public void setEpgEventImage(String epgEventImage) {
        this.epgEventImage = epgEventImage;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getDisplayDateTimeUtc() {
        return displayDateTimeUtc;
    }

    public void setDisplayDateTimeUtc(String displayDateTimeUtc) {
        this.displayDateTimeUtc = displayDateTimeUtc;
    }

    public String getDisplayDateTime() {
        return displayDateTime;
    }

    public void setDisplayDateTime(String displayDateTime) {
        this.displayDateTime = displayDateTime;
    }

    public String getProgrammeTitle() {
        return programmeTitle;
    }

    public void setProgrammeTitle(String programmeTitle) {
        this.programmeTitle = programmeTitle;
    }

    public String getShortSynopsis() {
        return shortSynopsis;
    }

    public void setShortSynopsis(String shortSynopsis) {
        this.shortSynopsis = shortSynopsis;
    }
}
