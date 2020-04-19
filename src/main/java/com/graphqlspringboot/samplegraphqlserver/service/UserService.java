package com.graphqlspringboot.samplegraphqlserver.service;

import com.graphqlspringboot.samplegraphqlserver.model.User;
import com.graphqlspringboot.samplegraphqlserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUser(String userName, String password) throws RuntimeException {
        Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("Invalid user credentials");
    }
}
