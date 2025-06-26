package net.sai.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sai.entity.User;
import net.sai.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

//    public User updateUser(ObjectId id, User updatedUser) {
//        return userRepo.findById(id).map(existing -> {
//            String username = updatedUser.getUsername();
//            String password = updatedUser.getPassword();
//
//            if (username != null && !username.trim().isEmpty()) {
//                existing.setUsername(username.trim());
//            }
//
//            if (password != null && !password.trim().isEmpty()) {
//                existing.setPassword(password.trim());
//            }
//
//            return userRepo.save(existing);
//        }).orElse(null);
//    }


    public boolean delete(ObjectId id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
