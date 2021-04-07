package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.ProfileRepository;
import gov.iti.jets.team5.services.EditProfileService;


public class EditProfileServiceImpl implements EditProfileService {
    private static EditProfileServiceImpl editProfileServiceInstance = null;
    ProfileRepository profileRepository = ProfileRepository.getInstance();

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
    public Boolean updateUser(UserDto userDto,int userId) {
        boolean isUpdated = profileRepository.updateUser(userDto,userId);
        if (isUpdated) {

            System.out.println("from edit service impl");
            return true;
        } else {
            System.out.println("from edit service impl false");
            return false;
        }
    }

    @Override
    public Boolean updateProfilePic(String EncodedImg) {
        return null;
    }

    @Override
    public UserDto getCurrentUser(int userId) {
        UserDto userDto = profileRepository.getCurrentUser(userId);
        return userDto;
    }
}

