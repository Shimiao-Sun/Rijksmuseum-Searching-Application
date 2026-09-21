package au.edu.sydney.soft3202.project.model;

import au.edu.sydney.soft3202.project.model.pojo.*;

import java.util.Map;

public interface Service {

    CollectionResults getCollectionAPI(Map<String, String> params) throws Exception;

    CollectionDetailedObject getDetailedCollectionAPI(String objectNumber) throws Exception;

    String getStatus();
}
