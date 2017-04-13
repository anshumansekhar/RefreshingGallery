package qazwsxedc.refreshinggallery;

/**
 * Created by Anshuman-HP on 13-03-2017.
 */

public class image {
    String path;
    int count;

    public image(String path, int count) {
        this.path = path;
        this.count = count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
