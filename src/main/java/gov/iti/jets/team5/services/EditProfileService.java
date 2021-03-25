package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserDto;

public interface EditProfileService {
    Boolean updateUser(UserDto userDto);
    Boolean updateProfilePic(String EncodedImg);
}
