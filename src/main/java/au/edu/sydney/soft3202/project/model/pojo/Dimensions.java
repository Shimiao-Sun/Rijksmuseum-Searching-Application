package au.edu.sydney.soft3202.project.model.pojo;

public class Dimensions {

    private String unit;
    private String type;
    private boolean part;
    private String value;

    public void setPart(boolean part) {
        this.part = part;
    }

    public boolean isPart() {
        return part;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "unit='" + unit + '\'' +
                ", type='" + type + '\'' +
                ", part=" + part +
                ", value='" + value + '\'' +
                '}';
    }
}
