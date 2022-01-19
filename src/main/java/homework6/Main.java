package homework6;

import com.google.gson.Gson;
import homework7.models.ForecastResponseModel;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {
    public static void main(String[] args) {
        String apiKey = "ckTA0UrX8K43zrl560geTMTglAcB0ChG";
        String language = "ru-Ru";
        String cityCode = "295212";
        String baseUrl = "http://dataservice.accuweather.com";

        try {
            OkHttpClient client = new OkHttpClient();

            HttpUrl httpUrl = HttpUrl.parse(baseUrl)
                    .newBuilder()
                    .addPathSegment("forecasts")
                    .addPathSegment("v1")
                    .addPathSegment("daily")
                    .addPathSegment("1day")
                    .addPathSegment(cityCode)
                    .addQueryParameter("apikey", apiKey)
                    .addQueryParameter("language", language)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();

            Response response = client.newCall(request).execute();

            String responseStr = response.body().string();
            ForecastResponseModel kek = new Gson().fromJson(responseStr, ForecastResponseModel.class);
            System.out.println(response.body().string());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
