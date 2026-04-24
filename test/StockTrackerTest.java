import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code StockTracker} implementations.
 */
public abstract class StockTrackerTest {

    protected abstract StockTracker constructorTest();

    protected abstract StockTracker constructorRef();

    /*
     * Constructor
     */

    @Test
    public final void testConstructor() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(ref, test);
    }

    /*
     * addTicker
     */

    @Test
    public final void testAddTickerZeroShares() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 0, 150.0);
        ref.addTicker("AAPL", 0, 150.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testAddTickerOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testAddTickerMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);
        test.addTicker("TSLA", 25, 200.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);
        ref.addTicker("TSLA", 25, 200.0);

        assertEquals(ref, test);
    }

    /*
     * removeTicker
     */

    @Test
    public final void testRemoveTickerOne() {
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
    public final void testRemoveTickerMiddleOfMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);
        test.addTicker("TSLA", 25, 200.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);
        ref.addTicker("TSLA", 25, 200.0);

        int testRemoved = test.removeTicker("MSFT");
        int refRemoved = ref.removeTicker("MSFT");

        assertEquals(refRemoved, testRemoved);
        assertEquals(ref, test);
    }

    @Test
    public final void testRemoveTickerFirstOfMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        int testRemoved = test.removeTicker("AAPL");
        int refRemoved = ref.removeTicker("AAPL");

        assertEquals(refRemoved, testRemoved);
        assertEquals(ref, test);
    }

    /*
     * setShares
     */

    @Test
    public final void testSetSharesZero() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setShares("AAPL", 0);
        ref.setShares("AAPL", 0);

        assertEquals(ref, test);
    }

    @Test
    public final void testSetSharesOneTicker() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setShares("AAPL", 25);
        ref.setShares("AAPL", 25);

        assertEquals(ref, test);
    }

    @Test
    public final void testSetSharesMultipleTickers() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        test.setShares("MSFT", 20);
        ref.setShares("MSFT", 20);

        assertEquals(ref, test);
    }

    /*
     * setPrice
     */

    @Test
    public final void testSetPriceZero() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setPrice("AAPL", 0.0);
        ref.setPrice("AAPL", 0.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testSetPriceOneTicker() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.setPrice("AAPL", 175.0);
        ref.setPrice("AAPL", 175.0);

        assertEquals(ref, test);
    }

    @Test
    public final void testSetPriceMultipleTickers() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        test.setPrice("MSFT", 350.0);
        ref.setPrice("MSFT", 350.0);

        assertEquals(ref, test);
    }

    /*
     * addShares
     */

    @Test
    public final void testAddSharesPositive() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.addShares("AAPL", 5);
        ref.addShares("AAPL", 5);

        assertEquals(ref, test);
    }

    @Test
    public final void testAddSharesNegative() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.addShares("AAPL", -4);
        ref.addShares("AAPL", -4);

        assertEquals(ref, test);
    }

    @Test
    public final void testAddSharesToZero() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.addShares("AAPL", -10);
        ref.addShares("AAPL", -10);

        assertEquals(ref, test);
    }

    /*
     * numberOfTickers
     */

    @Test
    public final void testNumberOfTickersEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(0, test.numberOfTickers());
        assertEquals(ref, test);
    }

    @Test
    public final void testNumberOfTickersOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(1, test.numberOfTickers());
        assertEquals(ref, test);
    }

    @Test
    public final void testNumberOfTickersMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(2, test.numberOfTickers());
        assertEquals(ref, test);
    }

    /*
     * totalShares
     */

    @Test
    public final void testTotalSharesEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(0, test.totalShares());
        assertEquals(ref, test);
    }

    @Test
    public final void testTotalSharesOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(10, test.totalShares());
        assertEquals(ref, test);
    }

    @Test
    public final void testTotalSharesMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(15, test.totalShares());
        assertEquals(ref, test);
    }

    /*
     * largestHolding
     */

    @Test
    public final void testLargestHoldingOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals("AAPL", test.largestHolding());
        assertEquals(ref, test);
    }

    @Test
    public final void testLargestHoldingMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 25, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 25, 300.0);

        assertEquals("MSFT", test.largestHolding());
        assertEquals(ref, test);
    }

    @Test
    public final void testLargestHoldingThreeTickers() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 25, 300.0);
        test.addTicker("TSLA", 5, 200.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 25, 300.0);
        ref.addTicker("TSLA", 5, 200.0);

        assertEquals("MSFT", test.largestHolding());
        assertEquals(ref, test);
    }

    /*
     * isEmpty
     */

    @Test
    public final void testIsEmptyTrue() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertTrue(test.isEmpty());
        assertEquals(ref, test);
    }

    @Test
    public final void testIsEmptyFalse() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertFalse(test.isEmpty());
        assertEquals(ref, test);
    }

    @Test
    public final void testIsEmptyAfterRemove() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        test.removeTicker("AAPL");
        ref.removeTicker("AAPL");

        assertTrue(test.isEmpty());
        assertEquals(ref, test);
    }

    /*
     * totalValue
     */

    @Test
    public final void testTotalValueEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(0.0, test.totalValue(), 0.000001);
        assertEquals(ref, test);
    }

    @Test
    public final void testTotalValueOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(1500.0, test.totalValue(), 0.000001);
        assertEquals(ref, test);
    }

    @Test
    public final void testTotalValueMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(3000.0, test.totalValue(), 0.000001);
        assertEquals(ref, test);
    }

    /*
     * hasTicker
     */

    @Test
    public final void testHasTickerEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertFalse(test.hasTicker("AAPL"));
        assertEquals(ref, test);
    }

    @Test
    public final void testHasTickerTrue() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertTrue(test.hasTicker("AAPL"));
        assertEquals(ref, test);
    }

    @Test
    public final void testHasTickerFalseMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertFalse(test.hasTicker("TSLA"));
        assertEquals(ref, test);
    }

    /*
     * sharesOf
     */

    @Test
    public final void testSharesOfZero() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 0, 150.0);
        ref.addTicker("AAPL", 0, 150.0);

        assertEquals(0, test.sharesOf("AAPL"));
        assertEquals(ref, test);
    }

    @Test
    public final void testSharesOfOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(10, test.sharesOf("AAPL"));
        assertEquals(ref, test);
    }

    @Test
    public final void testSharesOfMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(5, test.sharesOf("MSFT"));
        assertEquals(ref, test);
    }

    /*
     * priceOf
     */

    @Test
    public final void testPriceOfZero() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 0.0);
        ref.addTicker("AAPL", 10, 0.0);

        assertEquals(0.0, test.priceOf("AAPL"), 0.000001);
        assertEquals(ref, test);
    }

    @Test
    public final void testPriceOfOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(150.0, test.priceOf("AAPL"), 0.000001);
        assertEquals(ref, test);
    }

    @Test
    public final void testPriceOfMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(300.0, test.priceOf("MSFT"), 0.000001);
        assertEquals(ref, test);
    }

    /*
     * reportTicker
     */

    @Test
    public final void testReportTickerOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(ref.reportTicker(), test.reportTicker());
        assertEquals(ref, test);
    }

    @Test
    public final void testReportTickerMultipleFirst() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(ref.reportTicker(), test.reportTicker());
        assertEquals(ref, test);
    }

    @Test
    public final void testReportTickerMultipleSecond() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        ref.reportTicker();
        test.reportTicker();

        assertEquals(ref.reportTicker(), test.reportTicker());
        assertEquals(ref, test);
    }

    /*
     * size
     */

    @Test
    public final void testSizeEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        assertEquals(0, test.size());
        assertEquals(ref, test);
    }

    @Test
    public final void testSizeOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        assertEquals(1, test.size());
        assertEquals(ref, test);
    }

    @Test
    public final void testSizeMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        ref.addTicker("AAPL", 10, 150.0);
        ref.addTicker("MSFT", 5, 300.0);

        assertEquals(2, test.size());
        assertEquals(ref, test);
    }

    /*
     * clear
     */

    @Test
    public final void testClearEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.clear();

        assertEquals(ref, test);
    }

    @Test
    public final void testClearOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);

        test.clear();

        assertEquals(ref, test);
    }

    @Test
    public final void testClearMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        test.addTicker("MSFT", 5, 300.0);

        test.clear();

        assertEquals(ref, test);
    }

    /*
     * newInstance
     */

    @Test
    public final void testNewInstanceEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        StockTracker testNew = test.newInstance();
        StockTracker refNew = ref.newInstance();

        assertEquals(refNew, testNew);
        assertEquals(ref, test);
    }

    @Test
    public final void testNewInstanceAfterAdd() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        test.addTicker("AAPL", 10, 150.0);
        ref.addTicker("AAPL", 10, 150.0);

        StockTracker testNew = test.newInstance();
        StockTracker refNew = ref.newInstance();

        assertEquals(refNew, testNew);
        assertEquals(ref, test);
    }

    @Test
    public final void testNewInstanceIndependent() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        StockTracker testNew = test.newInstance();
        testNew.addTicker("AAPL", 10, 150.0);

        assertEquals(ref, test);
        assertEquals(1, testNew.size());
    }

    /*
     * transferFrom
     */

    @Test
    public final void testTransferFromEmpty() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        StockTracker sourceTest = this.constructorTest();
        StockTracker sourceRef = this.constructorRef();

        test.transferFrom(sourceTest);
        ref.transferFrom(sourceRef);

        assertEquals(ref, test);
        assertEquals(sourceRef, sourceTest);
    }

    @Test
    public final void testTransferFromOne() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        StockTracker sourceTest = this.constructorTest();
        StockTracker sourceRef = this.constructorRef();

        sourceTest.addTicker("AAPL", 10, 150.0);
        sourceRef.addTicker("AAPL", 10, 150.0);

        test.transferFrom(sourceTest);
        ref.transferFrom(sourceRef);

        assertEquals(ref, test);
        assertEquals(sourceRef, sourceTest);
    }

    @Test
    public final void testTransferFromMultiple() {
        StockTracker test = this.constructorTest();
        StockTracker ref = this.constructorRef();

        StockTracker sourceTest = this.constructorTest();
        StockTracker sourceRef = this.constructorRef();

        sourceTest.addTicker("AAPL", 10, 150.0);
        sourceTest.addTicker("MSFT", 5, 300.0);

        sourceRef.addTicker("AAPL", 10, 150.0);
        sourceRef.addTicker("MSFT", 5, 300.0);

        test.transferFrom(sourceTest);
        ref.transferFrom(sourceRef);

        assertEquals(ref, test);
        assertEquals(sourceRef, sourceTest);
    }
}