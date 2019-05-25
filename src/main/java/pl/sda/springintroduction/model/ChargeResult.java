package pl.sda.springintroduction.model;

public class ChargeResult {
    private String message;
    private boolean successful;

    public ChargeResult(boolean successful, String declineMessage) {
        this.message = declineMessage;
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
