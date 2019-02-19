package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    /*
    Constructor
     */

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    /*
    save user in db
     */

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {

        if(userRepository.existsById(user.getEmail())){
            throw new UserAlreadyExistsException("user already exists");
        }

        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
