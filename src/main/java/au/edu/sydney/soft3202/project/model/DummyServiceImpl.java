package au.edu.sydney.soft3202.project.model;

import au.edu.sydney.soft3202.project.model.pojo.*;

import java.util.*;
import java.util.List;

/**
 * a dummy input API implement.
 */
public class DummyServiceImpl implements Service{

    private final String status = "offline";

    public Acquisition getAcquisition() {

        Acquisition acquisition = new Acquisition();
        acquisition.setCreditLine("bruikleen");
        acquisition.setDate("1808-01-01T00:00:00");
        acquisition.setMethod("Bruikleen van de gemeente Amsterdam");
        return acquisition;
    }

    public AdlibOverrides getAdlibOverrides() {

        AdlibOverrides adlibOverrides = new AdlibOverrides();
        adlibOverrides.setMaker("maker");
        adlibOverrides.setEtiketText("EtiketText");
        adlibOverrides.setTitel("Titel");
        return adlibOverrides;
    }

    public ArtObject getArtObject() {

        ArtObject artObject = new ArtObject();
        artObject.setArtObjectPage(this.getArtObjectPage());
        artObject.setAcquisition(this.getAcquisition());
        artObject.setArtistRole(true);
        artObject.setAssociations(null);
        artObject.setDescription("description");
        artObject.setCatRefRPK(null);
        artObject.setClassification(this.getClassification());
        artObject.setColors(null);
        artObject.setColorsWithNormalization(null);
        artObject.setCopyrightHolder(true);
        artObject.setDating(this.getDating());
        artObject.setId("id");
        artObject.setDocumentation(null);
        artObject.setExhibitions(null);
        artObject.setHasImage(true);
        artObject.setLabel(this.getLabels());
        artObject.setDimensions(null);
        artObject.setLabelText(true);
        artObject.setLanguage("lang");
        artObject.setMakers(null);
        artObject.setPrincipalMaker("principalMaker");
        artObject.setWebImage(this.getWebImage());
        artObject.setTitle("title");
        artObject.setTitles(null);
        artObject.setPriref("priref");
        artObject.setHistoricalPersons(null);
        artObject.setInscriptions(null);
        artObject.setLocation("location");
        artObject.setMaterials(null);
        artObject.setNormalized32Colors(null);
        artObject.setNormalizedColors(null);
        artObject.setObjectTypes(null);
        artObject.setPhysicalMedium("physicalMedium");
        artObject.setPhysicalProperties(null);
        artObject.setPlaqueDescriptionDutch("plaque");
        artObject.setPlaqueDescriptionEnglish("english");
        artObject.setPrincipalMakers(null);
        artObject.setPrincipalOrFirstMaker(null);
        artObject.setScLabelLine("sclabelline");
        artObject.setSubTitle("subTitle");
        artObject.setTechniques(null);
        return artObject;
    }

    public ArtObjectPage getArtObjectPage() {

        ArtObjectPage artObjectPage = new ArtObjectPage();
        artObjectPage.setAdlibOverrides(this.getAdlibOverrides());
        artObjectPage.setObjectNumber("objectnumber");
        artObjectPage.setAudioFile1("audioFile");
        artObjectPage.setId("id");
        artObjectPage.setSimilarPages(null);
        artObjectPage.setLang("lang");
        artObjectPage.setAudioFileLabel1("label1");
        artObjectPage.setAudioFileLabel2("label2");
        artObjectPage.setCreatedOn("createOn");
        artObjectPage.setPlaqueDescription("plaque");
        artObjectPage.setTags(null);
        artObjectPage.setUpdatedOn("updateOn");
        return artObjectPage;
    }

    public ArtObjects getArtObjects() {

        ArtObjects artObjects = new ArtObjects();
        artObjects.setObjectNumber("objectNumber");
        artObjects.setId("id");
        artObjects.setTitle("title");
        artObjects.setProductionPlaces(null);
        artObjects.setHasImage(true);
        artObjects.setHeadImage(this.getWebImage());
        artObjects.setLinks(this.getLinks());
        artObjects.setLongTitle("longTitle");
        artObjects.setPermitDownload(true);
        artObjects.setPrincipleOfFirstMaker("firstMaker");
        artObjects.setShowImage(true);
        artObjects.setWebImage(this.getWebImage());
        return artObjects;
    }

