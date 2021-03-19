package gov.iti.jets.team5.utils.validations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegexValidations {

    public static boolean emailValidator(String email){
        String ePattern = "(^[A-Za-z0-9._-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$)| [ \\t\\n]*";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean phoneValidator(String phone){
        String ePattern = "^(\\+2)?01\\d{9}$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean passwordValidator(String password){
        String ePattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
