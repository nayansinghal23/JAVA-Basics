package ATMMachine.models;

public class Card {
    private final long cardNumber;
    private final int pin;
    private final String cardHolderName;
    private final String cardType;
    private final String bankName;

    public Card(long cardNumber, int pin, String cardHolderName, String cardType, String bankName) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
        this.bankName = bankName;
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public int getPin() {
        return this.pin;
    }
    
    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public String getCardType() {
        return this.cardType;
    }
    
    public String getBankName() {
        return this.bankName;
    }

    @Override
    public String toString() {
        return "Card [cardNumber=" + cardNumber + ", pin=" + pin + ", cardHolderName=" + cardHolderName + ", cardType=" + cardType + ", bankName=" + bankName + "]";
    }
}
