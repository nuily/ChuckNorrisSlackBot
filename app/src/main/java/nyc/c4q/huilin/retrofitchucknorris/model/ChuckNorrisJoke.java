package nyc.c4q.huilin.retrofitchucknorris.model;

/**
 * Created by huilin on 10/23/16.
 */

public class ChuckNorrisJoke {

    private String iconUrl;
    private String id;
    private String url;
    private String value;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
