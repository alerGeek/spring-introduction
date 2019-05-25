package pl.sda.springintroduction.repository;

import pl.sda.springintroduction.model.Receipt;

import java.util.Optional;

public interface ReceiptRepository {

    Optional<Receipt> findById(long id);

    Receipt save(Receipt receipt);
}