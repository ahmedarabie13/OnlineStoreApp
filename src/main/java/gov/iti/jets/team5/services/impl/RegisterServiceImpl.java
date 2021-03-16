package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private static RegisterServiceImpl registerServiceInstance = null;

    public static RegisterService getInstance() {
        if (registerServiceInstance == null) {
            registerServiceInstance = new RegisterServiceImpl();
        }
        return registerServiceInstance;
    }

    @Override
    public Boolean isRegistered(UserAuthDto userAuthDto) {
        return null;
    }

    @Override
    public Boolean registerUser(UserAuthDto userAuthDto) {
        //todo go and register the user in the db
        //todo either to send the object itself or the attributes in it? according to hibernate
        return true;
    }
}
