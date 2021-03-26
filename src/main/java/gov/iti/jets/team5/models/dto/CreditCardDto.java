package gov.iti.jets.team5.models.dto;

public class CreditCardDto {
    public String creditCardNumber;
    public String cvv;

    public CreditCardDto(String creditCardNumber, String cvv) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
    }

    public CreditCardDto() {
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCardDto)) return false;
        CreditCardDto that = (CreditCardDto) o;
        return getCreditCardNumber().equals(that.getCreditCardNumber()) && getCvv().equals(that.getCvv());
    }

}
