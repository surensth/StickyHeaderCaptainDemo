package app.com.stickyheadercaptaindemo.model;

/**
 * Created by surensth on 12/28/16.
 */

public class BodyItem {
    int id;
    String title;
    String value;
    int headerId;

    public BodyItem(int id, String title, String value, int headerId) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.headerId = headerId;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
