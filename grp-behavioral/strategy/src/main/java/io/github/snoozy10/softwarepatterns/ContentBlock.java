package io.github.snoozy10.softwarepatterns;

import java.util.HashMap;
import java.util.Map;

// ContentBlock class
public class ContentBlock {
    private String id;
    private String type;
    private Map<String, Object> content;
    private Map<String, Object> properties;
    private int displayOrder;
    private boolean visible;
    private boolean lazyLoaded;

    public ContentBlock(String id, String type) {
        this.id = id;
        this.type = type;
        this.content = new HashMap<>();
        this.properties = new HashMap<>();
        this.displayOrder = 999; // Default to low priority
        this.visible = true;
        this.lazyLoaded = false;
    }

    // Add content item
    public void addContent(String key, Object value) {
        content.put(key, value);
    }

    // Check if property exists
    public boolean hasProperty(String key) {
        return properties.containsKey(key);
    }

    // Get property value
    public Object getProperty(String key) {
        return properties.get(key);
    }

    // Set property
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isLazyLoaded() {
        return lazyLoaded;
    }

    public void setLazyLoaded(boolean lazyLoaded) {
        this.lazyLoaded = lazyLoaded;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "ContentBlock{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", displayOrder=" + displayOrder +
                ", visible=" + visible +
                ", lazyLoaded=" + lazyLoaded +
                '}';
    }
}
