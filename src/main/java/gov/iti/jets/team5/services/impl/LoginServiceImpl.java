package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.LoginService;

public class LoginServiceImpl implements LoginService {
    private static LoginServiceImpl loginServiceInstance = null;

    public static LoginService getInstance() {
        if (loginServiceInstance == null) {
            synchronized (LoginServiceImpl.class) {
                if (loginServiceInstance == null) {
                    loginServiceInstance = new LoginServiceImpl();
                }
            }
        }
        return loginServiceInstance;
    }

    @Override
    public Boolean isUserAuthed(UserAuthDto userAuthDto) {
        //todo: check across database
        String storedEmail = "a@a.com";
        String storedPassword = "1420";
        int storedId = 13;
        if (userAuthDto.getEmail().equals(storedEmail) && userAuthDto.getPassword().equals(storedPassword)) {
            userAuthDto.setId(storedId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserAuthDto getCurrentUserCredentials(int userId) {
        //todo check if exists
        String storedEmail = "a@a.com";
        String storedPassword = "1420";
        if(isUserIdExists(13)){ // if the id exists
            return new UserAuthDto(storedEmail,storedPassword,userId);
        }else {
            return null;
        }
    }

   public Boolean isUserIdExists(int userId){
        // todo: check over database
       if(userId==13){
           return true;
       }
       else {
           return false;
       }
   }


}
