package au.edu.sydney.soft3202.project.model.pojo;

import java.util.List;

public class ArtObject {

    private DetailedLinks links;
    private String id;
    private String priref;
    private String language;
    private String title;
    private boolean copyrightHolder;
    private WebImage webImage;
    private List<Colors> colors;
    private List<ColorsWithNormalization> colorsWithNormalization;
    private List<Colors> normalizedColors;
    private List<Colors> normalized32Colors;
    private List<String> titles;
    private String description;
    private boolean labelText;
    private List<String> objectTypes;
    private List<Object> makers;
    private List<PrincipalMakers> principalMakers;
    private String plaqueDescriptionDutch;
    private String plaqueDescriptionEnglish;
    private String principalMaker;
    private boolean artistRole;
    private List<String> associations;
    private Acquisition acquisition;
    private List<String> exhibitions;
    private List<String> materials;
    private List<String> techniques;
    private List<String> productionPlaces;
    private Dating dating;
    private Classification classification;
    private boolean hasImage;
    private List<String> historicalPersons;
    private List<String> inscriptions;
    private List<String> documentation;
    private List<String> catRefRPK;
    private String principalOrFirstMaker;
    private List<Dimensions> dimensions;
    private List<String> physicalProperties;
    private String physicalMedium;
    private String longTitle;
    private String subTitle;
    private String scLabelLine;
    private Labels label;
    private boolean showImage;
    private String location;
    private ArtObjectPage artObjectPage;

    @Override
    public String toString() {
        return "ArtObject{" +
                "links=" + links +
                ", id='" + id + '\'' +
                ", priref='" + priref + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", copyrightHolder=" + copyrightHolder +
                ", webImage=" + webImage +
                ", colors=" + colors +
                ", colorsWithNormalization=" + colorsWithNormalization +
                ", normalizedColors=" + normalizedColors +
                ", normalized32Colors=" + normalized32Colors +
                ", titles=" + titles +
                ", description='" + description + '\'' +
                ", labelText=" + labelText +
                ", objectTypes=" + objectTypes +
                ", makers=" + makers +
                ", principalMakers=" + principalMakers +
                ", plaqueDescriptionDutch='" + plaqueDescriptionDutch + '\'' +
                ", plaqueDescriptionEnglish='" + plaqueDescriptionEnglish + '\'' +
                ", principalMaker='" + principalMaker + '\'' +
                ", artistRole=" + artistRole +
                ", associations=" + associations +
                ", acquisition=" + acquisition +
                ", exhibitions=" + exhibitions +
                ", materials=" + materials +
                ", techniques=" + techniques +
                ", productionPlaces=" + productionPlaces +
                ", dating=" + dating +
                ", classification=" + classification +
                ", hasImage=" + hasImage +
                ", historicalPersons=" + historicalPersons +
                ", inscriptions=" + inscriptions +
                ", documentation=" + documentation +
                ", catRefRPK=" + catRefRPK +
                ", principalOrFirstMaker='" + principalOrFirstMaker + '\'' +
                ", dimensions=" + dimensions +
                ", physicalProperties=" + physicalProperties +
                ", physicalMedium='" + physicalMedium + '\'' +
                ", longTitle='" + longTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", scLabelLine='" + scLabelLine + '\'' +
                ", label=" + label +
                ", showImage=" + showImage +
                ", location='" + location + '\'' +
                ", artObjectPage=" + artObjectPage +
                '}';
    }

    public List<String> getProductionPlaces() {
        return productionPlaces;
    }

    public void setProductionPlaces(List<String> productionPlaces) {
        this.productionPlaces = productionPlaces;
    }

    public void setWebImage(WebImage webImage) {
        this.webImage = webImage;
    }

