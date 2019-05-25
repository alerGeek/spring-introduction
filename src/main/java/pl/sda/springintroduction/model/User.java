package pl.sda.springintroduction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String email;
    private CreditCard creditCard;
}
