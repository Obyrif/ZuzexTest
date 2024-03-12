package zuzex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import zuzex.dto.house.HouseCreateDTO;
import zuzex.dto.house.HouseDTO;
import zuzex.dto.house.HouseUpdateDTO;
import zuzex.model.House;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class HouseMapper {
    public abstract House map(HouseCreateDTO dto);
    public abstract HouseDTO map(House model);
    public abstract void update(HouseUpdateDTO dto, @MappingTarget House model);
}
