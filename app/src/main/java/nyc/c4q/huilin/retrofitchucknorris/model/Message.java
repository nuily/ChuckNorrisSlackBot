package nyc.c4q.huilin.retrofitchucknorris.model;

import java.util.List;

/**
 * Created by huilin on 10/23/16.
 */

public class Message {

    private String botID;
    private String username;
    private String text;
    private String ts;
    private String user;
    List<Attachment> attachments;

    public String getText() {
        return text;
    }

    public String getTs() {
        return ts;
    }

    public String getUser() {
        return user;
    }

    public String getBotID() {
        return botID;
    }

    public String getUsername() {
        return username;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setBotID(String botID) {
        this.botID = botID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
