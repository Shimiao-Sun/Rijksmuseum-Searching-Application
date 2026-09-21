package au.edu.sydney.soft3202.project.model.pojo;

public class Colors {

    private int percentage;
    private String hex;

    public int getPercentage() {
        return percentage;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Colors{" +
                "percentage=" + percentage +
                ", hex='" + hex + '\'' +
                '}';
    }
}
