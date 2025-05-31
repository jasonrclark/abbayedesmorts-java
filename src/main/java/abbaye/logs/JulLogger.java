/* Copyright (C) The Authors 2023-2025 */
package abbaye.logs;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class JulLogger implements GameLogger {

  private final String name;
  private final Logger delegate;

  public JulLogger(String name) {
    this.name = name;
    delegate = Logger.getLogger(this.name);
  }

  @Override
  public LogLevel getMinLevel() {
    // FIXME Make this convert properly
    return LogLevel.INFO;
  }

  @Override
  public void debug(String message) {
    LogRecord logRecord = new LogRecord(Level.FINER, message);
    logRecord.setLoggerName(name);
    delegate.log(logRecord);
  }

  @Override
  public void debug(String message, Throwable err) {
    LogRecord logRecord = new LogRecord(Level.FINER, message);
    logRecord.setLoggerName(name);
    logRecord.setThrown(err);
    delegate.log(logRecord);
  }

  @Override
  public void info(String message) {
    LogRecord logRecord = new LogRecord(Level.INFO, message);
    logRecord.setLoggerName(name);
    delegate.log(logRecord);
  }

  @Override
  public void error(String message) {
    LogRecord logRecord = new LogRecord(Level.SEVERE, message);
    logRecord.setLoggerName(name);
    delegate.log(logRecord);
  }

  @Override
  public void error(String message, Throwable err) {
    LogRecord logRecord = new LogRecord(Level.SEVERE, message);
    logRecord.setLoggerName(name);
    logRecord.setThrown(err);
    delegate.log(logRecord);
  }

  @Override
  public void warning(String message) {
    LogRecord logRecord = new LogRecord(Level.WARNING, message);
    logRecord.setLoggerName(name);
    delegate.log(logRecord);
  }

  @Override
  public void warning(String message, Throwable err) {
    LogRecord logRecord = new LogRecord(Level.WARNING, message);
    logRecord.setLoggerName(name);
    logRecord.setThrown(err);
    delegate.log(logRecord);
  }
}
