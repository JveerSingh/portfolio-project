# StockTracker Component

This project implements a `StockTracker` software component for managing stock portfolios. The component tracks ticker symbols, share counts, and prices, and supports operations such as adding/removing tickers, updating shares and prices, calculating total shares, calculating total portfolio value, and finding the largest holding.

## Features

- Add and remove stock tickers
- Track shares for each ticker
- Track prices for each ticker
- Update share counts and stock prices
- Calculate total number of shares
- Calculate total portfolio value
- Find the ticker with the largest holding
- Compare and manage multiple portfolios through example use cases

## Project Structure

```text
src/
    StockTracker.java
    StockTrackerKernel.java
    StockTrackerSecondary.java
    StockTracker1L.java
    StockTrackerUseCase1.java
    StockTrackerUseCase2.java

test/
    StockTrackerTest.java
    StockTracker1LTest.java
```

## How to Run

To run the use cases:

- Run `StockTrackerUseCase1` for basic portfolio functionality
- Run `StockTrackerUseCase2` for managing and comparing multiple portfolios

To run tests:

- Run `StockTracker1LTest` using JUnit