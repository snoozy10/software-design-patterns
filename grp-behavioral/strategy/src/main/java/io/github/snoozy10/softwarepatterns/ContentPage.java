package io.github.snoozy10.softwarepatterns;

import java.util.*;
import java.util.stream.Collectors;

// Context class - ContentPage
public class ContentPage {
    private String title;
    private List<ContentBlock> blocks;
    private Map<String, Object> metadata;
    private Map<String, Object> renderingOptions;

    public ContentPage(String title) {
        this.title = title;
        this.blocks = new ArrayList<>();
        this.metadata = new HashMap<>();
        this.renderingOptions = new HashMap<>();
    }

    // Add a content block to the page
    public void addBlock(ContentBlock block) {
        this.blocks.add(block);
    }

    // Get all blocks
    public List<ContentBlock> getBlocks() {
        return blocks;
    }

    // Get blocks by type
    public List<ContentBlock> getBlocksByType(String type) {
        return blocks.stream()
                .filter(block -> block.getType().equals(type))
                .collect(Collectors.toList());
    }

    // Get block by ID
    public ContentBlock getBlockById(String id) {
        return blocks.stream()
                .filter(block -> block.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Sort blocks by display order
    public void sortBlocksByDisplayOrder() {
        Collections.sort(blocks, Comparator.comparingInt(ContentBlock::getDisplayOrder));
    }

    // Add metadata
    public void addMetadata(String key, Object value) {
        metadata.put(key, value);
    }

    // Get metadata
    public Object getMetadata(String key) {
        return metadata.get(key);
    }

    // Rendering options setters
    public void setImageQuality(int quality) {
        renderingOptions.put("imageQuality", quality);
    }

    public void setMaxImageWidth(int width) {
        renderingOptions.put("maxImageWidth", width);
    }

    public void setVideoAutoplay(boolean enabled) {
        renderingOptions.put("videoAutoplay", enabled);
    }

    public void setLoadHighResolutionImages(boolean enabled) {
        renderingOptions.put("highResImages", enabled);
    }

    public void setCacheTTL(int seconds) {
        renderingOptions.put("cacheTTL", seconds);
    }

    public void setOfflineReading(boolean enabled) {
        renderingOptions.put("offlineReading", enabled);
    }

    public void setPrefetchCriticalResources(boolean enabled) {
        renderingOptions.put("prefetchCritical", enabled);
    }

    public void setLazyLoading(boolean enabled) {
        renderingOptions.put("lazyLoading", enabled);
    }

    public void setImageLoadingThreshold(int pixels) {
        renderingOptions.put("imageLoadingThreshold", pixels);
    }

    public void setLowQualityImagePlaceholders(boolean enabled) {
        renderingOptions.put("lqipEnabled", enabled);
    }

    public void setProgressiveJPEGLoading(boolean enabled) {
        renderingOptions.put("progressiveJPEG", enabled);
    }

    public void setAnimationsEnabled(boolean enabled) {
        renderingOptions.put("animations", enabled);
    }

    public void setPrefetchLinkedPages(boolean enabled) {
        renderingOptions.put("prefetchLinks", enabled);
    }

    public void setParallelResourceLoading(boolean enabled) {
        renderingOptions.put("parallelLoading", enabled);
    }

    public void setHighQualityPreview(boolean enabled) {
        renderingOptions.put("highQualityPreview", enabled);
    }

    public void setResourcePriorities(Map<String, String> priorities) {
        renderingOptions.put("resourcePriorities", priorities);
    }

    public void setSimplifiedPageStructure(boolean enabled) {
        renderingOptions.put("simplifiedStructure", enabled);
    }

    public void setImageAltTextRequired(boolean required) {
        renderingOptions.put("requireAltText", required);
    }

    public void setJavaScriptEnabled(boolean enabled) {
        renderingOptions.put("javascriptEnabled", enabled);
    }

    public void setSchemaMarkup(boolean enabled) {
        renderingOptions.put("schemaMarkup", enabled);
    }

    public void setExplicitCrawlerDirectives(boolean enabled) {
        renderingOptions.put("crawlerDirectives", enabled);
    }

    public void setUpfrontLoading(boolean enabled) {
        renderingOptions.put("upfrontLoading", enabled);
    }

    public void setStaticSnapshot(boolean enabled) {
        renderingOptions.put("staticSnapshot", enabled);
    }

    public void setMinContrastRatio(double ratio) {
        renderingOptions.put("minContrastRatio", ratio);
    }

    public void setAccessibleFonts(boolean enabled) {
        renderingOptions.put("accessibleFonts", enabled);
    }

    public void setDescriptiveMediaCaptions(boolean enabled) {
        renderingOptions.put("mediaCaptions", enabled);
    }

    public void setLogicalReadingOrder(boolean enabled) {
        renderingOptions.put("logicalReadingOrder", enabled);
    }

    public void setKeyboardNavigability(boolean enabled) {
        renderingOptions.put("keyboardNavigation", enabled);
    }

    public void setCacheUserAccessibilityPreferences(boolean enabled) {
        renderingOptions.put("cacheAccessibilityPrefs", enabled);
    }

    public void setPersistAccessibilitySettings(boolean enabled) {
        renderingOptions.put("persistAccessibility", enabled);
    }

    public void setAnnounceContentChanges(boolean enabled) {
        renderingOptions.put("announceChanges", enabled);
    }

    public void setMaintainFocusOnDynamicLoading(boolean enabled) {
        renderingOptions.put("maintainFocus", enabled);
    }

    public void setLoadingIndicators(boolean enabled) {
        renderingOptions.put("loadingIndicators", enabled);
    }

    public void setPageStability(boolean enabled) {
        renderingOptions.put("pageStability", enabled);
    }

    // Rendering option getters
    public Object getRenderingOption(String key) {
        return renderingOptions.get(key);
    }

    // Render the page according to applied strategies
    public void render() {
        System.out.println("Rendering page: " + title);
        System.out.println("Applied rendering options:");

        for (Map.Entry<String, Object> option : renderingOptions.entrySet()) {
            System.out.println("  - " + option.getKey() + ": " + option.getValue());
        }

        System.out.println("Content blocks in display order:");
        for (ContentBlock block : blocks) {
            System.out.println("  - " + block);
        }

        System.out.println("Page rendered successfully!\n");
    }

    // Getters and setters for basic properties
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Map<String, Object> getRenderingOptions() {
        return renderingOptions;
    }
}
