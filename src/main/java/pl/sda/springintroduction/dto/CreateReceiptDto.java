package pl.sda.springintroduction.dto;

import lombok.Data;

@Data
public class CreateReceiptDto {

    private long UserId;
    private long orderId;
}
