package au.edu.sydney.soft3202.project.model.pojo;

public class DetailedLinks {

    private String search;

    @Override
    public String toString() {
        return "DetailedLinks{" +
                "search='" + search + '\'' +
                '}';
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
