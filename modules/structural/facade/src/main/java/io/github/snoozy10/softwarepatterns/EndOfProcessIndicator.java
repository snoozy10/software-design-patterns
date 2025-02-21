package io.github.snoozy10.softwarepatterns;

public class EndOfProcessIndicator {
    public EndOfProcessIndicator() {}
    public void indicateEndByBeeping() {
        System.out.println("Subsystem at work: indicating end through BEEP!");
    }
}
