package au.edu.sydney.soft3202.project.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.*;

public class HttpUtil {

    private static String execute(HttpRequest request) throws Exception {
        HttpClient client = getHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return getRes(response);
    }

    private static HttpClient getHttpClient() {
        return HttpClient.newBuilder()
                .build();
    }

    private static String getRes(HttpResponse<String> response) {
        System.out.println("status:" + response.statusCode());
        int statusCode = response.statusCode();
        String body = response.body();
        if (statusCode >= 200 && statusCode < 300) {
            return body;
        }
        throw new RuntimeException(body);
    }

    public static String doGet(String url) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        return execute(request);
    }

    public static <T> T doGet(String url, Class<T> tClass) throws Exception {
        String responseBody = doGet(url);
        return GsonUtil.convertObj(responseBody, tClass);
    }

    public static <T> List<T> doGetList(String url, String key, Class<T> tClass) throws Exception {
        String responseBody = doGet(url);
        Map<String, Object> map = GsonUtil.convertObj(responseBody, Map.class);
        return GsonUtil.convertList(GsonUtil.toJson(map.get(key)), tClass);
    }

}
