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
     * @requires ticker is in this.sharesByTicker AND ticker is in
     *           this.priceByTicker
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
     * @requires ticker is in this.sharesByTicker AND ticker is in
     *           this.priceByTicker
     *
     * @ensures ticker is not in this.sharesByTicker AND ticker is not in
     *          this.priceByTicker
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
     * @requires ticker is in this.sharesByTicker AND ticker is in
     *           this.priceByTicker
     * @ensures sharesOf = the value mapped to ticker in this.sharesByTicker
     */
    public int sharesOf(String ticker) {
        return this.sharesByTicker.value(ticker);
    }

    // Secondary Methods

    /**
     * Adds {@code delta} shares to {@code ticker}.
     *
     * @param ticker
     *            the stock ticker symbol
     * @param delta
     *            the change in shares (may be negative)
     * @requires ticker is in this.sharesByTicker AND ticker is in
     *           this.priceByTicker
     * @requires sharesOf(ticker) + delta >= 0
     * @ensures sharesOf(ticker) = #sharesOf(ticker) + delta
     */
    public void addShares(String ticker, int delta) {
        int shares = this.sharesByTicker.value(ticker);
        this.sharesByTicker.replaceValue(ticker, shares + delta);
    }

    /**
     * Reports the number of tickers being tracked.
     *
     * @return the number of tickers in this tracker
     * @ensures numberOfTickers = |this.sharesByTicker|
     */
    public int numberOfTickers() {
        return this.sharesByTicker.size();
    }

    /**
     * Reports the total number of shares across all tracked tickers.
     *
     * @return the sum of all share counts in this tracker
     * @ensures totalShares = sum of shares over all tickers in
     *          this.sharesByTicker
     */
    public int totalShares() {
        int sum = 0;
        int n = this.sharesByTicker.size();

        for (int i = 0; i < n; i++) {
            Map.Pair<String, Integer> p = this.sharesByTicker.removeAny();
            sum += p.value();
            this.sharesByTicker.add(p.key(), p.value());
        }
        return sum;
    }

    /**
     * Reports the ticker with the largest share count.
     *
     * @return a ticker whose share count is maximal among tracked tickers
     * @requires this.sharesByTicker is not empty
     * @ensures largestHolding is in this.sharesByTicker
     */
    public String largestHolding() {
        String bestTicker = "";
        int bestShares = -1;
        int n = this.sharesByTicker.size();

        for (int i = 0; i < n; i++) {
            Map.Pair<String, Integer> p = this.sharesByTicker.removeAny();

            if (p.value() > bestShares) {
                bestShares = p.value();
                bestTicker = p.key();
            }

            this.sharesByTicker.add(p.key(), p.value());
        }

        return bestTicker;
    }

    /**
     * Reports whether this tracker has no tickers.
     *
     * @return {@code true} iff no tickers are tracked
     * @ensures isEmpty = (numberOfTickers() = 0)
     */
    public boolean isEmpty() {
        return this.sharesByTicker.size() == 0;
    }

    /**
     *
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        StockTrackerPoC st = new StockTrackerPoC();

        // start empty
        System.out.println("Empty? " + st.isEmpty());

        // add tickers
        st.addTicker("AAPL", 10, 185.25);
        st.addTicker("MSFT", 4, 412.10);
        st.addTicker("GOOG", 1, 142.80);

        System.out.println("Tickers: " + st.numberOfTickers());
        System.out.println("Total shares: " + st.totalShares());
        System.out.println("Largest holding: " + st.largestHolding());

        // mutate holdings
        st.addShares("AAPL", 5); // AAPL -> 15
        st.setShares("MSFT", 7); // MSFT -> 7

        System.out.println("AAPL shares: " + st.sharesOf("AAPL"));
        System.out.println("MSFT shares: " + st.sharesOf("MSFT"));
        System.out.println(
                "Largest holding (after changes): " + st.largestHolding());
        System.out.println("Total shares (after changes): " + st.totalShares());

        // remove ticker
        int removed = st.removeTicker("GOOG");
        System.out.println("Removed GOOG shares: " + removed);
        System.out.println("Has GOOG? " + st.hasTicker("GOOG"));
        System.out.println("Tickers (after removal): " + st.numberOfTickers());
    }
}
