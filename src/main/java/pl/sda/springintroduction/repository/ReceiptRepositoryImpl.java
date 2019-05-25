package pl.sda.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.sda.springintroduction.model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository {

    private final List<Receipt> receipts = new ArrayList<>();
    private long lastId = 0;

    public Optional<Receipt> findById(long id) {
        return receipts.stream()
                .filter(receipt -> id == receipt.getId())
                .findFirst();
    }


    @Override
    public Receipt save(Receipt receipt) {
        lastId++;
        receipt.setId(lastId);
        receipts.add(receipt);

        return receipt;
    }
}