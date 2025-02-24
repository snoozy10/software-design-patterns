package io.github.snoozy10.softwarepatterns;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public final class ClientBrowser {
    private static final int ADMIN_ID_1 = 934543895;
    private static final int ADMIN_ID_2 = 37984283;
    private ClientBrowser() {
    }
    public static void main(String[] args) throws MalformedURLException {
        Set<String> forbiddenHosts = Set.of("www.facebook.com", "www.instagram.com", "www.reddit.com");
        Set<Integer> adminIds = Set.of(ADMIN_ID_1, ADMIN_ID_2);
        System.out.println("The SchoolBrowser does not allow connections to the following hosts: " + forbiddenHosts);
        URL redirectPage = new URL("https://www.exzellenz.tum.de/startseite/");

        SchoolProxy schoolProxy = new SchoolProxy(forbiddenHosts, redirectPage, adminIds);

        schoolProxy.connect(new URL("https://www.google.com/search?q=pinguine"));
        schoolProxy.disconnect();

        // this page is not allowed for students
        schoolProxy.connect(new URL("https://www.instagram.com/tu.muenchen"));
        schoolProxy.disconnect();

        // authorize as teacher in order to access pages of forbidden hosts
        schoolProxy.login(ADMIN_ID_1);
        schoolProxy.connect(new URL("https://www.instagram.com/tu.muenchen"));
        schoolProxy.disconnect();
    }
}


