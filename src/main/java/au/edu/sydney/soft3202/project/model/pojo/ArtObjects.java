package au.edu.sydney.soft3202.project.model.pojo;

import java.util.*;

public class ArtObjects {

    private Links links;
    private String id;
    private String objectNumber;
    private String title;
    private boolean hasImage;
    private String principleOfFirstMaker;
    private String longTitle;
    private boolean showImage;
    private boolean permitDownload;
    private WebImage webImage;
    private WebImage headerImage;
    private List<String> productionPlaces;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectNumber() {
        return objectNumber;
    }

    public void setObjectNumber(String objectNumber) {
        this.objectNumber = objectNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public boolean isPermitDownload() {
        return permitDownload;
    }

    public void setPermitDownload(boolean permitDownload) {
        this.permitDownload = permitDownload;
    }

    public boolean isShowImage() {
        return showImage;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public String getPrincipleOfFirstMaker() {
        return principleOfFirstMaker;
    }

    public void setPrincipleOfFirstMaker(String principleOfFirstMaker) {
        this.principleOfFirstMaker = principleOfFirstMaker;
    }

    public WebImage getHeadImage() {
        return headerImage;
    }

    public void setHeadImage(WebImage headImage) {
        this.headerImage = headImage;
    }

    public WebImage getWebImage() {
        return webImage;
    }

    public void setWebImage(WebImage webImage) {
        this.webImage = webImage;
    }

    public List<String> getProductionPlaces() {
        return productionPlaces;
    }

    public void setProductionPlaces(List<String> productionPlaces) {
        this.productionPlaces = productionPlaces;
    }

    @Override
    public String toString() {
        return "ArtObjects{" +
                "links=" + links +
                ", id='" + id + '\'' +
                ", objectNumber='" + objectNumber + '\'' +
                ", title='" + title + '\'' +
                ", hasImage=" + hasImage +
                ", principleOfFirstMaker='" + principleOfFirstMaker + '\'' +
                ", longTitle='" + longTitle + '\'' +
                ", showImage=" + showImage +
                ", permitDownload=" + permitDownload +
                ", webImage=" + webImage +
                ", headerImage=" + headerImage +
                ", productionPlaces=" + productionPlaces +
                '}';
    }
}
