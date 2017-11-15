package Model;

/**
 * Created by vitinhHienAnh on 15-11-17.
 */

public class SearchChannelItems {
    private String channelTitle;
    private String channelStbNumber;
    private String displayDateTime;
    private String displayEndDateTime;
    private String eventName;
    private String eventDescription;

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

    public String getDisplayDateTime() {
        return displayDateTime;
    }

    public void setDisplayDateTime(String displayDateTime) {
        this.displayDateTime = displayDateTime;
    }

    public String getDisplayEndDateTime() {
        return displayEndDateTime;
    }

    public void setDisplayEndDateTime(String displayEndDateTime) {
        this.displayEndDateTime = displayEndDateTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
