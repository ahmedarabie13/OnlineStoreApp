package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.CreditCardDto;

public interface BankService {
    Boolean isValidCreditCard(CreditCardDto creditCardDto);
    Boolean withdraw(CreditCardDto creditCardDto, Double totalPrice);
}
