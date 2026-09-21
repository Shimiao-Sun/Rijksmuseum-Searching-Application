package au.edu.sydney.soft3202.project.model.pojo;

public class Acquisition {

    private String method;
    private String date;
    private String creditLine;

    public String getCreditLine() {
        return creditLine;
    }

    public String getDate() {
        return date;
    }

    public String getMethod() {
        return method;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Acquisition{" +
                "method='" + method + '\'' +
                ", date='" + date + '\'' +
                ", creditLine='" + creditLine + '\'' +
                '}';
    }
}
