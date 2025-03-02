package io.github.snoozy10.softwarepatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HashingEnterprise extends Hashing {
    private final HashAlgorithmCryptoSecure implementation;

    public HashingEnterprise() {
        this.implementation = new HashAlgorithmCryptoSecure();
    }
    @Override
    public HashAlgorithm getImplementation() {
        return implementation;
    }
    @Override
    public String hashDocument(String docPath) {
        StringBuilder stringToHash = new StringBuilder();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(docPath)) {
            if (inputStream != null) {
                // Read from the input stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringToHash.append(line);
                }
            } else {
                System.err.println("File not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return implementation.calculateHashCode(String.valueOf(stringToHash));
    }


}
