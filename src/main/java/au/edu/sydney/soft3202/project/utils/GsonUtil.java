package au.edu.sydney.soft3202.project.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class GsonUtil {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj) {
        if (obj == null) {
            return "";
        }
        return gson.toJson(obj);
    }

    public static <T> List<T> convertList(String json, Class<T> cls) {
        if (null == json || json.isBlank()) {
            return new ArrayList<T>();
        }
        Type type = new TypeToken<List<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjs = gson.fromJson(json, type);
        List<T> listOfT = new ArrayList<>();
        for (JsonObject jsonObj : jsonObjs) {
            listOfT.add(convertObj(jsonObj.toString(), cls));
        }
        return listOfT;
    }

    public static <T> T convertObj(String json, Class<T> cls) {
        if (null == json || json.isBlank()) {
            return null;
        }
        return gson.fromJson(json, cls);
    }
}
