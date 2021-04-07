package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.CreditCardDto;
import gov.iti.jets.team5.repositories.BankRepository;
import gov.iti.jets.team5.services.BankService;

public class BankServiceImpl implements BankService {

    @Override
    public Boolean isValidCreditCard(CreditCardDto creditCardDto) {
        //todo: get the Entity from db then map it to the dto
        return BankRepository.getInstance().isValidCreditCard(creditCardDto);
//        return (creditCardDto.equals(mappedCreditCard));
    }

    @Override
    public Boolean withdraw(CreditCardDto creditCardDto, Long totalOrderPrice) {
        //todo: get the credit card Balance from db
        BankRepository bankRepository = BankRepository.getInstance();
        Long storedBalance = bankRepository.getBalance(creditCardDto);
        if(totalOrderPrice<=storedBalance){
            //todo: update the balance in db as the transaction done
            Long newBalance = storedBalance-totalOrderPrice;
            bankRepository.updateBalance(creditCardDto,newBalance);
            return true;
        }
        else {
            return false;
        }
    }

}
