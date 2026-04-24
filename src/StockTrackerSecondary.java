/**
 * Secondary implementation of StockTracker.
 */
public abstract class StockTrackerSecondary implements StockTracker {

    @Override
    public void addShares(String ticker, int delta) {
        assert ticker != null : "Violation of: ticker is not null";
        assert this.hasTicker(ticker) : "Violation of: ticker is in this";
        assert this.sharesOf(ticker)
                + delta >= 0 : "Violation of: sharesOf(ticker) + delta >= 0";

        int shares = this.sharesOf(ticker);
        this.setShares(ticker, shares + delta);
    }

    @Override
    public int numberOfTickers() {
        return this.size();
    }

    @Override
    public int totalShares() {
        int sum = 0;
        int n = this.size();
        StockTracker temp = this.newInstance();

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();

            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            sum += shares;

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        return sum;
    }

    @Override
    public String largestHolding() {
        assert !this.isEmpty() : "Violation of: this is not empty";

        String best = "";
        int bestShares = -1;

        int n = this.size();
        StockTracker temp = this.newInstance();

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();

            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            if (shares > bestShares) {
                bestShares = shares;
                best = t;
            }

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        return best;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public double totalValue() {
        double sum = 0.0;
        int n = this.size();
        StockTracker temp = this.newInstance();

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();

            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            sum += shares * price;

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        int n = this.size();
        StockTracker temp = this.newInstance();
        boolean first = true;

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();

            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            if (!first) {
                sb.append(", ");
            }

            sb.append(t).append(": ").append(shares).append(" @ ")
                    .append(price);

            first = false;

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StockTracker)) {
            return false;
        }

        StockTracker other = (StockTracker) obj;

        if (this.size() != other.size()) {
            return false;
        }

        boolean same = true;
        int n = this.size();
        StockTracker temp = this.newInstance();

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();
            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            if (!other.hasTicker(t) || other.sharesOf(t) != shares
                    || other.priceOf(t) != price) {
                same = false;
            }

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        return same;
    }

    @Override
    public int hashCode() {
        int result = 0;
        int n = this.size();
        StockTracker temp = this.newInstance();

        for (int i = 0; i < n; i++) {
            String t = this.reportTicker();
            int shares = this.sharesOf(t);
            double price = this.priceOf(t);

            result += t.hashCode() + shares + Double.valueOf(price).hashCode();

            temp.addTicker(t, shares, price);
        }

        this.transferFrom(temp);
        return result;
    }
}