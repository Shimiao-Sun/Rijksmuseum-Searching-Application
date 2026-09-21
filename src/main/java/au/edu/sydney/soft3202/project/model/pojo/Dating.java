package au.edu.sydney.soft3202.project.model.pojo;

public class Dating {

    private String presentingDate;
    private int sortingDate;
    private int period;
    private int yearEarly;
    private int yearLate;

    public int getPeriod() {
        return period;
    }

    public int getSortingDate() {
        return sortingDate;
    }

    public int getYearEarly() {
        return yearEarly;
    }

    public int getYearLate() {
        return yearLate;
    }

    public String getPresentingDate() {
        return presentingDate;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPresentingDate(String presentingDate) {
        this.presentingDate = presentingDate;
    }

    public void setSortingDate(int sortingDate) {
        this.sortingDate = sortingDate;
    }

    public void setYearEarly(int yearEarly) {
        this.yearEarly = yearEarly;
    }

    public void setYearLate(int yearLate) {
        this.yearLate = yearLate;
    }

    @Override
    public String toString() {
        return "Dating{" +
                "presentingDate='" + presentingDate + '\'' +
                ", sortingDate=" + sortingDate +
                ", period=" + period +
                ", yearEarly=" + yearEarly +
                ", yearLate=" + yearLate +
                '}';
    }
}
