package zuzex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import zuzex.dto.users.UserCreateDTO;
import zuzex.dto.users.UserDTO;
import zuzex.dto.users.UserUpdateDTO;
import zuzex.model.User;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {
    public abstract User map(UserCreateDTO dto);
    public abstract UserDTO map(User model);
    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);
}
