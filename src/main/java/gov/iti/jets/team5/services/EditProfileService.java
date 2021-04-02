package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserDto;

public interface EditProfileService {
    Boolean updateUser(UserDto userDto,int userId);
    Boolean updateProfilePic(String EncodedImg);
    public UserDto getCurrentUser(int userId);
}
