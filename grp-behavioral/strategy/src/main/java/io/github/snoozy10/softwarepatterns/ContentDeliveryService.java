package io.github.snoozy10.softwarepatterns;

// Context class
public class ContentDeliveryService {
    private RenderingStrategy strategy;

    public ContentDeliveryService() {
        // Default constructor
    }

    public ContentDeliveryService(RenderingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setRenderingStrategy(RenderingStrategy strategy) {
        this.strategy = strategy;
    }

    public RenderingStrategy getRenderingStrategy() {
        return strategy;
    }

    public void renderContent(ContentPage page, HttpRequest request) {
        if (strategy == null) {
            strategy = determineOptimalStrategy(request);
        }

        // Apply the selected strategy to optimize the page
        strategy.optimizeAssets(page);
        strategy.prioritizeContentBlocks(page);
        strategy.cacheStrategy(page);
        strategy.handleProgressiveLoading(page);

        // Render the page with applied strategies
        page.render();
    }

    public RenderingStrategy determineOptimalStrategy(HttpRequest request) {
        // Analyze request headers
        String userAgent = request.getHeader("User-Agent");
        String connectionType = request.getHeader("Downlink"); // Theoretical header
        String preferredMode = request.getHeader("Sec-CH-Prefers-Reduced-Motion"); // Actual Client Hint

        // Check user preferences and device capabilities
        boolean isMobile = userAgent != null &&
                (userAgent.contains("Mobile") || userAgent.contains("Android"));
        boolean isLowBandwidth = connectionType != null && Double.parseDouble(connectionType) < 1.0; // Less than 1 Mbps
        boolean isCrawler = userAgent != null &&
                (userAgent.contains("Googlebot") || userAgent.contains("bingbot") ||
                        userAgent.contains("Baiduspider") || userAgent.contains("YandexBot"));
        boolean needsAccessibility = preferredMode != null ||
                (request.getCookie("accessibility") != null &&
                        request.getCookie("accessibility").equals("true"));

        // Select appropriate strategy
        if (isCrawler) {
            return new SEOCrawlerStrategy();
        } else if (needsAccessibility) {
            return new AccessibilityFocusedStrategy();
        } else if (isMobile && isLowBandwidth) {
            return new MobileLowBandwidthStrategy();
        } else {
            return new DesktopHighPerformanceStrategy();
        }
    }
}
