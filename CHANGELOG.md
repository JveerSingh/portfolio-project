# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [2026.04.24]

### Added

- Designed a full JUnit test suite for the StockTracker component.
- Added use case demonstrating basic portfolio creation and reporting.
- Added use case demonstrating comparison of multiple portfolios.

### Updated

- Polished StockTracker documentation and example usage.
- Improved final component testing coverage.

## [2026.04.15]

### Added

- Implemented kernel representation for the StockTracker component
- Added convention and correspondence for `StockTracker1L`

### Updated

- Completed all kernel methods in `StockTracker1L`
- Completed Standard methods (`clear`, `newInstance`, and `transferFrom`)

## [2026.03.31]

### Added

- Implemented abstract class StockTrackerSecondary for StockTracker component
- Added kernel methods size() and removeAnyTicker() to support iteration over tickers

### Updated

- Refined kernel design to enable implementation of all secondary methods
- Implemented all secondary methods using only kernel methods and Standard methods (newInstance, transferFrom)
- Implemented common methods toString() and equals() in abstract class

## [2026.03.9]

### Added

- Designed kernel and enhanced interfaces for StockTracker component

### Updated

- Changed design to include new kernel methods priceOf() and setPrice(), and new secondary method totalValue() along with reusing proof of concept methods

## [2026.02.26]

### Added

- Designed a proof of concept for StockTracker component

### Updated

- Changed design to include proof-of-concept implementation

## [2026.02.06]

### Added

- Designed a StockTracker component
- Designed a BankAccount component
- Designed an ArtificialNeuron component