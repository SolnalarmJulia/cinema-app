package spring.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.dto.request.UserRequestDto;
import spring.dto.response.UserResponseDto;
import spring.model.Role;
import spring.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRequestDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setRoleIds(user.getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet()));
        return responseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getEmail());
        return user;
    }
}
