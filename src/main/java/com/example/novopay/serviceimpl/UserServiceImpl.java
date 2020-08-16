package com.example.novopay.serviceimpl;

import com.example.novopay.model.User;
import com.example.novopay.repository.UserRepository;
import com.example.novopay.service.UserService;
import com.example.novopay.utils.PayResponse;
import com.example.novopay.utils.StatusEnum;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PayResponse signUp(User user) {
        Optional<User> optionalUser = userRepository.findByEmailId(user.getEmailId());
        if(optionalUser.isPresent()){
            return new PayResponse(StatusEnum.error,"User Already Exists!","User Already Exists!");
        }
        userRepository.save(user);
        return new PayResponse(StatusEnum.success,user,"User Added successfully");
    }

    @Override
    public PayResponse signIn(User user) {
        Optional<User> optionalUser = userRepository.findByEmailIdAndPassword(user.getEmailId(),user.getPassword());
        if(optionalUser.isPresent()){
            return new PayResponse(StatusEnum.success,"User Logged In!","User Logged In!");
        }
        return new PayResponse(StatusEnum.error,"User Does Not Exists!","User Does Not Exists!");
    }

    @Override
    public Optional<User> findUser(String emailId) {
        return userRepository.findByEmailId(emailId);
    }
}
