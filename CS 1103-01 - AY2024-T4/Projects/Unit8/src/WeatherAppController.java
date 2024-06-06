import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONObject;
import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;

/**
 * Controller class for the WeatherApp. Handles user interactions and data
 * fetching. Updates the UI based on the fetched data. Implements the logic for
 * the WeatherApp. Uses the OpenWeatherMap API to fetch weather data.
 */
public class WeatherAppController {
    @FXML
    private TextField locationSelection;
    @FXML
    private Label weatherInfoLabel;
    @FXML
    private Label historyLabel;
    @FXML
    private ImageView currentWeatherImageView;
    @FXML
    private HBox forecastHBox;
    @FXML
    private StackPane forecastContainer;
    @FXML
    private ListView<String> historyListView;
    @FXML
    private ToggleButton windUnitToggle;
    @FXML
    private ToggleButton tempUnitToggle;

    private ObservableList<String> searchHistory = FXCollections.observableArrayList();
    private boolean isCelsius = true;
    private boolean isMetersPerSecond = true;
    private ZoneId locationZoneId;
    private JSONObject currentWeatherData;
    private JSONArray forecastData;

    private static final String API_KEY = "9a6ae9b001d294e592710366fa041c78";

    /**
     * Handles the "Get Weather" button click. Fetches weather data for the entered
     * location. Shows an error message if the location is empty.
     */
    @FXML
    private void handleGetWeather() {
        String location = locationSelection.getText();
        if (location.isEmpty()) {
            showError("Location input cannot be empty.");
            return;
        }
        fetchWeatherData(location);
    }

    /**
     * Fetches weather data from the OpenWeatherMap API for the specified location.
     * Updates the current weather display, weekly forecast display, and search
     * history.
     *
     * @param location the location for which to fetch weather data
     */
    private void fetchWeatherData(String location) {
        try {
            String units = isCelsius ? "metric" : "imperial";
            String currentWeatherUrl;
            String forecastUrl;

            if (location.contains(",")) {
                String[] coords = location.split(",");
                String latitude = coords[0].trim();
                String longitude = coords[1].trim();
                currentWeatherUrl = buildWeatherUrlForCoordinates(latitude, longitude, units, "weather");
                forecastUrl = buildWeatherUrlForCoordinates(latitude, longitude, units, "forecast");
            } else {
                currentWeatherUrl = buildWeatherUrlForCity(location, units, "weather");
                forecastUrl = buildWeatherUrlForCity(location, units, "forecast");
            }

            fetchCurrentWeather(currentWeatherUrl, location);
            fetchWeeklyForecast(forecastUrl);

            updateHistory(location);
            updateBackground();
        } catch (IOException | URISyntaxException e) {
            showError("Error fetching weather data: " + e.getMessage());
        }
    }

