package nyc.c4q.huilin.retrofitchucknorris.model;

import nyc.c4q.huilin.retrofitchucknorris.network.Response;

/**
 * Created by huilin on 10/23/16.
 */


public class SendMessageResponse extends Response {

    private String channel;
    private String ts;
    private Message message;


    public String getChannel() {
        return channel;
    }

    public String getTs() {
        return ts;
    }

    public Message getMessage() {
        return message;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

