package weatherAPI.controller;

import weatherAPI.entity.Weather;
import weatherAPI.persistence.WeatherDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A servlet to display current weather conditions.
 * @author Darin Wellons
 * @version 1.0
 * @since 1.0
 */
@WebServlet(
        urlPatterns = {"/LoadWeather"}
)

public class LoadWeather extends HttpServlet {

    // Instantiate Logger.
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Properties object for new weatherDAO object.
    private Properties weatherProperties;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // New weatherDAO object.
        WeatherDAO dao = new WeatherDAO(weatherProperties);

        // New weather object with weather info loaded from dao.
        Weather weather = dao.getWeatherInfo();

        // Get the temperature.
        String temperature = weather.getWeatherObservation().getTemperature();

        // Get the location.
        String location = weather.getWeatherObservation().getStationName();

        // Get the current condition.
        String currentCondition = weather.getWeatherObservation().getWeatherCondition();
        String condition = "" ;

        if (Objects.equals(currentCondition, "n/a")) {
            condition = "Clear";
        } else {
            condition = currentCondition;
        }

        // Convert Temp from Celsius to Fahrenheit.
        double tempFar = 0.00;
        tempFar = Double.parseDouble(temperature) * ((double) 9/5) + 32;

        // Set the weather values in the request attribute.
        request.setAttribute("temperature", tempFar);
        request.setAttribute("location", location);
        request.setAttribute("condition", condition);
    }
}