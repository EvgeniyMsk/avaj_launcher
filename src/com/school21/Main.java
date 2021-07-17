package com.school21;
import com.school21.Task.Aircraft;
import com.school21.Task.AircraftFactory;
import com.school21.Task.Flyable;
import com.school21.Task.WeatherTower;

public class Main {

    public static void main(String[] args) {
        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable aircraft = aircraftFactory.newAircraft("Helicopter","H1", 654, 33, 20);
        Flyable aircraft1 = aircraftFactory.newAircraft("Helicopter","H1", 654, 33, 20);
        System.out.println(aircraft);
        WeatherTower weatherTower = new WeatherTower();
        aircraft.registerTower(weatherTower);
        aircraft.updateConditions();
    }
}
