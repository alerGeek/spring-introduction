package pl.sda.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.sda.springintroduction.dto.CreateReceiptDto;
import pl.sda.springintroduction.model.Receipt;

import java.util.Optional;

@Service
public interface ReciptService {

    public Optional<Receipt> findById(long id);

    Receipt create(CreateReceiptDto createReceiptDto);

}