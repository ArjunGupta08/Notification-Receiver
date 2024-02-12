package com.android.mynotification;

public class PushNotificationData {

    private NotificationData data;
    private String to;

    public PushNotificationData(NotificationData data, String to) {
        this.data = data;
        this.to = to;
    }

    public NotificationData getNotificationData() {
        return data;
    }

    public void setNotificationData(NotificationData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
