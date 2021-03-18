package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserDto;

public interface RegisterService {
    //todo ask if we need to check it?
    Boolean isRegistered(String email);
    Boolean registerUser(UserDto userDto);
}
