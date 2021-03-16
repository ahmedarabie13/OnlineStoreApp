package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.LoginService;

public class LoginServiceImpl implements LoginService {
    private static LoginServiceImpl loginServiceInstance = null;

    public static LoginService getInstance() {
        if (loginServiceInstance == null) {
            loginServiceInstance = new LoginServiceImpl();
        }
        return loginServiceInstance;
    }

    @Override
    public Boolean isUserAuthed(UserAuthDto userAuthDto) {
        //todo: check across database
        String storedUserName = "Ahmed";
        String storedPassword = "1420";
        if (userAuthDto.getUserName().equals(storedUserName) && userAuthDto.getPassword().equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
