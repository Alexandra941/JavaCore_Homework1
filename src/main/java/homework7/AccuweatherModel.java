package homework7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework7.entity.Weather;
import homework7.models.CityResponseModel;
import homework7.models.DailyForecasts;
import homework7.models.ForecastResponseModel;
import homework8.IWeatherRepository;
import homework8.WeatherRepositoryImpl;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "ckTA0UrX8K43zrl560geTMTglAcB0ChG";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String LANGUAGE = "language";
    private static final String RU_LANGUAGE = "ru-RU";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String METRIC = "metric";

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    private IWeatherRepository weatherRepository = new WeatherRepositoryImpl();

    public void getWeather(String selectedCity, Period period) throws IOException {
        StringBuilder sb;
        ForecastResponseModel forecast;
        switch (period) {
            case NOW:
                forecast = getForrecast(selectedCity, FIVE_DAY);

                sb = new StringBuilder(String.format("Погода в городе %s \n", selectedCity))
                        .append(String.format("%s\n", forecast.getHeadline().getText()))
                        .append(String.format("Температура от %s C", forecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue()))
                        .append(String.format(", до %s C \n",forecast.getDailyForecasts().get(0).getTemperature().getMaximum().getValue()));

                try {
                    weatherRepository.saveWeather(new Weather(selectedCity,
                            formatter.format(forecast.getDailyForecasts().get(0).getDate()),
                            forecast.getHeadline().getText(),
                            forecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println(sb);
                break;
            case FIVE_DAYS:
                forecast = getForrecast(selectedCity, FIVE_DAY);

                List<Weather> weatherList = new ArrayList<>();
                sb = new StringBuilder();
                for (DailyForecasts dailyForecast : forecast.getDailyForecasts()) {
                    sb.append(String.format("В городе %s ", selectedCity))
                        .append(String.format("на дату %s ", formatter.format(dailyForecast.getDate())))
                        .append(String.format("ожидается %s,", dailyForecast.getDay().getIconPhrase().toLowerCase()))
                        .append(String.format(" температура от %s C", dailyForecast.getTemperature().getMinimum().getValue()))
                        .append(String.format(", до %s C \n", dailyForecast.getTemperature().getMaximum().getValue()));

                    weatherList.add(new Weather(selectedCity,
                            formatter.format(forecast.getDailyForecasts().get(0).getDate()),
                            dailyForecast.getDay().getIconPhrase().toLowerCase(),
                            dailyForecast.getTemperature().getMinimum().getValue()));
                }

                try {
                    weatherRepository.saveWeathers(weatherList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println(sb);
                break;
        }
    }

    public void getSavedToDBWeather() {
        List<Weather> weatherList = null;
        try {
            weatherList = weatherRepository.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (weatherList != null && !weatherList.isEmpty()) {
            for (Weather weather : weatherList) {
                System.out.println(weather.info());
            }
        }
        else {
            System.out.println("В базе данных отсутсует информация о погоде.");
        }
    }

    public void getSavedToDBWeather(String selectedCity) {
        List<Weather> weatherList = null;
        try {
            weatherList = weatherRepository.getAllByCity(selectedCity);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (weatherList != null && !weatherList.isEmpty()) {
            for (Weather weather : weatherList) {
                System.out.println(weather.info());
            }
        }
        else {
            System.out.println("В базе данных отсутсует информация о погоде.");
        }
    }

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .addQueryParameter(LANGUAGE, RU_LANGUAGE)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        CityResponseModel[] cities = new Gson().fromJson(responseString, new TypeToken<CityResponseModel[]>(){}.getType());
        return cities[0].getKey();
    }

    private ForecastResponseModel getForrecast(String selectedCity, String period) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(period)
                .addPathSegment(detectCityKey(selectedCity))
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(LANGUAGE, RU_LANGUAGE)
                .addQueryParameter(METRIC, "true")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String strResponse = response.body().string();
        return new Gson().fromJson(strResponse, ForecastResponseModel.class);
    }
}