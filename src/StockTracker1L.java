import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;

/**
 * {@code StockTracker} represented by two maps and a queue.
 *
 * @convention [sharesByTicker and priceByTicker have exactly the same keys] and
 *             [all share counts are >= 0] and [all prices are >= 0.0] and
 *             [tickerOrder contains each tracked ticker exactly once]
 * @correspondence this represents the set of tracked ticker symbols t where
 *                 sharesOf(t) = sharesByTicker.value(t) and priceOf(t) =
 *                 priceByTicker.value(t)
 */
public final class StockTracker1L extends StockTrackerSecondary {

    /*
     * Private members
     */

    /**
     * Map from ticker to shares.
     */
    private Map<String, Integer> sharesByTicker;

    /**
     * Map from ticker to price.
     */
    private Map<String, Double> priceByTicker;

    /**
     * Rotation order for tickers.
     */
    private Queue<String> tickerOrder;

    /**
     * Creates representation.
     */
    private void createNewRep() {
        this.sharesByTicker = new Map1L<>();
        this.priceByTicker = new Map1L<>();
        this.tickerOrder = new Queue1L<>();
    }

    /**
     * No-argument constructor.
     */
    public StockTracker1L() {
        this.createNewRep();
    }

    @Override
    public void setShares(String ticker, int shares) {
        assert ticker != null : "Violation of: ticker is not null";
        assert shares >= 0 : "Violation of: shares >= 0";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";

        this.sharesByTicker.replaceValue(ticker, shares);
    }

    @Override
    public void addTicker(String ticker, int shares, double price) {
        assert ticker != null : "Violation of: ticker is not null";
        assert shares >= 0 : "Violation of: shares >= 0";
        assert price >= 0.0 : "Violation of: price >= 0.0";
        assert !this.hasTicker(ticker) : "Violation of: ticker is not in this";

        this.sharesByTicker.add(ticker, shares);
        this.priceByTicker.add(ticker, price);
        this.tickerOrder.enqueue(ticker);
    }

    @Override
    public int removeTicker(String ticker) {
        assert ticker != null : "Violation of: ticker is not null";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";

        Map.Pair<String, Integer> removed = this.sharesByTicker.remove(ticker);
        this.priceByTicker.remove(ticker);

        Queue<String> temp = new Queue1L<>();
        int n = this.tickerOrder.length();

        for (int i = 0; i < n; i++) {
            String current = this.tickerOrder.dequeue();
            if (!current.equals(ticker)) {
                temp.enqueue(current);
            }
        }

        this.tickerOrder.transferFrom(temp);
        return removed.value();
    }

    @Override
    public boolean hasTicker(String ticker) {
        assert ticker != null : "Violation of: ticker is not null";

        return this.sharesByTicker.hasKey(ticker)
                && this.priceByTicker.hasKey(ticker);
    }

    @Override
    public int sharesOf(String ticker) {
        assert ticker != null : "Violation of: ticker is not null";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";

        return this.sharesByTicker.value(ticker);
    }

    @Override
    public void setPrice(String ticker, double price) {
        assert ticker != null : "Violation of: ticker is not null";
        assert price >= 0.0 : "Violation of: price >= 0.0";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";

        this.priceByTicker.replaceValue(ticker, price);
    }

    @Override
    public double priceOf(String ticker) {
        assert ticker != null : "Violation of: ticker is not null";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";

        return this.priceByTicker.value(ticker);
    }

    @Override
    public String reportTicker() {
        assert this.size() > 0 : "Violation of: this is not empty";

        String ticker = this.tickerOrder.dequeue();
        this.tickerOrder.enqueue(ticker);
        return ticker;
    }

    @Override
    public int size() {
        return this.sharesByTicker.size();
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public StockTracker newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void transferFrom(StockTracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof StockTracker1L : "Violation of: source is of dynamic type StockTracker1L";

        StockTracker1L localSource = (StockTracker1L) source;

        this.sharesByTicker = localSource.sharesByTicker;
        this.priceByTicker = localSource.priceByTicker;
        this.tickerOrder = localSource.tickerOrder;

        localSource.createNewRep();
    }

}