    /**
     * Builds the URL for the weather API request using city name.
     *
     * @param location the location for which to fetch weather data
     * @param units    the units for temperature (metric or imperial)
     * @param endpoint the API endpoint (weather or forecast)
     * @return the complete URL for the API request
     * @throws IOException if an encoding error occurs
     */
    private String buildWeatherUrlForCity(String location, String units, String endpoint) throws IOException {
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8.toString());
        return String.format("http://api.openweathermap.org/data/2.5/%s?q=%s&units=%s&appid=%s", endpoint,
                encodedLocation, units, API_KEY);
    }

    /**
     * Builds the URL for the weather API request using coordinates.
     *
     * @param latitude  the latitude of the location
     * @param longitude the longitude of the location
     * @param units     the units for temperature (metric or imperial)
     * @param endpoint  the API endpoint (weather or forecast)
     * @return the complete URL for the API request
     */
    private String buildWeatherUrlForCoordinates(String latitude, String longitude, String units, String endpoint) {
        return String.format("http://api.openweathermap.org/data/2.5/%s?lat=%s&lon=%s&units=%s&appid=%s", endpoint,
                latitude, longitude, units, API_KEY);
    }

    /**
     * Fetches the current weather data from the API and updates the display.
     *
     * @param urlString the URL for the API request
     * @param location  the location for which to fetch weather data
     * @throws IOException, URISyntaxException if an error occurs during the API
     *                      request
     */
    private void fetchCurrentWeather(String urlString, String location) throws IOException, URISyntaxException {
        URL url = new URI(urlString).toURL();
        try (Scanner scanner = new Scanner(url.openStream())) {
            String inline = scanner.useDelimiter("\\A").next();
            currentWeatherData = new JSONObject(inline);
            updateCurrentWeatherDisplay(location);
        }
    }

    /**
     * Fetches the weekly forecast data from the API and updates the display.
     *
     * @param urlString the URL for the API request
     * @throws IOException, URISyntaxException if an error occurs during the API
     *                      request
     */
    private void fetchWeeklyForecast(String urlString) throws IOException, URISyntaxException {
        URL url = new URI(urlString).toURL();
        try (Scanner scanner = new Scanner(url.openStream())) {
            String inline = scanner.useDelimiter("\\A").next();
            JSONObject data = new JSONObject(inline);
            forecastData = data.getJSONArray("list");
            updateWeeklyForecastDisplay();
        }
    }

    /**
     * Updates the current weather display with the fetched data.
     *
     * @param location the location for which to display weather data
     */
    private void updateCurrentWeatherDisplay(String location) {
        if (currentWeatherData == null)
            return;

        JSONObject main = currentWeatherData.getJSONObject("main");
        JSONObject wind = currentWeatherData.getJSONObject("wind");
        String weatherDescription = currentWeatherData.getJSONArray("weather").getJSONObject(0)
                .getString("description");
        String iconCode = currentWeatherData.getJSONArray("weather").getJSONObject(0).getString("icon");

        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");
        double windSpeed = wind.getDouble("speed");
        int timezoneOffset = currentWeatherData.getInt("timezone");

        locationZoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofTotalSeconds(timezoneOffset));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), locationZoneId);

        String unit = isCelsius ? "°C" : "°F";
        String speedUnit = isMetersPerSecond ? "m/s" : "mph";

        Platform.runLater(() -> {
            weatherInfoLabel.setText(String.format(
                    "Weather in %s:\nLocal Time: %s\nTemperature: %.2f%s\nHumidity: %d%%\nWind Speed: %.2f %s\nConditions: %s",
                    location, localDateTime.format(DateTimeFormatter.ofPattern("HH:mm")), temperature, unit, humidity,
                    windSpeed, speedUnit, weatherDescription));

            setWeatherImage(iconCode);
        });
    }

    /**
     * Updates the weekly forecast display with the fetched data.
     */
    private void updateWeeklyForecastDisplay() {
        if (forecastData == null)
            return;

        forecastHBox.getChildren().clear();
        String unit = isCelsius ? "°C" : "°F";

        for (int i = 0; i < forecastData.length(); i += 8) { // Get data every 24 hours (8 * 3-hour intervals)
            JSONObject dayData = forecastData.getJSONObject(i);
            String date = dayData.getString("dt_txt").split(" ")[0];
            JSONObject main = dayData.getJSONObject("main");
            String weatherDescription = dayData.getJSONArray("weather").getJSONObject(0).getString("description");
            String iconCode = dayData.getJSONArray("weather").getJSONObject(0).getString("icon");

            double temperature = main.getDouble("temp");

            BorderPane forecastItem = new BorderPane();
            forecastItem.setStyle("-fx-border-color: black; -fx-padding: 10;");

            VBox forecastDetails = new VBox(5);
            forecastDetails.setAlignment(Pos.CENTER);

            Label dateLabel = new Label(date);
            Label tempLabel = new Label(String.format("%.2f%s", temperature, unit));
            Label descriptionLabel = new Label(weatherDescription);
            ImageView iconImageView = new ImageView(
                    new Image("http://openweathermap.org/img/wn/" + iconCode + "@2x.png"));

            forecastDetails.getChildren().addAll(dateLabel, iconImageView, tempLabel, descriptionLabel);
            forecastItem.setCenter(forecastDetails);
            forecastHBox.getChildren().add(forecastItem);
        }
    }

    /**
     * Sets the weather image based on the icon code from the API.
     *
     * @param iconCode the icon code for the weather condition
     */
    private void setWeatherImage(String iconCode) {
        String imageUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";
        Image image = new Image(imageUrl);
        currentWeatherImageView.setImage(image);
    }

    /**
     * Shows an error message in an alert dialog.
     *
     * @param message the error message to display
     */
    private void showError(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    /**
     * Updates the search history with the specified location.
     *
     * @param location the location to add to the search history
     */
    private void updateHistory(String location) {
        String historyEntry = location + " at "
                + LocalDateTime.now(locationZoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        searchHistory.add(historyEntry);
        if (searchHistory.size() > 5) {
            searchHistory.remove(0);
        }
        historyListView.setItems(searchHistory);
    }

    /**
     * Updates the background color based on the time of day.
     */
    private void updateBackground() {
        int hour = LocalDateTime.now(locationZoneId).getHour();
        Platform.runLater(() -> {
            if (hour >= 6 && hour < 18) {
                locationSelection.getScene().getRoot().setStyle("-fx-background-color: lightyellow;");
            } else {
                locationSelection.getScene().getRoot().setStyle("-fx-background-color: lightblue;");
            }
        });
    }

    /**
     * Fetches the initial location data based on the user's IP address.
     * Automatically fetches the weather data for the initial location.
     * uses the Geoapify API to get the location data.
     */
    private void fetchInitialLocation() {
        try {
            String geoApiUrl = "https://api.geoapify.com/v1/ipinfo?&apiKey=fa82472c9a884c9eaa2e7c4aeaf4833a";
            URL url = new URI(geoApiUrl).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();

                JSONObject data = new JSONObject(inline);
                JSONObject location = data.getJSONObject("location");
                double latitude = location.getDouble("latitude");
                double longitude = location.getDouble("longitude");

                locationSelection.setText(latitude + "," + longitude);
                handleGetWeather();
            } else {
                showError("Error fetching initial location data. Response code: " + responseCode);
            }
        } catch (IOException | URISyntaxException e) {
            showError("Error fetching initial location data: " + e.getMessage());
        }
    }

    /**
     * Initializes the controller. Sets up event handlers and initial state.
     */
    @FXML
    private void initialize() {
        tempUnitToggle.setOnAction(e -> {
            isCelsius = !tempUnitToggle.isSelected();
            tempUnitToggle.setText(isCelsius ? "°C" : "°F");
            updateCurrentWeatherDisplay(locationSelection.getText());
            updateWeeklyForecastDisplay();
        });
        tempUnitToggle.setText(isCelsius ? "°C" : "°F");

        windUnitToggle.setOnAction(e -> {
            isMetersPerSecond = !windUnitToggle.isSelected();
            windUnitToggle.setText(isMetersPerSecond ? "m/s" : "mph");
            updateCurrentWeatherDisplay(locationSelection.getText());
        });
        windUnitToggle.setText(isMetersPerSecond ? "m/s" : "mph");

        historyListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                locationSelection.setText(newVal.split(" at ")[0]);
            }
        });

        Platform.runLater(() -> {
            fetchInitialLocation();
        });
    }
}
