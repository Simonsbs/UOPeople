import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
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

public class WeatherAppController {
    @FXML
    private TextField locationInput;
    @FXML
    private Label weatherInfoLabel;
    @FXML
    private Label historyLabel;
    @FXML
    private ImageView weatherImageView;
    @FXML
    private HBox forecastHBox;
    @FXML
    private StackPane forecastContainer;
    @FXML
    private ListView<String> historyListView;
    @FXML
    private ToggleButton unitToggle;
    @FXML
    private ToggleButton windToggle;

    private ObservableList<String> searchHistory = FXCollections.observableArrayList();
    private boolean isCelsius = true;
    private boolean isMetersPerSecond = true;
    private ZoneId locationZoneId;
    private JSONObject currentWeatherData;
    private JSONArray forecastData;

    @FXML
    private void handleGetWeather() {
        String location = locationInput.getText();
        if (location.isEmpty()) {
            showError("Location input cannot be empty.");
            return;
        }

        try {
            String apiKey = "9a6ae9b001d294e592710366fa041c78";
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8.toString());
            String units = isCelsius ? "metric" : "imperial";
            String currentWeatherUrlString = "http://api.openweathermap.org/data/2.5/weather?q=" + encodedLocation
                    + "&units=" + units + "&appid=" + apiKey;
            String forecastUrlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + encodedLocation
                    + "&units=" + units + "&appid=" + apiKey;

            fetchCurrentWeather(currentWeatherUrlString, location);
            fetchWeeklyForecast(forecastUrlString);

            updateHistory(location);
            updateBackground();
        } catch (IOException | URISyntaxException e) {
            showError("Error fetching weather data: " + e.getMessage());
        }
    }

    private void fetchCurrentWeather(String urlString, String location) throws IOException, URISyntaxException {
        URL url = new URI(urlString).toURL();
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

            currentWeatherData = new JSONObject(inline);
            updateCurrentWeatherDisplay(location);
        } else {
            showError("Error fetching current weather data. Response code: " + responseCode);
        }
    }

    private void fetchWeeklyForecast(String urlString) throws IOException, URISyntaxException {
        URL url = new URI(urlString).toURL();
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
            forecastData = data.getJSONArray("list");
            updateWeeklyForecastDisplay();
        } else {
            showError("Error fetching weekly forecast data. Response code: " + responseCode);
        }
    }

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

        weatherInfoLabel.setText(String.format(
                "Weather in %s:\nLocal Time: %s\nTemperature: %.2f%s\nHumidity: %d%%\nWind Speed: %.2f %s\nConditions: %s",
                location, localDateTime.format(DateTimeFormatter.ofPattern("HH:mm")), temperature, unit, humidity,
                windSpeed, speedUnit, weatherDescription));

        setWeatherImage(iconCode);
    }

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

    private void setWeatherImage(String iconCode) {
        String imageUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";
        Image image = new Image(imageUrl);
        weatherImageView.setImage(image);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateHistory(String location) {
        String historyEntry = location + " at "
                + LocalDateTime.now(locationZoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        searchHistory.add(historyEntry);
        if (searchHistory.size() > 5) {
            searchHistory.remove(0);
        }
        historyListView.setItems(searchHistory);
    }

    private void updateBackground() {
        int hour = LocalDateTime.now(locationZoneId).getHour();
        if (hour >= 6 && hour < 18) {
            locationInput.getScene().getRoot().setStyle("-fx-background-color: lightyellow;");
        } else {
            locationInput.getScene().getRoot().setStyle("-fx-background-color: lightblue;");
        }
    }

    @FXML
    private void initialize() {
        unitToggle.setOnAction(e -> {
            isCelsius = !unitToggle.isSelected();
            unitToggle.setText(isCelsius ? "°C" : "°F");
            updateCurrentWeatherDisplay(locationInput.getText());
            updateWeeklyForecastDisplay();
        });
        unitToggle.setText(isCelsius ? "°C" : "°F");

        windToggle.setOnAction(e -> {
            isMetersPerSecond = !windToggle.isSelected();
            windToggle.setText(isMetersPerSecond ? "m/s" : "mph");
            updateCurrentWeatherDisplay(locationInput.getText());
        });
        windToggle.setText(isMetersPerSecond ? "m/s" : "mph");

        historyListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                locationInput.setText(newVal.split(" at ")[0]);
            }
        });
    }
}
