package io.github.snoozy10.softwarepatterns;

import java.util.Arrays;
import java.util.Map;

// Client code demonstration
public final class StrategyPatternDemo {
    public static void main(String[] args) {
        // Create a content delivery service
        ContentDeliveryService deliveryService = new ContentDeliveryService();

        // Create sample content blocks for demonstration
        createAndRunDemonstration(deliveryService);
    }

    private static void createAndRunDemonstration(ContentDeliveryService deliveryService) {
        // Create content page with blocks
        ContentPage page = createSamplePage();

        // Scenario 1: Mobile user with low bandwidth
        System.out.println("=== SCENARIO 1: MOBILE USER WITH LOW BANDWIDTH ===");
        HttpRequest mobileRequest = new HttpRequest();
        mobileRequest.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X)");
        mobileRequest.addHeader("Downlink", "0.5"); // Simulating low bandwidth

        RenderingStrategy mobileStrategy = deliveryService.determineOptimalStrategy(mobileRequest);
        deliveryService.setRenderingStrategy(mobileStrategy);
        deliveryService.renderContent(page, mobileRequest);

        // Reset page for next scenario
        page = createSamplePage();

        // Scenario 2: Desktop user with high bandwidth
        System.out.println("=== SCENARIO 2: DESKTOP USER WITH HIGH BANDWIDTH ===");
        HttpRequest desktopRequest = new HttpRequest();
        desktopRequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        desktopRequest.addHeader("Downlink", "10"); // Simulating high bandwidth

        RenderingStrategy desktopStrategy = deliveryService.determineOptimalStrategy(desktopRequest);
        deliveryService.setRenderingStrategy(desktopStrategy);
        deliveryService.renderContent(page, desktopRequest);

        // Reset page for next scenario
        page = createSamplePage();

        // Scenario 3: Search engine crawler
        System.out.println("=== SCENARIO 3: SEARCH ENGINE CRAWLER ===");
        HttpRequest crawlerRequest = new HttpRequest();
        crawlerRequest.addHeader("User-Agent", "Googlebot/2.1 (+http://www.google.com/bot.html)");

        RenderingStrategy crawlerStrategy = deliveryService.determineOptimalStrategy(crawlerRequest);
        deliveryService.setRenderingStrategy(crawlerStrategy);
        deliveryService.renderContent(page, crawlerRequest);

        // Reset page for next scenario
        page = createSamplePage();

        // Scenario 4: User with accessibility needs
        System.out.println("=== SCENARIO 4: USER WITH ACCESSIBILITY NEEDS ===");
        HttpRequest accessibilityRequest = new HttpRequest();
        accessibilityRequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        accessibilityRequest.addHeader("Sec-CH-Prefers-Reduced-Motion", "reduce");
        accessibilityRequest.addCookie("accessibility", "true");

        RenderingStrategy accessibilityStrategy = deliveryService.determineOptimalStrategy(accessibilityRequest);
        deliveryService.setRenderingStrategy(accessibilityStrategy);
        deliveryService.renderContent(page, accessibilityRequest);
    }

    private static ContentPage createSamplePage() {
        ContentPage page = new ContentPage("Strategy Pattern Demo Page");

        // Add metadata
        page.addMetadata("description", "A demonstration of the Strategy Pattern for content rendering");
        page.addMetadata("author", "Claude Examples");

        // Create and add content blocks

        // Navigation block
        ContentBlock navBlock = new ContentBlock("nav-main", "navigation");
        navBlock.addContent("links", Arrays.asList("Home", "Products", "About", "Contact"));
        page.addBlock(navBlock);

        // Hero block
        ContentBlock heroBlock = new ContentBlock("hero-main", "hero");
        heroBlock.addContent("headline", "Welcome to Strategy Pattern Demo");
        heroBlock.addContent("backgroundImage", "hero-background.jpg");
        page.addBlock(heroBlock);

        // Main content block
        ContentBlock mainContentBlock = new ContentBlock("content-main", "mainContent");
        mainContentBlock.addContent("title", "Understanding the Strategy Pattern");
        mainContentBlock.addContent("body", "The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable.");
        page.addBlock(mainContentBlock);

        // Image gallery block
        ContentBlock galleryBlock = new ContentBlock("gallery-examples", "image");
        galleryBlock.addContent("images", Arrays.asList(
                Map.of("src", "strategy-uml.jpg", "alt", "Strategy Pattern UML Diagram"),
                Map.of("src", "example1.jpg", "alt", "Example Implementation 1"),
                Map.of("src", "example2.jpg", "alt", "Example Implementation 2")
        ));
        page.addBlock(galleryBlock);

        // Sidebar block
        ContentBlock sidebarBlock = new ContentBlock("sidebar-related", "sidebar");
        sidebarBlock.addContent("title", "Related Design Patterns");
        sidebarBlock.addContent("links", Arrays.asList(
                Map.of("title", "Factory Method", "url", "/patterns/factory-method"),
                Map.of("title", "Observer", "url", "/patterns/observer"),
                Map.of("title", "Decorator", "url", "/patterns/decorator")
        ));
        page.addBlock(sidebarBlock);

        // Comments block
        ContentBlock commentsBlock = new ContentBlock("comments-section", "comments");
        commentsBlock.addContent("title", "User Comments");
        commentsBlock.addContent("count", 15);
        page.addBlock(commentsBlock);

        // Related content block
        ContentBlock relatedBlock = new ContentBlock("related-articles", "relatedContent");
        relatedBlock.addContent("title", "You might also like");
        relatedBlock.addContent("articles", Arrays.asList(
                Map.of("title", "Mastering Design Patterns", "url", "/articles/mastering-patterns"),
                Map.of("title", "Java Implementation Best Practices", "url", "/articles/java-best-practices")
        ));
        page.addBlock(relatedBlock);

        // Footer block
        ContentBlock footerBlock = new ContentBlock("footer-main", "footer");
        footerBlock.addContent("copyright", "© 2025 Pattern Examples Inc.");
        footerBlock.addContent("links", Arrays.asList("Privacy Policy", "Terms of Service", "Contact Us"));
        page.addBlock(footerBlock);

        return page;
    }
}
