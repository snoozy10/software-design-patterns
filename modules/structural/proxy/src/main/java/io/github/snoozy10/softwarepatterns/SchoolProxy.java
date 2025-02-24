package io.github.snoozy10.softwarepatterns;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements Connection {
    private final Set<String> forbiddenHosts;
    private URL redirectPage;
    private Set<Integer> teacherIDs;
    private boolean authorized;
    private SchoolConnection schoolConnection;

    public SchoolProxy(Set<String> forbiddenHosts, URL redirectPage, Set<Integer> teacherIDs) {
        this.forbiddenHosts = forbiddenHosts;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
        this.authorized = false;
        this.schoolConnection = new SchoolConnection();
    }

    public void connect(URL requestedUrl) {
        if (forbiddenHosts.contains(requestedUrl.getHost()) && !(this.authorized)) {
            System.err.println("Connection to '" + requestedUrl + "' was rejected!");
            System.out.println("Redirecting to '" + this.redirectPage + "'");
            this.schoolConnection.connect(this.redirectPage);
        }
        else {
            this.schoolConnection.connect(requestedUrl);
        }
    }
    public void disconnect() {
        this.schoolConnection.disconnect();
    }
    public boolean isConnected() {
        return this.schoolConnection.isConnected();
    }
    public void login(int teacherID) {
        if (this.teacherIDs.contains(teacherID)) {
            this.authorized = true;
        }
    }
    public void logout() {
        this.authorized = false;
    }

}
