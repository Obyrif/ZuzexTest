package zuzex.сontroller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuzex.dto.users.UserCreateDTO;
import zuzex.dto.users.UserDTO;
import zuzex.dto.users.UserUpdateDTO;
import zuzex.exception.ResourceNotFoundException;
import zuzex.mapper.UserMapper;
import zuzex.repository.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserMapper userMapper;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getUsers() {
        var users = userRepository.findAll();
        var user = users.stream()
                .map(p -> userMapper.map(p))
                .toList();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(user.size()))
                .body(user);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO dto) {
        var user = userMapper.map(dto);
        userRepository.save(user);
        return userMapper.map(user);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@Valid @RequestBody UserUpdateDTO dto, @PathVariable Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userMapper.update(dto, user);
        userRepository.save(user);
        return userMapper.map(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
