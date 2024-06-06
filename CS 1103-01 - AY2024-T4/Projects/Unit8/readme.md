# Weather Information App

## Description

The Weather Information App is a JavaFX application that fetches and displays weather information for a given location. It uses the OpenWeatherMap API to get current weather data and a 5-day weather forecast. The application also maintains a search history for quick access to previously searched locations.

### Features

- Displays current weather information including temperature, humidity, wind speed, and weather conditions.
- Displays a 5-day weather forecast with temperature and weather conditions.
- Allows toggling between Celsius and Fahrenheit for temperature.
- Allows toggling between meters per second (m/s) and miles per hour (mph) for wind speed.
- Maintains a search history of the last 5 locations.

### Requirements

- Java 11 or later
- JavaFX SDK 11 or later
- org.json package

### How to Run

1. **Set up JavaFX:**

   - Download and install the JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/).
   - Set the `PATH_TO_FX` environment variable to the lib directory of the JavaFX SDK.

2. **Set up org.json:**

   - Download the `org.json` package from [Maven Repository](https://mvnrepository.com/artifact/org.json/json).
   - Add the `org.json` JAR file to the classpath.

3. **Compile the Application:**

   - Open a terminal and navigate to the directory containing the source files.
   - Run the following command to compile the application:

     ```sh
     javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:json-20210307.jar src/*.java
     ```

4. **Run the Application:**

   - Run the following command to start the application:

     ```sh
     java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:json-20210307.jar src.Main
     ```

### UI Design

- The user interface was designed using **SceneBuilder**, a visual layout tool for JavaFX applications. SceneBuilder allows for drag-and-drop design of UI components and automatically generates the corresponding FXML file.
- The `WeatherApp.fxml` file, which defines the layout and structure of the application's UI, was created using SceneBuilder. It should be located in the same directory as the compiled classes or properly referenced in the project setup.

### Screenshots

![screenshot1](screenshot1.png)
![screenshot2](screenshot2.png)
![screenshot3](screenshot3.png)
![screenshot4](screenshot4.png)

### Notes

- Ensure that the `WeatherApp.fxml` file is located in the same directory as the compiled classes or properly referenced in the project setup.
- The application requires an internet connection to fetch weather data from the OpenWeatherMap API.
- The default location is set to "tel-aviv" for the initial weather data fetch.
