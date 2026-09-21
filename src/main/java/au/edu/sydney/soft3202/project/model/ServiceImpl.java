package au.edu.sydney.soft3202.project.model;

import au.edu.sydney.soft3202.project.utils.HttpUtil;
import au.edu.sydney.soft3202.project.model.pojo.*;

import java.util.*;

public class ServiceImpl implements Service{

    private final String INPUT_API_KEY = System.getenv("INPUT_API_KEY");

    private final String status = "online";

    public ServiceImpl() {}

    @Override
    public CollectionResults getCollectionAPI(Map<String, String> params) throws Exception {
        String parameters;
        String url = "https://data.rijksmuseum.nl/search/collection";
//        for(String key: params.keySet()) {
//            parameters = "&" + key + "=" + params.get(key);
//            url += parameters;
//        }
        System.out.println(url);
        return HttpUtil.doGet(url, CollectionResults.class);
    }

    @Override
    public CollectionDetailedObject getDetailedCollectionAPI(String objectNumber) throws Exception {
        String url = "https://data.rijksmuseum.nl/search/collection/" + objectNumber;
        System.out.println(url);
        return HttpUtil.doGet(url, CollectionDetailedObject.class);
    }

    @Override
    public String getStatus() {
        return status;
    }
}
