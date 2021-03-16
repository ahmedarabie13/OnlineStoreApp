package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserAuthDto;

public interface LoginService {
    Boolean isUserAuthed(UserAuthDto userAuthDto);
}
