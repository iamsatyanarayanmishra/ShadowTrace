package com.kristellar.shadow_trace.backend.services;

import java.util.List;
import java.util.Optional;
import com.kristellar.shadow_trace.backend.entities.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExit(String email);
    List<User> getAllUser();
}
