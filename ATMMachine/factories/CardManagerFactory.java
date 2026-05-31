package ATMMachine.factories;

import ATMMachine.enums.CardType;
import ATMMachine.services.CardManagerService;
import ATMMachine.services.DebitCardManagerService;
import ATMMachine.services.CreditCardManagerService;

// The responsibility of factory is to create different type of objects of your different type of class with the help of just one method call.

public class CardManagerFactory {
    public static CardManagerService getCardManagerService(CardType cardType) {
        if(cardType.equals(CardType.DEBIT)) {
            return new DebitCardManagerService();
        } else if(cardType.equals(CardType.CREDIT)) {
            return new CreditCardManagerService();
        }
        throw new IllegalArgumentException("Invalid card type");
    }
}
