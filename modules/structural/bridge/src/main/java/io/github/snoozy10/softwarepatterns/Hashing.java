package io.github.snoozy10.softwarepatterns;

public abstract class Hashing {
    private HashAlgorithm implementation;
    public abstract String hashDocument(String input);
    public abstract HashAlgorithm getImplementation();
}

