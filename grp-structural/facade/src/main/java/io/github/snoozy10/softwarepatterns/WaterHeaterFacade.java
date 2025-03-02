package io.github.snoozy10.softwarepatterns;

public class WaterHeaterFacade {
    private final TemperatureSensor sensor;
    private final TemperatureChanger heater;
    private final EndOfProcessIndicator indicator;

    public WaterHeaterFacade() {
        this.sensor = new TemperatureSensor();
        this.heater = new TemperatureChanger();
        this.indicator = new EndOfProcessIndicator();
    }

    public void heatWater() {
        heater.raiseTemperature(sensor.getTemperature());
        indicator.indicateEndByBeeping();
    }
}
