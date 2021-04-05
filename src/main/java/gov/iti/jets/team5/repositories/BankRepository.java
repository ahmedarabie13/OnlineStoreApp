package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.Bank;
import gov.iti.jets.team5.models.dto.CreditCardDto;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BankRepository {
    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static BankRepository instance = null;

    public static BankRepository getInstance() {
        if (instance == null) {
            synchronized (BankRepository.class) {
                if (instance == null) {
                    instance = new BankRepository();
                }
            }
        }
        return instance;
    }

    public boolean isValidCreditCard(CreditCardDto creditCardDto) {
        boolean isValidCreditCard = false;
        try {
            entityManager.getTransaction().begin();
            Bank bank = (Bank) entityManager.createQuery("from Bank where creditNumber = :ccNum")
                    .setParameter("ccNum", creditCardDto.getCreditCardNumber())
                    .getResultList().get(0);
            if (bank != null) {
                isValidCreditCard = creditCardDto.getCreditCardNumber().equals(bank.getCreditNumber())
                        && creditCardDto.getCvv().equals(bank.getCvv());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
        return isValidCreditCard;
    }

    public Long getBalance(CreditCardDto creditCardDto) {
        Long balance = 0L;
        try {
            entityManager.getTransaction().begin();
            var bank = (Bank) entityManager.createQuery("from Bank where creditNumber = :ccNum")
                    .setParameter("ccNum", creditCardDto.getCreditCardNumber())
                    .getResultList().get(0);
            balance = bank.getBalance();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
        return balance;
    }

    public void updateBalance(CreditCardDto creditCardDto, Long newBalance) {
        try {
            entityManager.getTransaction().begin();
            var bank = (Bank) entityManager.createQuery("from Bank where creditNumber = :ccNum")
                    .setParameter("ccNum", creditCardDto.getCreditCardNumber())
                    .getResultList().get(0);
            bank.setBalance(newBalance);
            entityManager.merge(bank);
            System.out.println("from repo: withdraw done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
    }
}
