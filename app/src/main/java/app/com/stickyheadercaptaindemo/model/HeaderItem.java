package app.com.stickyheadercaptaindemo.model;

/**
 * Created by surensth on 12/28/16.
 */

public class HeaderItem {
    int id;

    public HeaderItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    String title;


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
