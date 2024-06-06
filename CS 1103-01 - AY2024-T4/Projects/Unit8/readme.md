# Weather Information Application

**Author**: [Simon B.Stirling](https://bestdev.co.il)

## Overview

This Weather Information Application provides current weather conditions and a weekly forecast for any specified location. The application uses the OpenWeatherMap API to fetch weather data and displays the information in a user-friendly interface.

## Features

- Fetch current weather data and weekly forecast for any city or geographic coordinates.
- Display weather conditions, temperature, humidity, wind speed, and weather icons.
- Maintain a search history of the last 5 searched locations.
- Toggle between Celsius and Fahrenheit for temperature units.
- Toggle between meters per second and miles per hour for wind speed units.
- Automatically fetch weather data for the user's initial location based on their IP address using the Geoapify API.

## Requirements

- Java 11 or higher
- JavaFX SDK
- `org.json` package for JSON parsing
- Internet connection

## Setup

1. Download and install Java from [https://www.oracle.com/java/technologies/javase-jdk11-downloads.html](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Download and install JavaFX from [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/).
3. Add the JavaFX SDK to your project's library path.
4. Add the `org.json` package to your project's library path. You can download it from [https://mvnrepository.com/artifact/org.json/json](https://mvnrepository.com/artifact/org.json/json).

## Running the Application

1. Clone or download the project.
2. Ensure that the JavaFX SDK and `org.json` package are correctly added to your project's library path.
3. Compile and run the `Main.java` file.

## Usage

1. **Enter a location**: Type a city name (e.g., "London") or geographic coordinates (e.g., "51.5074,-0.1278") into the text field and click the "Get Weather" button.
2. **Toggle units**: Use the toggle buttons to switch between Celsius/Fahrenheit for temperature and meters per second/miles per hour for wind speed.
3. **Search history**: View your last 5 searched locations in the search history list. Click on a location to fetch the weather data for that location again.
4. **Automatic location**: On startup, the application automatically fetches the weather data for your initial location based on your IP address using the Geoapify API.

## Notes

- The application uses the OpenWeatherMap API for fetching weather data. You need an API key to use this service. The default API key provided in the code is for demonstration purposes. Replace it with your own API key for production use.
- The application uses the Geoapify API to fetch the user's initial location based on their IP address. This feature helps in providing an automatic weather update for the user's current location without requiring manual input.

## Credits

- The application interface was built using SceneBuilder.
- Weather data provided by [OpenWeatherMap](https://openweathermap.org/).
- IP-based geolocation provided by [Geoapify](https://www.geoapify.com/).

## Screenshots

### Screenshot 1

![Screenshot 1](screenshot1.png)

### Screenshot 2

![Screenshot 2](screenshot2.png)

### Screenshot 3

![Screenshot 3](screenshot3.png)

### Screenshot 4

![Screenshot 4](screenshot4.png)
