package io.github.snoozy10.softwarepatterns;

// Strategy Interface
public interface RenderingStrategy {
    void optimizeAssets(ContentPage page);

    void prioritizeContentBlocks(ContentPage page);

    void cacheStrategy(ContentPage page);

    void handleProgressiveLoading(ContentPage page);
}
