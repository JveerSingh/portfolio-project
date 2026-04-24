/**
 * JUnit test fixture for {@code StockTracker1L}.
 */
public final class StockTracker1LTest extends StockTrackerTest {

    @Override
    protected StockTracker constructorTest() {
        return new StockTracker1L();
    }

    @Override
    protected StockTracker constructorRef() {
        return new StockTracker1L();
    }
}