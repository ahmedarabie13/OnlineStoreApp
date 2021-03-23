package gov.iti.jets.team5.repositories;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {

    //todo session will be given in a different way maybe?
    public static boolean isRegistered(String enteredEmail, Session session){
        session.beginTransaction();
        Query q = session.createQuery("select u.email from UserData u");
        List<String> emails = q.list();
        boolean flag = false;
        for (String e : emails) {
            System.out.println(e + " <----- DB Email");
            if(e.equals(enteredEmail)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
