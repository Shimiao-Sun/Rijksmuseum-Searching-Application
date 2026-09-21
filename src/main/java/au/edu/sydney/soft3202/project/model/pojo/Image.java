package au.edu.sydney.soft3202.project.model.pojo;

import java.util.*;

public class Image {

    private String name;
    private int width;
    private int height;
    private List<Tiles> tiles;

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setTiles(List<Tiles> tiles) {
        this.tiles = tiles;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Tiles> getTiles() {
        return tiles;
    }

    @Override
    public String toString() {
        return "levels{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", tiles=" + tiles +
                '}';
    }
}
