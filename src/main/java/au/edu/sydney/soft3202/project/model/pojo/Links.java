package au.edu.sydney.soft3202.project.model.pojo;

public class Links {

    private String self;
    private String web;

    public String getSelf() {
        return self;
    }

    public String getWeb() {
        return web;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
