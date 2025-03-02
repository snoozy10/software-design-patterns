package io.github.snoozy10.softwarepatterns;

import java.util.Arrays;
import java.util.List;

// Concrete Strategy 1: Mobile with Low Bandwidth
public class MobileLowBandwidthStrategy implements RenderingStrategy {
    @Override
    public void optimizeAssets(ContentPage page) {
        System.out.println("Applying aggressive image compression");
        page.setImageQuality(30);
        page.setMaxImageWidth(640);
        page.setVideoAutoplay(false);
        page.setLoadHighResolutionImages(false);
    }

    @Override
    public void prioritizeContentBlocks(ContentPage page) {
        System.out.println("Prioritizing text content first");

        // Set priority order for different content types
        page.getBlocksByType("text").forEach(block -> block.setDisplayOrder(1));
        page.getBlocksByType("image").forEach(block -> {
            if (block.hasProperty("critical") && (Boolean) block.getProperty("critical")) {
                block.setDisplayOrder(2);
            } else {
                block.setDisplayOrder(4);
                block.setLazyLoaded(true);
            }
        });

        // Defer loading of non-essential blocks
        List<String> deferredTypes = Arrays.asList("comments", "relatedContent", "advertisement");
        page.getBlocks().stream()
                .filter(block -> deferredTypes.contains(block.getType()))
                .forEach(block -> {
                    block.setDisplayOrder(5);
                    block.setLazyLoaded(true);
                });

        // Sort blocks by display order
        page.sortBlocksByDisplayOrder();
    }

    @Override
    public void cacheStrategy(ContentPage page) {
        System.out.println("Setting aggressive caching for mobile devices");
        page.setCacheTTL(86400); // 24 hours caching
        page.setOfflineReading(true);
        page.setPrefetchCriticalResources(false); // Don't prefetch to save bandwidth
    }

    @Override
    public void handleProgressiveLoading(ContentPage page) {
        System.out.println("Setting up text-first progressive loading");
        page.setLazyLoading(true);
        page.setImageLoadingThreshold(300); // Only load images 300px before they're visible
        page.setLowQualityImagePlaceholders(true);
        page.setProgressiveJPEGLoading(true);
    }
}
