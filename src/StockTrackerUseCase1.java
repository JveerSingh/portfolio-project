/**
 * First use case demo.
 */
public final class StockTrackerUseCase1 {

    /**
     * Constructor.
     */
    private StockTrackerUseCase1() {
    }

    /**
     * Demonstrates basic portfolio creation and reporting.
     * 
     * @param args
     */
    public static void main(String[] args) {
        StockTracker s = new StockTracker1L();

        s.addTicker("AAPL", 10, 175.0);
        s.addTicker("MSFT", 5, 400.0);

        System.out.println(s);
        System.out.println("Total shares: " + s.totalShares());
        System.out.println("Total value: " + s.totalValue());
    }
}