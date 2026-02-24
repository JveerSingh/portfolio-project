import components.map.Map;
import components.map.Map1L;

/**
 * Proof of Concept for the StockTracker component.
 */
public class StockTrackerPoC {

    /**
     * Map of ticker and shares.
     */
    private Map<String, Integer> sharesByTicker;

    /**
     * Map of ticker and price.
     */
    private Map<String, Double> priceByTicker;

    /**
     * No argument constructor.
     */
    public StockTrackerPoC() {
        this.sharesByTicker = new Map1L<>();
        this.priceByTicker = new Map1L<>();
    }

    // Kernel Methods

    /**
     * Sets the share count for {@code ticker} by replacing the existing value.
     *
     * @param ticker
     *            the stock ticker symbol
     * @param shares
     *            the new share count for {@code ticker}
     * @requires ticker is in this.sharesByTicker
     * @ensures sharesOf(ticker) = shares
     */
    public void setShares(String ticker, int shares) {
        this.sharesByTicker.replaceValue(ticker, shares);
    }

    /**
     * Adds {@code ticker} to this tracker with the given shares and price.
     *
     * @param ticker
     *            the stock ticker symbol to add
     * @param shares
     *            the initial share count for {@code ticker}
     * @param price
     *            the initial price for {@code ticker}
     * @requires ticker is not in this.sharesByTicker AND ticker is not in
     *           this.priceByTicker
     * @requires shares >= 0 AND price >= 0.0
     * @ensures ticker is in this.sharesByTicker AND ticker is in
     *          this.priceByTicker
     * @ensures sharesOf(ticker) = shares
     * @ensures the value mapped to ticker in this.priceByTicker = price
     */
    public void addTicker(String ticker, int shares, double price) {
        this.sharesByTicker.add(ticker, shares);
        this.priceByTicker.add(ticker, price);
    }

    /**
     * Removes {@code ticker} from this tracker and returns its share count.
     *
     * @param ticker
     *            the stock ticker symbol to remove
     * @return the shares that were associated with {@code ticker}
     * @requires ticker is in this.sharesByTicker
     * @ensures ticker is not in this.sharesByTicker
     */
    public int removeTicker(String ticker) {
        Map.Pair<String, Integer> pair = this.sharesByTicker.remove(ticker);
        this.priceByTicker.remove(ticker);
        return pair.value();
    }

    /**
     * Reports whether {@code ticker} is tracked by this component.
     *
     * @param ticker
     *            the stock ticker symbol
     * @return {@code true} iff {@code ticker} is a key in both maps
     * @ensures hasTicker = (ticker is in this.sharesByTicker AND ticker is in
     *          this.priceByTicker)
     */
    public boolean hasTicker(String ticker) {
        boolean result = this.sharesByTicker.hasKey(ticker)
                && this.priceByTicker.hasKey(ticker);
        return result;
    }

    /**
     * Reports the share count for {@code ticker}.
     *
     * @param ticker
     *            the stock ticker symbol
     * @return the share count associated with {@code ticker}
     * @requires ticker is in this.sharesByTicker
     * @ensures sharesOf = the value mapped to ticker in this.sharesByTicker
     */
    public int sharesOf(String ticker) {
        return this.sharesByTicker.value(ticker);
    }

    // Secondary Methods

    public void addShares(String ticker, int delta) {

    }

    public int numberOfTickers() {

    }

    public int totalShares() {

    }

    String largestHolding() {

    }

    boolean isEmpty() {

    }
}
