package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.EditProfileService;


public class EditProfileServiceImpl implements EditProfileService {
    private static EditProfileServiceImpl editProfileServiceInstance = null;

    public static EditProfileService getInstance() {
        if (editProfileServiceInstance == null) {
            synchronized (EditProfileServiceImpl.class) {
                if (editProfileServiceInstance == null) {
                    editProfileServiceInstance = new EditProfileServiceImpl();
                }
            }
        }
        return editProfileServiceInstance;
    }

    @Override
    public Boolean updateUser(UserDto userDto) {
        // todo update the user in the db

        return true;
    }

    @Override
    public Boolean updateProfilePic(String EncodedImg) {
        return null;
    }
}

