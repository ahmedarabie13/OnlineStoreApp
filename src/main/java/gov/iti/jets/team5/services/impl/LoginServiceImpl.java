package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.UserRepository;
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

        System.out.println("before service");
        UserAuthDto storedUser = UserRepository.getInstance().getUserAuth(userAuthDto.getEmail());
        System.out.println("after service");
        if (storedUser != null) {
            if (userAuthDto.getEmail().equals(storedUser.getEmail()) && userAuthDto.getPassword().equals(storedUser.getPassword())) {
                userAuthDto.setId(storedUser.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public UserDto getCurrentUserCredentials(int userId) {
        //todo check if exists
        return UserRepository.getInstance().getUserById(userId);
//        String storedEmail = "a@a.com";
//        String storedPassword = "1420";
//        if (isUserIdExists(13)) { // if the id exists
//            return new UserAuthDto(storedEmail, storedPassword, userId);
//        } else {
//            return null;
//        }
    }
    @Override
    public Boolean isUserIdExists(int userId) {
        return UserRepository.getInstance().isUserExist(userId);
    }


}
