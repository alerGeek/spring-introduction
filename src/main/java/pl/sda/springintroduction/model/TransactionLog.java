package pl.sda.springintroduction.model;

import pl.sda.springintroduction.exception.UnreachableException;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
