package au.edu.sydney.soft3202.project.model.pojo;

public class Labels {

    private String title;
    private String makerLine;
    private String description;
    private String notes;
    private String date;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getMakerLine() {
        return makerLine;
    }

    public String getNotes() {
        return notes;
    }

    public void setMakerLine(String makerLine) {
        this.makerLine = makerLine;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "title='" + title + '\'' +
                ", makerLine='" + makerLine + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
