package zuzex.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import zuzex.model.User;
import zuzex.repository.UserRepository;


@Component
public class UserUtils {

    @Autowired
    private UserRepository userRepository;

    //Извлечение текущего пользователя
    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        var email = authentication.getName();
        return userRepository.findByName(email).get();
    }
}