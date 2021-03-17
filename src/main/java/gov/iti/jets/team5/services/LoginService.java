package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserDto;

public interface LoginService {
    Boolean isUserAuthed(UserDto userDto);
}
