package au.edu.sydney.soft3202.project.model;

import au.edu.sydney.soft3202.project.model.pojo.ArtObject;
import au.edu.sydney.soft3202.project.model.pojo.ArtObjects;

import java.util.*;

public class ResultEntry {

    private Map<String, String> inputMap;
    private List<String> favouriteList;
    private Database database;
    private Service serviceImpl;
    private boolean useCache = false;

    private String imageUrl = null;
    private String longTitle = null;
    private String plaqueDescriptionEnglish = null;
    private String principalMaker = null;
    private int yearEarly = 0;

    public ResultEntry(Map<String, String> inputMap, List<String> favouriteList, Service serviceImpl, Database database) {
        this.inputMap = inputMap;
        this.database = database;
        this.favouriteList = favouriteList;
        this.serviceImpl = serviceImpl;
    }

    public void setUseCache(boolean cache) {
        useCache = cache;
    }

    public String getPrincipalMaker() {
        return principalMaker;
    }

    public String getPlaqueDescriptionEnglish() {
        return plaqueDescriptionEnglish;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public int getYearEarly() {
        return yearEarly;
    }

    public List<ArtObjects> getResults() throws Exception{
        List<ArtObjects> results = serviceImpl.getCollectionAPI(inputMap).getArtObjects();
        return results;
    }

    /**
     * check whether the input entry jit the cache in database or not
     * @param artObjects input entry
     * @return a boolean to show hit or not hit
     * @throws Exception
     */
    public boolean isExistEntry(ArtObjects artObjects) throws Exception {
        if(serviceImpl.getStatus().equals("online")) {
            String objectNumber = artObjects.getObjectNumber();
            return database.isExistEntry(objectNumber);
        } else {
            setDetailedData(artObjects, serviceImpl);
            return false;
        }
    }

    /**
     * check whether the user decide to use cache or not
     * @throws Exception
     */
    public void cacheSet(ArtObjects artObjects, String objectNumber) throws Exception {
        if(!useCache) {
            setDetailedData(artObjects, serviceImpl);
            database.addDataNotExist(objectNumber, imageUrl, longTitle, yearEarly, plaqueDescriptionEnglish, principalMaker);
        } else {
            imageUrl = database.findEntryWebimage(objectNumber);
            longTitle = database.findEntryLongTitle(objectNumber);
            yearEarly = database.findEntryYearEarly(objectNumber);
            plaqueDescriptionEnglish = database.findEntryPlaqueDescription(objectNumber);
            principalMaker = database.findEntryPrincipalMakerName(objectNumber);
        }
    }

    /**
     * add an art objects into favourite list and database
     */
    public boolean addFavouriteList(ArtObjects artObjects) throws Exception {
        for(String title: favouriteList) {
            if(artObjects.getTitle().equals(title)) {
                return false;
            }
        }
        favouriteList.add(artObjects.getTitle());
        setDetailedData(artObjects, serviceImpl);
        database.addFavouriteList(artObjects.getTitle(), longTitle, yearEarly, plaqueDescriptionEnglish, principalMaker);
        return true;
    }

    /**
     * set detailed data for get functions and for database.
     */
    private void setDetailedData(ArtObjects artObjects, Service serviceImpl) throws Exception {
        ArtObject artObject = serviceImpl.getDetailedCollectionAPI(artObjects.getObjectNumber()).getArtObject();
        imageUrl = artObjects.getWebImage().getUrl();
        longTitle = artObject.getLongTitle();
        plaqueDescriptionEnglish = artObject.getPlaqueDescriptionEnglish();
        yearEarly = artObject.getDating().getYearEarly();
        principalMaker = artObject.getPrincipalMaker();
    }
}
