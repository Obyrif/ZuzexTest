package zuzex.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import zuzex.dto.house.HouseCreateDTO;
import zuzex.dto.house.HouseDTO;
import zuzex.dto.house.HouseUpdateDTO;
import zuzex.model.House;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T19:39:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class HouseMapperImpl extends HouseMapper {

    @Override
    public House map(HouseCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        House house = new House();

        return house;
    }

    @Override
    public HouseDTO map(House model) {
        if ( model == null ) {
            return null;
        }

        HouseDTO houseDTO = new HouseDTO();

        return houseDTO;
    }

    @Override
    public void update(HouseUpdateDTO dto, House model) {
        if ( dto == null ) {
            return;
        }
    }
}
