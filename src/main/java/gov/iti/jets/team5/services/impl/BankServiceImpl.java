package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.CreditCardDto;
import gov.iti.jets.team5.services.BankService;

public class BankServiceImpl implements BankService {

    @Override
    public Boolean isValidCreditCard(CreditCardDto creditCardDto) {
        //todo: get the Entity from db then map it to the dto
        CreditCardDto mappedCreditCard =new CreditCardDto("1234","1234");
        return (creditCardDto.equals(mappedCreditCard));
    }

    @Override
    public Boolean withdraw(CreditCardDto creditCardDto, Double totalOrderPrice) {
        //todo: get the credit card Balance from db
        Double storedBalance = 1200.5;
        if(totalOrderPrice<=storedBalance){
            //todo: update the price in db as the transaction done
            Double newBalance = storedBalance-totalOrderPrice;
            return true;
        }
        else {
            return false;
        }
    }

}
