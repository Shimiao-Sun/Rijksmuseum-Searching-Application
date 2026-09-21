package au.edu.sydney.soft3202.project.model.pojo;

public class CollectionDetailedObject {

    private int elapsedMilliseconds;
    private ArtObject artObject;

    @Override
    public String toString() {
        return "CollectionDetailedObject{" +
                "elapsedMilliseconds=" + elapsedMilliseconds +
                ", artObject=" + artObject +
                '}';
    }

    public int getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(int elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public void setArtObject(ArtObject artObject) {
        this.artObject = artObject;
    }

    public ArtObject getArtObject() {
        return artObject;
    }
}
