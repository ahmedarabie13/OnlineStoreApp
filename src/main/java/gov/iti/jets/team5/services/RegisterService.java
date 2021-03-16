package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserAuthDto;

public interface RegisterService {
    //todo ask if we need to check it?
    Boolean isRegistered(UserAuthDto userAuthDto);
    Boolean registerUser(UserAuthDto userAuthDto);
}
