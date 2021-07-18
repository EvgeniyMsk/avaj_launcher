package com.school21;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        String[] messages = {
                this + ": Let's enjoy the good weather and take some pics.",
                this + ": Damn you rain! You messed up my baloon.",
                this + ": Fucking fog.",
                this + ": It's snowing. We're gonna crash."
        };
        switch (weather) {
            case "SUN" : {
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4);
                System.out.println(messages[0]);
                break;
            }
            case "RAIN" : {
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5);
                System.out.println(messages[1]);
                break;
            }
            case "FOG" : {
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3);
                System.out.println(messages[2]);
                break;
            }
            case "SNOW" : {
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15);
                System.out.println(messages[3]);
                break;
            }
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println(this + " landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }
}
