package zuzex.сontroller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zuzex.dto.house.HouseCreateDTO;
import zuzex.dto.house.HouseDTO;
import zuzex.exception.ResourceNotFoundException;
import zuzex.mapper.HouseMapper;
import zuzex.repository.HouseRepository;
import zuzex.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private HouseMapper houseMapper;

    @GetMapping("/house")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HouseDTO>> getUHouse() {
        var house = houseRepository.findAll();
        var houses = house.stream()
                .map(p -> houseMapper.map(p))
                .toList();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(houses.size()))
                .body(houses);
    }

    @PostMapping("/house")
    @ResponseStatus(HttpStatus.CREATED)
    public HouseDTO createHouse(@Valid @RequestBody HouseCreateDTO houseDto) {
        var newHouse = houseMapper.map(houseDto);
        houseRepository.save(newHouse);
        return houseMapper.map(newHouse);
    }

    @PostMapping("/house/{houseId}/users")
    @ResponseStatus(HttpStatus.CREATED)
    public HouseDTO addToHouse(@PathVariable Long houseId, @Valid @RequestBody HouseCreateDTO houseDto) {
        var house = houseRepository.findById(houseId)
                .orElseThrow(() -> new ResourceNotFoundException("House not found with id: " + houseId));

        var newUser = userRepository.findById(houseDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + houseDto.getId()));

        house.getResidents().add(newUser);
        houseRepository.save(house);
        return houseMapper.map(house);
    }

    @DeleteMapping("/house/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        houseRepository.deleteById(id);
    }
}