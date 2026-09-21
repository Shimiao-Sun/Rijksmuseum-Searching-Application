package au.edu.sydney.soft3202.project.model.pojo;

public class AdlibOverrides {

    private String titel;
    private String maker;
    private String etiketText;

    @Override
    public String toString() {
        return "AdlibOverrides{" +
                "titel='" + titel + '\'' +
                ", maker='" + maker + '\'' +
                ", etiketText='" + etiketText + '\'' +
                '}';
    }

    public String getEtiketText() {
        return etiketText;
    }

    public String getMaker() {
        return maker;
    }

    public String getTitel() {
        return titel;
    }

    public void setEtiketText(String etiketText) {
        this.etiketText = etiketText;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
