package pl.sda.springintroduction.service;

import org.springframework.stereotype.Component;
import pl.sda.springintroduction.exception.UnreachableException;
import pl.sda.springintroduction.model.ChargeResult;
import pl.sda.springintroduction.model.TransactionLog;

@Component
public class DatabaseTransactionLog implements TransactionLog {
    public void logChargeResult(ChargeResult result) {

    }

    public void logConnectException(UnreachableException e) {

    }
}
