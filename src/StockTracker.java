
/**
 * Enhanced interface for StockTracker.
 */
public interface StockTracker extends StockTrackerKernel {

    /**
     * Adds {@code delta} shares to {@code ticker}.
     *
     * @param ticker
     *            the stock ticker symbol
     * @param delta
     *            the change in shares (may be negative)
     * @requires ticker is in this AND sharesOf(ticker) + delta >= 0
     * @updates this
     * @ensures sharesOf(ticker) = #sharesOf(ticker) + delta
     */
    void addShares(String ticker, int delta);

    /**
     * Reports the number of tickers being tracked.
     *
     * @return the number of tickers in this tracker
     * @ensures numberOfTickers = number of tickers in this
     */
    int numberOfTickers();

    /**
     * Reports the total number of shares across all tracked tickers.
     *
     * @return the sum of all share counts in this tracker
     * @ensures totalShares = sum of shares over all tickers in this
     */
    int totalShares();

    /**
     * Reports the ticker with the largest share count.
     *
     * @return a ticker whose share count is maximal among tracked tickers
     * @requires this is not empty
     * @ensures largestHolding is in this
     */
    String largestHolding();

    /**
     * Reports whether this tracker has no tickers.
     *
     * @return {@code true} iff no tickers are tracked
     * @ensures isEmpty = (numberOfTickers() = 0)
     */
    boolean isEmpty();

    /**
     * Reports the total value across all tracked tickers.
     *
     * @return the sum of shares times price over all tickers in this
     * @ensures totalValue = sum of (shares times price) over all tickers in
     *          this
     */
    double totalValue();

}
