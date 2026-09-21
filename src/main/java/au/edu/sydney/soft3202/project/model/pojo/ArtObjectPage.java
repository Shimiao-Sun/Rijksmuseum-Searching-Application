package au.edu.sydney.soft3202.project.model.pojo;

import java.util.List;

public class ArtObjectPage {

    private String id;
    private List<String> similarPages;
    private String lang;
    private String objectNumber;
    private List<String> tags;
    private String plaqueDescription;
    private String audioFile1;
    private String audioFileLabel1;
    private String audioFileLabel2;
    private String createdOn;
    private String updatedOn;
    private AdlibOverrides adlibOverrides;

    @Override
    public String toString() {
        return "ArtObjectPage{" +
                "id='" + id + '\'' +
                ", similarPages=" + similarPages +
                ", lang='" + lang + '\'' +
                ", objectNumber='" + objectNumber + '\'' +
                ", tags=" + tags +
                ", plaqueDescription='" + plaqueDescription + '\'' +
                ", audioFile1='" + audioFile1 + '\'' +
                ", audioFileLabel1='" + audioFileLabel1 + '\'' +
                ", audioFileLabel2='" + audioFileLabel2 + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", adlibOverrides=" + adlibOverrides +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setObjectNumber(String objectNumber) {
        this.objectNumber = objectNumber;
    }

    public String getObjectNumber() {
        return objectNumber;
    }

    public AdlibOverrides getAdlibOverrides() {
        return adlibOverrides;
    }

    public List<String> getSimilarPages() {
        return similarPages;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getAudioFile1() {
        return audioFile1;
    }

    public String getAudioFileLabel1() {
        return audioFileLabel1;
    }

    public String getAudioFileLabel2() {
        return audioFileLabel2;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getLang() {
        return lang;
    }

    public String getPlaqueDescription() {
        return plaqueDescription;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setAdlibOverrides(AdlibOverrides adlibOverrides) {
        this.adlibOverrides = adlibOverrides;
    }

    public void setAudioFile1(String audioFile1) {
        this.audioFile1 = audioFile1;
    }

    public void setAudioFileLabel1(String audioFileLabel1) {
        this.audioFileLabel1 = audioFileLabel1;
    }

    public void setAudioFileLabel2(String audioFileLabel2) {
        this.audioFileLabel2 = audioFileLabel2;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setPlaqueDescription(String plaqueDescription) {
        this.plaqueDescription = plaqueDescription;
    }

    public void setSimilarPages(List<String> similarPages) {
        this.similarPages = similarPages;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
