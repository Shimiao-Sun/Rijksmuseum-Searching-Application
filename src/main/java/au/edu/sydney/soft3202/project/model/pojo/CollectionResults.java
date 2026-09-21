package au.edu.sydney.soft3202.project.model.pojo;

import java.util.*;

public class CollectionResults {

    private int elapsedMilliseconds;
    private int count;
    private List<ArtObjects> artObjects;

    public int getCount() {
        return count;
    }

    public int getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public List<ArtObjects> getArtObjects() {
        return artObjects;
    }

    public void setArtObjects(List<ArtObjects> artObjects) {
        this.artObjects = artObjects;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setElapsedMilliseconds(int elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    @Override
    public String toString() {
        return "CollectionResults{" +
                "elapsedMilliseconds=" + elapsedMilliseconds +
                ", count=" + count +
                ", artObjects=" + artObjects +
                '}';
    }
}
