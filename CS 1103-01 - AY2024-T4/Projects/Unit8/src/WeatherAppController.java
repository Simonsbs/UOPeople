import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class WeatherAppController {
    @FXML
    private TextField locationInput;
    @FXML
    private Label weatherInfoLabel;
    @FXML
    private Label historyLabel;

    private List<String> searchHistory = new ArrayList<>();

    @FXML
    private void handleGetWeather() {
        String location = locationInput.getText();
        if (location.isEmpty()) {
            showError("Location input cannot be empty.");
            return;
        }

        try {
            String apiKey = "9a6ae9b001d294e592710366fa041c78";
            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&units=metric&appid="
                    + apiKey;
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
                JSONObject main = data.getJSONObject("main");
                JSONObject wind = data.getJSONObject("wind");
                String weatherDescription = data.getJSONArray("weather").getJSONObject(0).getString("description");

                double temperature = main.getDouble("temp");
                int humidity = main.getInt("humidity");
                double windSpeed = wind.getDouble("speed");

                weatherInfoLabel.setText(String.format(
                        "Weather in %s:\nTemperature: %.2f°C\nHumidity: %d%%\nWind Speed: %.2f m/s\nConditions: %s",
                        location, temperature, humidity, windSpeed, weatherDescription));

                updateHistory(location);
                updateBackground();
            } else {
                showError("Error fetching weather data. Response code: " + responseCode);
            }
        } catch (IOException | URISyntaxException e) {
            showError("Error fetching weather data: " + e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateHistory(String location) {
        searchHistory.add(location + " at " + java.time.LocalDateTime.now());
        if (searchHistory.size() > 5) {
            searchHistory.remove(0);
        }
        historyLabel.setText("Search History:\n" + String.join("\n", searchHistory));
    }

    private void updateBackground() {
        int hour = java.time.LocalTime.now().getHour();
        if (hour >= 6 && hour < 18) {
            locationInput.getScene().getRoot().setStyle("-fx-background-color: lightyellow;");
        } else {
            locationInput.getScene().getRoot().setStyle("-fx-background-color: darkblue;");
        }
    }
}
