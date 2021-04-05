package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.UserRepository;
import gov.iti.jets.team5.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceInstance;
    private UserRepository userRepository = UserRepository.getInstance();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserServiceImpl();
        }
        return userServiceInstance;
    }

    @Override
    public List<UserDto> fetchUsers() {
        return userRepository.fetchAllUsers();
    }

    @Override
    public UserDto fetchUserByID(int id) {
        return userRepository.getUserById(id);
    }
}
