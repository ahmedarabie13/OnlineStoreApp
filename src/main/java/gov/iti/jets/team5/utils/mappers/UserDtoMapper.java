package gov.iti.jets.team5.utils.mappers;

import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.models.entity.UserEntity;

public class UserDtoMapper extends AbstractDtoMapper<UserDto, UserData> {

    @Override
    public UserDto getDto(UserData entity) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setPhone(entity.getPhone());
        userDto.setPassword(entity.getPassword());
        userDto.setCity(entity.getCity());
        userDto.setDateOfBirth(entity.getBirthdate().toString());
        userDto.setStreet(entity.getStreet());
        userDto.setUserRole(entity.getUserRole());
        return userDto;
    }
}