    public Classification getClassification() {

        Classification classification = new Classification();
        List<String> list1 = new ArrayList<>();
        list1.add("classification");
        classification.setIconClassIdentifier(list1);
        return classification;
    }

    @Override
    public CollectionDetailedObject getDetailedCollectionAPI(String objectNumber) throws Exception{

        CollectionDetailedObject collectionDetailedObject = new CollectionDetailedObject();
        collectionDetailedObject.setElapsedMilliseconds(0);
        collectionDetailedObject.setArtObject(this.getArtObject());
        return collectionDetailedObject;
    }

    @Override
    public CollectionResults getCollectionAPI(Map<String, String> params) throws Exception{

        CollectionResults collectionResults = new CollectionResults();
        collectionResults.setCount(1);
        collectionResults.setElapsedMilliseconds(0);
        List<ArtObjects> list1 = new ArrayList<>();
        list1.add(this.getArtObjects());
        collectionResults.setArtObjects(list1);
        return collectionResults;
    }

    public Colors getColors() {

        Colors colors = new Colors();
        colors.setHex("#261808");
        colors.setPercentage(81);
        return colors;
    }

    public ColorsWithNormalization getColorsWithNormalization() {

        ColorsWithNormalization colorsWithNormalization = new ColorsWithNormalization();
        colorsWithNormalization.setNormalizedHex("#000000");
        colorsWithNormalization.setOriginalHex("#261808");
        return colorsWithNormalization;
    }

    public Dating getDating() {

        Dating dating = new Dating();
        dating.setPeriod(17);
        dating.setPresentingDate("1642");
        dating.setSortingDate(1642);
        dating.setYearEarly(1642);
        dating.setYearLate(1642);
        return dating;
    }

    public DetailedLinks getDetailedLinks() {

        DetailedLinks detailedLinks = new DetailedLinks();
        detailedLinks.setSearch("http://www.rijksmuseum.nl/api/nl/collection");
        return detailedLinks;
    }

    public Dimensions getDimensions() {

        Dimensions dimensions = new Dimensions();
        dimensions.setPart(false);
        dimensions.setType("hoogte");
        dimensions.setUnit("cm");
        dimensions.setValue("379,5");
        return dimensions;
    }

    public Image getImage() {

        Image image = new Image();
        image.setName("image");
        image.setHeight(200);
        image.setWidth(400);
        image.setTiles(null);
        return image;
    }

    public Labels getLabels() {

        Labels labels = new Labels();
        labels.setDate("1644");
        labels.setDescription("description");
        labels.setMakerLine(null);
        labels.setNotes("notes");
        labels.setTitle("title");
        return labels;
    }

    public Links getLinks() {

        Links links = new Links();
        links.setSelf("self");
        links.setWeb("web");
        return links;
    }

    public PrincipalMakers getPrincipalMakers() {

        PrincipalMakers principalMakers = new PrincipalMakers();
        principalMakers.setBiography(true);
        principalMakers.setName("name");
        principalMakers.setDateOfBirth("1644");
        principalMakers.setDateOfDeath("1644");
        principalMakers.setNationality("nationality");
        principalMakers.setDateOfBirthPrecision(false);
        principalMakers.setDateOfDeathPrecision(false);
        principalMakers.setPlaceOfBirth("place");
        principalMakers.setOccupation(null);
        principalMakers.setProductionPlaces(null);
        principalMakers.setQualification(true);
        principalMakers.setRoles(null);
        principalMakers.setUnFixedName("unfix");
        return principalMakers;
    }

    public Tiles getTiles() {

        Tiles tiles = new Tiles();
        tiles.setUrl("url");
        tiles.setX(1);
        tiles.setY(1);
        return tiles;
    }

    public WebImage getWebImage() {

        WebImage webImage = new WebImage();
        webImage.setHeight(2034);
        webImage.setWidth(2500);
        webImage.setUrl("https://lh3.googleusercontent.com/J-mxAE7CPu-DXIOx4QKBtb0GC4ud37da1QK7CzbTIDswmvZHXhLm4Tv2-1H3iBXJWAW_bHm7dMl3j5wv_XiWAg55VOM=s0");
        webImage.setGuid("aa08df9c-0af9-4195-b31b-f578fbe0a4c9");
        webImage.setOffsetPercentageX(0);
        webImage.setOffsetPercentageY(1);
        return webImage;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
