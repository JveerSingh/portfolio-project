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
     * Demonstrates managing and comparing multiple portfolios.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        StockTracker jay = new StockTracker1L();
        StockTracker tim = new StockTracker1L();
        StockTracker jeremy = new StockTracker1L();

        // Jay's portfolio
        jay.addTicker("TSLA", 5, 190.0);
        jay.addTicker("AAPL", 8, 175.0);

        // Tim's portfolio
        tim.addTicker("MSFT", 4, 400.0);
        tim.addTicker("NVDA", 2, 900.0);

        // Jeremy's portfolio
        jeremy.addTicker("AMZN", 6, 185.0);
        jeremy.addTicker("GOOG", 3, 160.0);

        System.out.println("Jay's portfolio: " + jay);
        System.out.println("Tim's portfolio: " + tim);
        System.out.println("Jeremy's portfolio: " + jeremy);

        System.out.println();

        System.out.println("Jay total value: $" + jay.totalValue());
        System.out.println("Tim total value: $" + tim.totalValue());
        System.out.println("Jeremy total value: $" + jeremy.totalValue());

        System.out.println();

        if (jay.totalValue() > tim.totalValue()
                && jay.totalValue() > jeremy.totalValue()) {
            System.out.println("Jay has the most valuable portfolio.");
        } else if (tim.totalValue() > jay.totalValue()
                && tim.totalValue() > jeremy.totalValue()) {
            System.out.println("Tim has the most valuable portfolio.");
        } else {
            System.out.println("Jeremy has the most valuable portfolio.");
        }

        System.out.println();

        System.out.println("Jay's largest holding: " + jay.largestHolding());
        System.out.println("Tim's largest holding: " + tim.largestHolding());
        System.out.println(
                "Jeremy's largest holding: " + jeremy.largestHolding());
    }
}