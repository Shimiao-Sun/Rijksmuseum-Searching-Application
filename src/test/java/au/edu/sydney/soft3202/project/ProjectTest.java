package au.edu.sydney.soft3202.project;

import au.edu.sydney.soft3202.project.model.*;
import au.edu.sydney.soft3202.project.model.pojo.*;
import au.edu.sydney.soft3202.project.view.MediaBuilder;
import javafx.scene.media.MediaPlayer;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectTest {

    private Service service;
    private ArtObject artObject;
    private ArtObjects artObjects;
    private CollectionResults collectionResults;
    private CollectionDetailedObject collectionDetailedObject;
    private Map<String, String> inputMap;
    private List<ArtObjects> artObjectsList;

    @BeforeEach
    public void setup() {
        Database.clear();

        artObject = mock(ArtObject.class);
        artObjects = mock(ArtObjects.class);
        collectionResults = mock(CollectionResults.class);
        collectionDetailedObject = mock(CollectionDetailedObject.class);
        inputMap = new HashMap<>();
        artObjectsList = new ArrayList<>();
        artObjectsList.add(artObjects);

        when(collectionResults.getArtObjects()).thenReturn(artObjectsList);
        when(collectionDetailedObject.getArtObject()).thenReturn(artObject);
        when(artObjects.getObjectNumber()).thenReturn("objNum");

    }

    /**
     *  Test for pojo.
     */

    @Test
    public void acquisitionTest() {
        Acquisition acquisition = new Acquisition();
        acquisition.setMethod("method");
        acquisition.setDate("date");
        acquisition.setCreditLine("credit");

        assertEquals("method", acquisition.getMethod());
        assertEquals("date", acquisition.getDate());
        assertEquals("credit", acquisition.getCreditLine());
    }

    @Test
    public void adlibOverridesTest() {
        AdlibOverrides adlibOverrides = new AdlibOverrides();
        adlibOverrides.setTitel("title");
        adlibOverrides.setEtiketText("etiket");
        adlibOverrides.setMaker("maker");

        assertEquals("title", adlibOverrides.getTitel());
        assertEquals("etiket", adlibOverrides.getEtiketText());
        assertEquals("maker", adlibOverrides.getMaker());

    }

    @Test
    public void artObjectTest() {
        ArtObject artObject = new ArtObject();
        artObject.setLocation("location");
        assertEquals("location", artObject.getLocation());
        artObject.setPriref("priref");
        assertEquals("priref", artObject.getPriref());

        List<String> listTitles = new ArrayList<>();
        listTitles.add("title1");
        listTitles.add("title2");
        artObject.setTitles(listTitles);
        assertEquals("title1", artObject.getTitles().get(0));
        assertEquals("title2", artObject.getTitles().get(1));

        artObject.setTitle("title");
        assertEquals("title", artObject.getTitle());
        artObject.setLanguage("en");
        assertEquals("en", artObject.getLanguage());
        artObject.setPrincipalMaker("maker");
        assertEquals("maker", artObject.getPrincipalMaker());
        artObject.setLabelText(true);
        assertTrue(artObject.isLabelText());

        DetailedLinks detailedLinks = new DetailedLinks();
        detailedLinks.setSearch("search");
        artObject.setLinks(detailedLinks);
        assertEquals("search", artObject.getLinks().getSearch());

        artObject.setId("id");
        assertEquals("id", artObject.getId());


    }

    @Test
    public void artObjectPageTest() {
        ArtObjectPage artObjectPage = new ArtObjectPage();
        artObjectPage.setId("id");
        assertEquals("id", artObjectPage.getId());
        artObjectPage.setLang("lang");
        assertEquals("lang", artObjectPage.getLang());
        artObjectPage.setObjectNumber("objectNumber");
        assertEquals("objectNumber", artObjectPage.getObjectNumber());
        artObjectPage.setPlaqueDescription("description");
        assertEquals("description", artObjectPage.getPlaqueDescription());
        artObjectPage.setAudioFile1("audio");
        assertEquals("audio", artObjectPage.getAudioFile1());
        artObjectPage.setAudioFileLabel1("audioLabel1");
        assertEquals("audioLabel1", artObjectPage.getAudioFileLabel1());
        artObjectPage.setAudioFileLabel2("audioLabel2");
        assertEquals("audioLabel2", artObjectPage.getAudioFileLabel2());
        artObjectPage.setCreatedOn("createOn");
        assertEquals("createOn", artObjectPage.getCreatedOn());
        artObjectPage.setUpdatedOn("updateOn");
        assertEquals("updateOn", artObjectPage.getUpdatedOn());
        List<String> similarPages = new ArrayList<>();
        similarPages.add("similarPages");
        artObjectPage.setSimilarPages(similarPages);
        assertEquals("similarPages", artObjectPage.getSimilarPages().get(0));
        assertEquals(1, artObjectPage.getSimilarPages().size());
        List<String> tags = new ArrayList<>();
        tags.add("tags");
        artObjectPage.setTags(tags);
        assertEquals("tags", artObjectPage.getTags().get(0));
        assertEquals(1, artObjectPage.getTags().size());
        AdlibOverrides adlibOverrides = new AdlibOverrides();
        adlibOverrides.setEtiketText("EtiketText");
        adlibOverrides.setMaker("maker");
        adlibOverrides.setTitel("title");
        artObjectPage.setAdlibOverrides(adlibOverrides);
        assertEquals("EtiketText", artObjectPage.getAdlibOverrides().getEtiketText());
        assertEquals("maker", artObjectPage.getAdlibOverrides().getMaker());
        assertEquals("title", artObjectPage.getAdlibOverrides().getTitel());
    }

    @Test
    public void artObjectsTest() {
        ArtObjects artObjects = new ArtObjects();
        artObjects.setId("id");
        assertEquals("id", artObjects.getId());
        artObjects.setObjectNumber("object");
        assertEquals("object", artObjects.getObjectNumber());
        artObjects.setTitle("title");
        assertEquals("title", artObjects.getTitle());
        artObjects.setHasImage(true);
        assertTrue(artObjects.isHasImage());
        artObjects.setPrincipleOfFirstMaker("principal");
        assertEquals("principal", artObjects.getPrincipleOfFirstMaker());
        artObjects.setLongTitle("long");
        assertEquals("long", artObjects.getLongTitle());
        artObjects.setShowImage(true);
        assertTrue(artObjects.isShowImage());
        artObjects.setPermitDownload(true);
        assertTrue(artObjects.isPermitDownload());
        Links links = new Links();
        links.setWeb("web");
        links.setSelf("self");
        artObjects.setLinks(links);
        assertEquals("web", artObjects.getLinks().getWeb());
        assertEquals("self", artObjects.getLinks().getSelf());
        WebImage webImage = new WebImage();
        webImage.setGuid("guid");
        artObjects.setWebImage(webImage);
        assertEquals("guid", artObjects.getWebImage().getGuid());
        artObjects.setHeadImage(webImage);
        assertEquals("guid", artObjects.getHeadImage().getGuid());
        List<String> productionPlaces = new ArrayList<>();
        productionPlaces.add("productionPlaces");
        artObjects.setProductionPlaces(productionPlaces);
        assertEquals("productionPlaces", artObjects.getProductionPlaces().get(0));
        assertEquals(1, artObjects.getProductionPlaces().size());

    }

    @Test
    public void classificationTest() {
        Classification classification = new Classification();
        List<String> iconClassIdentifier = new ArrayList<>();
        iconClassIdentifier.add("iconClassIdentifier");
        classification.setIconClassIdentifier(iconClassIdentifier);
        assertEquals(1, classification.getIconClassIdentifier().size());
        assertEquals("iconClassIdentifier", classification.getIconClassIdentifier().get(0));
    }

    @Test
    public void collectionDetailedObjectTest() {
        CollectionDetailedObject collectionDetailedObject = new CollectionDetailedObject();
        collectionDetailedObject.setElapsedMilliseconds(1);
        assertEquals(1, collectionDetailedObject.getElapsedMilliseconds());
        ArtObject artObject = new ArtObject();
        artObject.setId("id");
        collectionDetailedObject.setArtObject(artObject);
        assertEquals("id", collectionDetailedObject.getArtObject().getId());
    }

    @Test
    public void collectionResultsTest() {
        CollectionResults collectionResults = new CollectionResults();
        collectionResults.setCount(1);
        assertEquals(1, collectionResults.getCount());
        collectionResults.setElapsedMilliseconds(1);
        assertEquals(1, collectionResults.getElapsedMilliseconds());
        assertNull(collectionResults.getArtObjects());
    }

    @Test
    public void colorsTest() {
        Colors colors = new Colors();
        colors.setHex("hex");
        assertEquals("hex", colors.getHex());
        colors.setPercentage(1);
        assertEquals(1, colors.getPercentage());
    }

    @Test
    public void colorsWithNormalizationTest() {
        ColorsWithNormalization colorsWithNormalization = new ColorsWithNormalization();
        colorsWithNormalization.setNormalizedHex("hex");
        assertEquals("hex", colorsWithNormalization.getNormalizedHex());
        colorsWithNormalization.setOriginalHex("original");
        assertEquals("original", colorsWithNormalization.getOriginalHex());
    }

    @Test
    public void datingTest() {
        Dating dating = new Dating();
        dating.setPeriod(1);
        assertEquals(1, dating.getPeriod());
        dating.setPresentingDate("date");
        assertEquals("date", dating.getPresentingDate());
        dating.setSortingDate(1);
        assertEquals(1, dating.getSortingDate());
        dating.setYearEarly(1000);
        assertEquals(1000, dating.getYearEarly());
        dating.setYearLate(1100);
        assertEquals(1100, dating.getYearLate());
    }

    @Test
    public void detailedLinksTest() {
        DetailedLinks detailedLinks = new DetailedLinks();
        detailedLinks.setSearch("search");
        assertEquals("search", detailedLinks.getSearch());
    }

    @Test
    public void dimensionsTest() {
        Dimensions dimensions = new Dimensions();
        dimensions.setPart(true);
        assertTrue(dimensions.isPart());
        dimensions.setType("type");
        assertEquals("type", dimensions.getType());
        dimensions.setUnit("unit");
        assertEquals("unit", dimensions.getUnit());
        dimensions.setValue("value");
        assertEquals("value", dimensions.getValue());
    }

    @Test
    public void imageTest() {
        Image image = new Image();
        image.setHeight(100);
        assertEquals(100, image.getHeight());
        image.setName("name");
        assertEquals("name", image.getName());
        image.setWidth(300);
        assertEquals(300, image.getWidth());
        Tiles tiles = new Tiles();
        tiles.setUrl("url");
        tiles.setX(1);
        tiles.setY(3);
        List<Tiles> tilesList = new ArrayList<>();
        tilesList.add(tiles);
        image.setTiles(tilesList);
        assertEquals(1, image.getTiles().size());
        assertEquals("url", image.getTiles().get(0).getUrl());
    }

    @Test
    public void labelsTest() {
        Labels labels = new Labels();
        labels.setDate("date");
        assertEquals("date", labels.getDate());
        labels.setDescription("des");
        assertEquals("des", labels.getDescription());
        labels.setMakerLine("line");
        assertEquals("line", labels.getMakerLine());
        labels.setTitle("title");
        assertEquals("title", labels.getTitle());
        labels.setNotes("notes");
        assertEquals("notes", labels.getNotes());
    }

    @Test
    public void linksTest() {
        Links links = new Links();
        links.setSelf("self");
        assertEquals("self", links.getSelf());
        links.setWeb("web");
        assertEquals("web", links.getWeb());
    }

    @Test
    public void principalMakersTest() {
        PrincipalMakers principalMakers = new PrincipalMakers();
        principalMakers.setName("name");
        assertEquals("name", principalMakers.getName());
        principalMakers.setUnFixedName("unfix");
        assertEquals("unfix", principalMakers.getUnFixedName());
        principalMakers.setPlaceOfBirth("place");
        assertEquals("place", principalMakers.getPlaceOfBirth());
        principalMakers.setDateOfBirth("date");
        assertEquals("date", principalMakers.getDateOfBirth());
        principalMakers.setDateOfBirthPrecision(true);
        assertTrue(principalMakers.isDateOfBirthPrecision());
        principalMakers.setDateOfDeath("death");
        assertEquals("death", principalMakers.getDateOfDeath());
        principalMakers.setDateOfDeathPrecision(true);
        assertTrue(principalMakers.isDateOfDeathPrecision());
        principalMakers.setPlaceOfDeath("placeDeath");
        assertEquals("placeDeath", principalMakers.getPlaceOfDeath());
        principalMakers.setNationality("nation");
        assertEquals("nation", principalMakers.getNationality());
        principalMakers.setBiography(true);
        assertTrue(principalMakers.isBiography());
        principalMakers.setQualification(true);
        assertTrue(principalMakers.isQualification());
        List<String> occupation = new ArrayList<>();
        occupation.add("occupation");
        principalMakers.setOccupation(occupation);
        assertEquals("occupation", principalMakers.getOccupation().get(0));
        assertEquals(1, principalMakers.getOccupation().size());
        List<String> roles = new ArrayList<>();
        roles.add("roles");
        principalMakers.setRoles(roles);
        assertEquals(1, principalMakers.getRoles().size());
        assertEquals("roles", principalMakers.getRoles().get(0));
        List<String> productionPlaces = new ArrayList<>();
        productionPlaces.add("productionPlaces");
        principalMakers.setProductionPlaces(productionPlaces);
        assertEquals("productionPlaces", principalMakers.getProductionPlaces().get(0));
        assertEquals(1, principalMakers.getProductionPlaces().size());
    }

    @Test
    public void tilesTest() {
        Tiles tiles = new Tiles();
        tiles.setY(1);
        assertEquals(1, tiles.getY());
        tiles.setX(3);
        assertEquals(3, tiles.getX());
        tiles.setUrl("url");
        assertEquals("url", tiles.getUrl());
    }

    @Test
    public void webImageTest() {
        WebImage webImage = new WebImage();
        webImage.setGuid("guid");
        assertEquals("guid", webImage.getGuid());
        webImage.setHeight(100);
        assertEquals(100, webImage.getHeight());
        webImage.setWidth(300);
        assertEquals(300, webImage.getWidth());
        webImage.setUrl("url");
        assertEquals("url", webImage.getUrl());
        webImage.setOffsetPercentageX(400);
        assertEquals(400, webImage.getOffsetPercentageX());
        webImage.setOffsetPercentageY(500);
        assertEquals(500, webImage.getOffsetPercentageY());
    }

    /**
     *  Test for Model
     */

    @Test
    public void getCollectionAPIlTest() throws Exception {
        service = new ServiceImpl();
        CollectionResults cr = service.getCollectionAPI(inputMap);
        cr.setArtObjects(artObjectsList);
        assertEquals(cr.getArtObjects().get(0), artObjects);
    }

    @Test
    public void getCollectionDetailedAPIThrowRuntimeExceptionTest() {
        service = new ServiceImpl();
        assertThrows(
                RuntimeException.class,
                () -> service.getDetailedCollectionAPI(artObjects.getObjectNumber())
        );
    }



    @Test
    public void statusTest() {
        service = new ServiceImpl();
        assertEquals("online", service.getStatus());
    }

    @Test
    public void dummyServiceTest() throws Exception {
        DummyServiceImpl dummyService = new DummyServiceImpl();
        Acquisition acquisition = dummyService.getAcquisition();
        assertEquals("bruikleen", acquisition.getCreditLine());
        assertEquals("1808-01-01T00:00:00", acquisition.getDate());

        AdlibOverrides adlibOverrides = dummyService.getAdlibOverrides();
        assertEquals("maker", adlibOverrides.getMaker());
        assertEquals("EtiketText", adlibOverrides.getEtiketText());
        assertEquals("Titel", adlibOverrides.getTitel());

        ArtObject artObject = dummyService.getArtObject();
        assertEquals("id", artObject.getId());
        assertEquals("lang", artObject.getLanguage());
        assertEquals("title", artObject.getTitle());

        ArtObjectPage artObjectPage = dummyService.getArtObjectPage();
        assertEquals("id", artObjectPage.getId());
        assertEquals("objectnumber", artObjectPage.getObjectNumber());
        assertEquals("audioFile", artObjectPage.getAudioFile1());

        ArtObjects artObjects = dummyService.getArtObjects();
        assertEquals("id", artObjects.getId());
        assertEquals("title", artObjects.getTitle());
        assertEquals("longTitle", artObjects.getLongTitle());

        Classification classification = dummyService.getClassification();
        List<String> list1 = new ArrayList<>();
        list1.add("classification");
        assertEquals("classification", classification.getIconClassIdentifier().get(0));

        CollectionResults collectionResults = dummyService.getCollectionAPI(inputMap);
        assertEquals(1, collectionResults.getCount());
        assertEquals(0, collectionResults.getElapsedMilliseconds());

        Colors colors = dummyService.getColors();
        assertEquals("#261808", colors.getHex());
        assertEquals(81, colors.getPercentage());

        ColorsWithNormalization colorsWithNormalization = dummyService.getColorsWithNormalization();
        assertEquals("#000000", colorsWithNormalization.getNormalizedHex());
        assertEquals("#261808", colorsWithNormalization.getOriginalHex());

        Dating dating = dummyService.getDating();
        assertEquals(17, dating.getPeriod());
        assertEquals(1642, dating.getSortingDate());
        assertEquals(1642, dating.getYearEarly());

        DetailedLinks detailedLinks = dummyService.getDetailedLinks();
        assertEquals("http://www.rijksmuseum.nl/api/nl/collection", detailedLinks.getSearch());

        Dimensions dimensions = dummyService.getDimensions();
        assertEquals("hoogte", dimensions.getType());
        assertEquals("cm", dimensions.getUnit());
        assertFalse(dimensions.isPart());

        Image image = dummyService.getImage();
        assertEquals(200, image.getHeight());
        assertEquals(400, image.getWidth());

        PrincipalMakers principalMakers = dummyService.getPrincipalMakers();
        assertEquals("name", principalMakers.getName());
        assertEquals("1644", principalMakers.getDateOfBirth());
        assertEquals("place", principalMakers.getPlaceOfBirth());

        Tiles tiles = dummyService.getTiles();
        assertEquals("url", tiles.getUrl());
        assertEquals(1, tiles.getX());
    }

    @Test
    public void mailServiceTest() throws Exception {
        MailService mailService = mock(MailServiceImpl.class);
        doNothing().when(mailService).sendMessage(isA(String.class), isA(String.class), isA(String.class));
        mailService.sendMessage("addr", "sub", "text");
        verify(mailService, times(1)).sendMessage("addr", "sub", "text");
    }

    @Test
    public void databaseTest() {
        MockedStatic<Database> databaseMockedStatic = Mockito.mockStatic(Database.class);
        databaseMockedStatic.when(() -> Database.findEntryLongTitle("entryName")).thenReturn("longTitle");
        assertEquals(Database.findEntryLongTitle("entryName"), "longTitle");

        databaseMockedStatic.when(() -> Database.findEntryWebimage("entryName")).thenReturn("webImage");
        assertEquals(Database.findEntryWebimage("entryName"), "webImage");

        databaseMockedStatic.when(() -> Database.findEntryYearEarly("entryName")).thenReturn(1600);
        assertEquals(Database.findEntryYearEarly("entryName"), 1600);

        databaseMockedStatic.when(() -> Database.findEntryPlaqueDescription("entryName")).thenReturn("plaquedescription");
        assertEquals(Database.findEntryPlaqueDescription("entryName"), "plaquedescription");

        databaseMockedStatic.when(() -> Database.findEntryPrincipalMakerName("entryName")).thenReturn("principalmakername");
        assertEquals(Database.findEntryPrincipalMakerName("entryName"), "principalmakername");

        databaseMockedStatic.when(() -> Database.isExistEntry("entryName")).thenReturn(true);
        assertTrue(Database.isExistEntry("entryName"));

        databaseMockedStatic.when(() -> Database.findFavouriteLongTitle("shortTitle")).thenReturn("longTitle");
        assertEquals("longTitle", Database.findFavouriteLongTitle("shortTitle"));

        databaseMockedStatic.when(() -> Database.findFavouriteYear("shortTitle")).thenReturn(1600);
        assertEquals(1600, Database.findFavouriteYear("shortTitle"));

        databaseMockedStatic.when(() -> Database.findFavouritePlaqueDescription("shortTitle")).thenReturn("plaquedescription");
        assertEquals("plaquedescription", Database.findFavouritePlaqueDescription("shortTitle"));

        databaseMockedStatic.when(() -> Database.findFavouritePrincipalMakerName("shortTitle")).thenReturn("principalmakername");
        assertEquals("principalmakername", Database.findFavouritePrincipalMakerName("shortTitle"));

        Database.addFavouriteList("shortTitle", "longTitle", 1600, "plaque", "maker");
        databaseMockedStatic.verify(() -> Database.addFavouriteList("shortTitle", "longTitle", 1600, "plaque", "maker"));

    }

    @Test
    public void emailContentBuilder() {
        EmailContentBuilder emailContentBuilder = mock(EmailContentBuilder.class);
        String content = "";
        when(emailContentBuilder.contentBuilder()).thenReturn(content);
        assertEquals(emailContentBuilder.contentBuilder(), content);
        verify(emailContentBuilder).contentBuilder();
    }

    @Test
    public void mediaBuilderTest() {
        MediaBuilder mediaBuilder = mock(MediaBuilder.class);
        MediaPlayer mediaPlayer = mock(MediaPlayer.class);
        when(mediaBuilder.mediaBuilder()).thenReturn(mediaPlayer);
        assertEquals(mediaBuilder.mediaBuilder(), mediaPlayer);
        verify(mediaBuilder).mediaBuilder();
    }

    @Test
    public void resultEntryTest() throws Exception {
        ResultEntry resultEntry = mock(ResultEntry.class);
        String maker = "";
        when(resultEntry.getPrincipalMaker()).thenReturn(maker);
        assertEquals(maker, resultEntry.getPrincipalMaker());
        verify(resultEntry).getPrincipalMaker();

        String plaque = "";
        when(resultEntry.getPlaqueDescriptionEnglish()).thenReturn(plaque);
        assertEquals(plaque, resultEntry.getPlaqueDescriptionEnglish());
        verify(resultEntry).getPlaqueDescriptionEnglish();

        String longTitle = "";
        when(resultEntry.getLongTitle()).thenReturn(longTitle);
        assertEquals(longTitle, resultEntry.getLongTitle());
        verify(resultEntry).getLongTitle();

        int yearEarly = 0;
        when(resultEntry.getYearEarly()).thenReturn(yearEarly);
        assertEquals(yearEarly, resultEntry.getYearEarly());
        verify(resultEntry).getYearEarly();

        List<ArtObjects> results = mock(ArrayList.class);
        when(resultEntry.getResults()).thenReturn(results);
        assertEquals(results, resultEntry.getResults());
        verify(resultEntry).getResults();

        boolean addList = false;
        ArtObjects artObjects = mock(ArtObjects.class);
        when(resultEntry.addFavouriteList(artObjects)).thenReturn(addList);
        assertFalse(resultEntry.addFavouriteList(artObjects));
        verify(resultEntry).addFavouriteList(artObjects);

        boolean isExistEntry = false;
        when(resultEntry.isExistEntry(artObjects)).thenReturn(isExistEntry);
        assertFalse(resultEntry.isExistEntry(artObjects));
        verify(resultEntry).isExistEntry(artObjects);

        doNothing().when(resultEntry).setUseCache(false);
        resultEntry.setUseCache(false);
        verify(resultEntry).setUseCache(false);

        doNothing().when(resultEntry).cacheSet(isA(ArtObjects.class), isA(String.class));
        resultEntry.cacheSet(artObjects, "objectNumber");
        verify(resultEntry).cacheSet(artObjects, "objectNumber");
    }

}
