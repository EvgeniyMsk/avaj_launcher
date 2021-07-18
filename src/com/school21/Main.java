package com.school21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/Users/qsymond/Desktop/avaj-launcher/scenario.txt"));
        int iterations = Integer.parseInt(scanner.nextLine());
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            aircraftFactory.newAircraft(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4])).registerTower(weatherTower);
        }
        for (int i = 0; i < iterations; i++)
            weatherTower.changeWeather();
    }
}
