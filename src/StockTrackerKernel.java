import components.standard.Standard;

/**
 * Kernel interface for StockTracker.
 */
public interface StockTrackerKernel extends Standard<StockTracker> {

    /**
     * Sets the share count for {@code ticker} by replacing the existing value.
     *
     * @param ticker
     *            the stock ticker symbol
     * @param shares
     *            the new share count for {@code ticker}
     * @requires ticker is in this AND shares >= 0
     * @updates this
     * @ensures sharesOf(ticker) = shares
     */
    void setShares(String ticker, int shares);

    /**
     * Adds {@code ticker} to this tracker with the given shares and price.
     *
     * @param ticker
     *            the stock ticker symbol to add
     * @param shares
     *            the initial share count for {@code ticker}
     * @param price
     *            the initial price for {@code ticker}
     * @requires ticker is not in this AND shares >= 0 AND price >= 0.0
     * @updates this
     * @ensures ticker is in this
     * @ensures sharesOf(ticker) = shares
     */
    void addTicker(String ticker, int shares, double price);

    /**
     * Removes {@code ticker} from this tracker and returns its share count.
     *
     * @param ticker
     *            the stock ticker symbol to remove
     * @return the shares that were associated with {@code ticker}
     * @requires ticker is in this
     * @updates this
     * @ensures ticker is not in this
     */
    int removeTicker(String ticker);

    /**
     * Reports whether {@code ticker} is tracked by this component.
     *
     * @param ticker
     *            the stock ticker symbol
     * @return {@code true} iff {@code ticker} is tracked
     * @ensures hasTicker = (ticker is in this)
     */
    boolean hasTicker(String ticker);

    /**
     * Reports the share count for {@code ticker}.
     *
     * @param ticker
     *            the stock ticker symbol
     * @return the share count associated with {@code ticker}
     * @requires ticker is in this
     * @ensures sharesOf = the share count associated with {@code ticker}
     */
    int sharesOf(String ticker);

    /**
     * Sets the price for {@code ticker} by replacing the existing value.
     *
     * @param ticker
     *            the stock ticker symbol
     * @param price
     *            the new price for {@code ticker}
     * @requires ticker is in this AND price >= 0.0
     * @updates this
     * @ensures priceOf(ticker) = price
     */
    void setPrice(String ticker, double price);

    /**
     * Reports the price for {@code ticker}.
     *
     * @param ticker
     *            the stock ticker symbol
     * @return the price associated with {@code ticker}
     * @requires ticker is in this
     * @ensures priceOf = the price associated with {@code ticker}
     */
    double priceOf(String ticker);

}