    public WebImage getWebImage() {
        return webImage;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    public boolean isShowImage() {
        return showImage;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLinks(DetailedLinks links) {
        this.links = links;
    }

    public DetailedLinks getLinks() {
        return links;
    }

    public Acquisition getAcquisition() {
        return acquisition;
    }

    public boolean isArtistRole() {
        return artistRole;
    }

    public boolean isCopyrightHolder() {
        return copyrightHolder;
    }

    public boolean isLabelText() {
        return labelText;
    }

    public Classification getClassification() {
        return classification;
    }

    public Dating getDating() {
        return dating;
    }

    public Labels getLabel() {
        return label;
    }

    public List<Colors> getColors() {
        return colors;
    }

    public List<Colors> getNormalized32Colors() {
        return normalized32Colors;
    }

    public List<Colors> getNormalizedColors() {
        return normalizedColors;
    }

    public List<ColorsWithNormalization> getColorsWithNormalization() {
        return colorsWithNormalization;
    }

    public List<Dimensions> getDimensions() {
        return dimensions;
    }

    public List<PrincipalMakers> getPrincipalMakers() {
        return principalMakers;
    }

    public List<String> getAssociations() {
        return associations;
    }

    public List<String> getCatRefRPK() {
        return catRefRPK;
    }

    public List<String> getDocumentation() {
        return documentation;
    }

    public List<String> getExhibitions() {
        return exhibitions;
    }

    public List<String> getHistoricalPersons() {
        return historicalPersons;
    }

    public List<String> getInscriptions() {
        return inscriptions;
    }

    public List<Object> getMakers() {
        return makers;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public List<String> getObjectTypes() {
        return objectTypes;
    }

    public List<String> getPhysicalProperties() {
        return physicalProperties;
    }

    public List<String> getTechniques() {
        return techniques;
    }

    public List<String> getTitles() {
        return titles;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getPhysicalMedium() {
        return physicalMedium;
    }

    public String getPlaqueDescriptionDutch() {
        return plaqueDescriptionDutch;
    }

    public String getPlaqueDescriptionEnglish() {
        return plaqueDescriptionEnglish;
    }

    public String getPrincipalMaker() {
        return principalMaker;
    }

    public String getPrincipalOrFirstMaker() {
        return principalOrFirstMaker;
    }

    public String getLocation() {
        return location;
    }

    public String getPriref() {
        return priref;
    }

    public String getScLabelLine() {
        return scLabelLine;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public void setArtistRole(boolean artistRole) {
        this.artistRole = artistRole;
    }

    public void setAssociations(List<String> associations) {
        this.associations = associations;
    }

    public void setCatRefRPK(List<String> catRefRPK) {
        this.catRefRPK = catRefRPK;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public void setColors(List<Colors> colors) {
        this.colors = colors;
    }

    public void setColorsWithNormalization(List<ColorsWithNormalization> colorsWithNormalization) {
        this.colorsWithNormalization = colorsWithNormalization;
    }

    public void setCopyrightHolder(boolean copyrightHolder) {
        this.copyrightHolder = copyrightHolder;
    }

    public void setDating(Dating dating) {
        this.dating = dating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(List<Dimensions> dimensions) {
        this.dimensions = dimensions;
    }

    public void setDocumentation(List<String> documentation) {
        this.documentation = documentation;
    }

    public void setExhibitions(List<String> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public void setHistoricalPersons(List<String> historicalPersons) {
        this.historicalPersons = historicalPersons;
    }

    public void setInscriptions(List<String> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public void setLabelText(boolean labelText) {
        this.labelText = labelText;
    }

    public void setLabel(Labels label) {
        this.label = label;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMakers(List<Object> makers) {
        this.makers = makers;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public void setNormalized32Colors(List<Colors> normalized32Colors) {
        this.normalized32Colors = normalized32Colors;
    }

    public void setNormalizedColors(List<Colors> normalizedColors) {
        this.normalizedColors = normalizedColors;
    }

    public void setObjectTypes(List<String> objectTypes) {
        this.objectTypes = objectTypes;
    }

    public void setPhysicalMedium(String physicalMedium) {
        this.physicalMedium = physicalMedium;
    }

    public void setPhysicalProperties(List<String> physicalProperties) {
        this.physicalProperties = physicalProperties;
    }

    public void setPlaqueDescriptionDutch(String plaqueDescriptionDutch) {
        this.plaqueDescriptionDutch = plaqueDescriptionDutch;
    }

    public void setPlaqueDescriptionEnglish(String plaqueDescriptionEnglish) {
        this.plaqueDescriptionEnglish = plaqueDescriptionEnglish;
    }

    public void setPrincipalMaker(String principalMaker) {
        this.principalMaker = principalMaker;
    }

    public void setPrincipalMakers(List<PrincipalMakers> principalMakers) {
        this.principalMakers = principalMakers;
    }

    public void setPrincipalOrFirstMaker(String principalOrFirstMaker) {
        this.principalOrFirstMaker = principalOrFirstMaker;
    }

    public void setPriref(String priref) {
        this.priref = priref;
    }

    public void setScLabelLine(String scLabelLine) {
        this.scLabelLine = scLabelLine;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setTechniques(List<String> techniques) {
        this.techniques = techniques;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public ArtObjectPage getArtObjectPage() {
        return artObjectPage;
    }

    public void setArtObjectPage(ArtObjectPage artObjectPage) {
        this.artObjectPage = artObjectPage;
    }

}
