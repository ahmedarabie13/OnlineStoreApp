package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> fetchUsers();
    UserDto fetchUserByID(int id);
}
