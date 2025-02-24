package io.github.snoozy10.softwarepatterns;
import java.net.URL;

public interface Connection {
    void connect(URL url);
    void disconnect();
    boolean isConnected();
}
