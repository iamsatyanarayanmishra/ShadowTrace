package com.kristellar.shadow_trace.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kristellar.shadow_trace.backend.entities.User;
import com.kristellar.shadow_trace.backend.helpers.AppConstants;
import com.kristellar.shadow_trace.backend.helpers.ResourceNotFoundException;
import com.kristellar.shadow_trace.backend.repositories.UserRepository;
import com.kristellar.shadow_trace.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setAddress(user.getAddress());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(List.of(AppConstants.ROLE_USER));  
        logger.info(user.getProvider().toString());
        return userRepo.save(user);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findByEmail(user.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user2.setName(user.getName());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setAbout(user.getAbout());
        user2.setPassword(user.getPassword());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setProvider(user.getProvider());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProviderUserId(user.getProviderUserId());
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String email) {
        User user2 = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExit(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("Uaser not found."));
    }
}
