import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code StockTracker} implementations.
 */
public abstract class StockTrackerTest {

    /**
     * Returns a constructor for the implementation under test.
     *
     * @return the implementation under test
     */
    protected abstract StockTracker constructorTest();

    /**
     * Returns a constructor for the reference implementation.
     *
     * @return the reference implementation
     */
    protected abstract StockTracker constructorRef();

    @Test
    public final void testConstructor() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(ref, test);
    }

    @Test
    public final void testAddTicker() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testRemoveTicker() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        int testRemoved = test.removeTicker("AAPL");
        int refRemoved = ref.removeTicker("AAPL");

        assertEquals(refRemoved, testRemoved);
        assertEquals(ref, test);
    }

    @Test
    public final void testSetShares() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setShares("AAPL", 25);
        ref.setShares("AAPL", 25);

        assertEquals(ref, test);
    }

    @Test
    public final void testSetPrice() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setPrice("AAPL", 175.0);
        ref.setPrice("AAPL", 175.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testAddShares() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.addShares("AAPL", 5);
        ref.addShares("AAPL", 5);

        assertEquals(ref, test);
    }

    @Test
    public final void testNumberOfTickers() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        assertEquals(2, test.numberOfTickers());
    }

    @Test
    public final void testTotalShares() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        assertEquals(15, test.totalShares());
    }

    @Test
    public final void testLargestHolding() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 25, 300.0);

        assertEquals("MSFT", test.largestHolding());
    }

    @Test
    public final void testIsEmptyTrue() {
        StockTracker test = this.constructorTest();

        assertTrue(test.isEmpty());
    }

    @Test
    public final void testIsEmptyFalse() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);

        assertFalse(test.isEmpty());
    }

    @Test
    public final void testTotalValue() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        assertEquals(3000.0, test.totalValue(), 0.000001);
    }

    @Test
    public final void testHasTicker() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);

        assertTrue(test.hasTicker("AAPL"));
        assertFalse(test.hasTicker("MSFT"));
    }

    @Test
    public final void testSharesOf() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);

        assertEquals(10, test.sharesOf("AAPL"));
    }

    @Test
    public final void testPriceOf() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);

        assertEquals(150.0, test.priceOf("AAPL"), 0.000001);
    }

    @Test
    public final void testSize() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        assertEquals(2, test.size());
    }

    @Test
    public final void testClear() {
        StockTracker test = this.constructorTest();

        test.addTicker("AAPL", 10, 150.0);
        test.clear();

        assertEquals(0, test.size());
        assertTrue(test.isEmpty());
    }

    @Test
    public final void testNewInstance() {
        StockTracker test = this.constructorTest();
        StockTracker other = test.newInstance();

        assertEquals(0, other.size());
    }

    @Test
    public final void testTransferFrom() {
        StockTracker test = this.constructorTest();
        StockTracker source = this.constructorTest();

        source.addTicker("AAPL", 10, 150.0);
        source.addTicker("MSFT", 5, 300.0);

        test.transferFrom(source);

        assertEquals(2, test.size());
        assertEquals(0, source.size());
        assertTrue(test.hasTicker("AAPL"));
        assertTrue(test.hasTicker("MSFT"));
    }
}