package pl.sda.springintroduction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springintroduction.dto.CreateReceiptDto;
import pl.sda.springintroduction.model.Receipt;
import pl.sda.springintroduction.service.ReciptService;

import java.util.Optional;

@RestController
public class ReciptController {

    private final ReciptService reciptService;

    public ReciptController(ReciptService reciptService) {
        this.reciptService = reciptService;
    }

    @GetMapping("/receipts/{id}")
    public ResponseEntity<Receipt> findById(@PathVariable long id) {
        Optional<Receipt> optionalReceipt = reciptService.findById(id);

        if (optionalReceipt.isPresent()) {
            return ResponseEntity.ok(optionalReceipt.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/receipts")
    public Receipt create(@RequestBody CreateReceiptDto createReceiptDto){
        return  reciptService.create(createReceiptDto);
    }
}
