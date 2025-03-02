package io.github.snoozy10.softwarepatterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Concrete Strategy 2: Desktop High Performance
public class DesktopHighPerformanceStrategy implements RenderingStrategy {
    @Override
    public void optimizeAssets(ContentPage page) {
        System.out.println("Loading high-quality assets for desktop");
        page.setImageQuality(85);
        page.setMaxImageWidth(1920);
        page.setVideoAutoplay(true);
        page.setLoadHighResolutionImages(true);
    }

    @Override
    public void prioritizeContentBlocks(ContentPage page) {
        System.out.println("Preparing rich content experience");

        // Set priority order for different content blocks
        Map<String, Integer> typeOrder = Map.of(
                "hero", 1,
                "navigation", 2,
                "mainContent", 3,
                "sidebar", 4,
                "footer", 5
        );

        // Set display order based on block type
        page.getBlocks().forEach(block -> {
            Integer order = typeOrder.get(block.getType());
            if (order != null) {
                block.setDisplayOrder(order);
            } else {
                block.setDisplayOrder(10); // Default for unspecified types
            }
        });

        // Preload certain content types
        List<String> preloadTypes = Arrays.asList("relatedContent", "comments");
        page.getBlocks().stream()
                .filter(block -> preloadTypes.contains(block.getType()))
                .forEach(block -> block.setProperty("preload", true));

        page.setAnimationsEnabled(true);
        page.sortBlocksByDisplayOrder();
    }

    @Override
    public void cacheStrategy(ContentPage page) {
        System.out.println("Setting moderate caching for desktop");
        page.setCacheTTL(3600); // 1 hour caching
        page.setPrefetchCriticalResources(true);
        page.setPrefetchLinkedPages(true);
    }

    @Override
    public void handleProgressiveLoading(ContentPage page) {
        System.out.println("Setting up high-performance progressive loading");
        page.setParallelResourceLoading(true);
        page.setImageLoadingThreshold(1000); // Start loading images 1000px before they're visible
        page.setHighQualityPreview(true);

        Map<String, String> resourcePriorities = new HashMap<>();
        resourcePriorities.put("CSS", "highest");
        resourcePriorities.put("criticalJS", "high");
        resourcePriorities.put("images", "medium");
        resourcePriorities.put("fonts", "high");
        page.setResourcePriorities(resourcePriorities);
    }
}
