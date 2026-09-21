package au.edu.sydney.soft3202.project.model.pojo;

public class ColorsWithNormalization {

    private String originalHex;
    private String normalizedHex;

    public String getNormalizedHex() {
        return normalizedHex;
    }

    public String getOriginalHex() {
        return originalHex;
    }

    public void setNormalizedHex(String normalizedHex) {
        this.normalizedHex = normalizedHex;
    }

    public void setOriginalHex(String originalHex) {
        this.originalHex = originalHex;
    }

    @Override
    public String toString() {
        return "ColorsWithNormalization{" +
                "originalHex='" + originalHex + '\'' +
                ", normalizedHex='" + normalizedHex + '\'' +
                '}';
    }
}
