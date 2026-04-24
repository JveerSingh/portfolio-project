/**
 * Second use case demo.
 */
public final class StockTrackerUseCase2 {

    /**
     * Constructor.
     */
    private StockTrackerUseCase2() {
    }

    /**
     * Demonstrates updating shares and prices in a tracker.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Jays Portfolio
        StockTracker s1 = new StockTracker1L();
        s1.addTicker("TSLA", 2, 180.0);
        s1.addShares("TSLA", 3);
        s1.setPrice("TSLA", 190.0);

        // Tims Portfolio
        StockTracker s2 = new StockTracker1L();

        // Jeremys Portfolio
        StockTracker s3 = new StockTracker1L();

    }
}