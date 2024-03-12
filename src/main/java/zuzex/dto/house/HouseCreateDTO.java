package zuzex.dto.house;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseCreateDTO {

    private Long id;

    @NotBlank
    private String address;
}
