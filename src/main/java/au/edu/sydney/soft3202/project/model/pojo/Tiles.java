package au.edu.sydney.soft3202.project.model.pojo;

public class Tiles {

    private int x;
    private int y;
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "tiles{" +
                "x=" + x +
                ", y=" + y +
                ", url='" + url + '\'' +
                '}';
    }
}
