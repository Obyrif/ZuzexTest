package zuzex.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private Integer age;

    @NotBlank
    @Size(min = 3)
    private String password;
}
