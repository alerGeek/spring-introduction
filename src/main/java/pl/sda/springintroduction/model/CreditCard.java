package pl.sda.springintroduction.model;

import java.time.LocalDate;

public class CreditCard {
    private String firstName;
    private String lastName;
    private String number;
    private LocalDate expiryDate;

    public CreditCard(String firstName, String lastName, String number, LocalDate expiryDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.expiryDate = expiryDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
