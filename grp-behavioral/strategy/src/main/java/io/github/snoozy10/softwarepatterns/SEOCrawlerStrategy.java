package io.github.snoozy10.softwarepatterns;

import java.util.Arrays;
import java.util.List;

// Concrete Strategy 3: SEO Crawler Optimization
public class SEOCrawlerStrategy implements RenderingStrategy {
    @Override
    public void optimizeAssets(ContentPage page) {
        System.out.println("Optimizing for search engine crawlers");
        page.setSimplifiedPageStructure(true);
        page.setImageAltTextRequired(true);
        page.setJavaScriptEnabled(false);
        page.setSchemaMarkup(true);
    }

    @Override
    public void prioritizeContentBlocks(ContentPage page) {
        System.out.println("Ensuring all content is visible to crawlers");

        // Make all blocks visible and disable lazy loading
        page.getBlocks().forEach(block -> {
            block.setVisible(true);
            block.setLazyLoaded(false);
        });

        // Move important content blocks to top
        List<String> importantTypes = Arrays.asList("title", "heading", "mainContent", "article");
        int orderCounter = 1;

        for (String type : importantTypes) {
            for (ContentBlock block : page.getBlocksByType(type)) {
                block.setDisplayOrder(orderCounter++);
            }
        }

        // Set remaining blocks to lower priority
        page.getBlocks().stream()
                .filter(block -> !importantTypes.contains(block.getType()))
                .forEach(block -> block.setDisplayOrder(100 + block.getDisplayOrder()));

        page.sortBlocksByDisplayOrder();
    }

    @Override
    public void cacheStrategy(ContentPage page) {
        System.out.println("Setting cache headers for crawlers");
        page.setCacheTTL(0); // No caching for crawlers to ensure fresh content
        page.setExplicitCrawlerDirectives(true);
    }

    @Override
    public void handleProgressiveLoading(ContentPage page) {
        System.out.println("Disabling progressive loading for crawlers");
        page.setLazyLoading(false);
        page.setUpfrontLoading(true);
        page.setStaticSnapshot(true);
    }
}
