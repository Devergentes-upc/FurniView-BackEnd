package com.upc.devergentes.furniview.account.service;


import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import com.upc.devergentes.furniview.account.model.repository.UserSystemRepository;
import com.upc.devergentes.furniview.account.model.service.UserSystemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSystemServiceImpl implements UserSystemService {

    private UserSystemRepository userSystemRepository;

    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public List<UserSystem> getAllUserSystems() {
        return userSystemRepository.findAll();
    }

    @Override
    public UserSystem getUserSystemById(Long id) {
        return userSystemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserSystem not found with ID: " + id));
    }

    @Override
    public UserSystem createUserSystem(UserSystem userSystem) {
        return userSystemRepository.save(userSystem);
    }

    @Override
    public UserSystem updateUserSystem(Long id, UserSystem userSystem) {
        UserSystem existingUserSystem = getUserSystemById(id);
        existingUserSystem.setUsername(userSystem.getUsername());
        existingUserSystem.setPassword(userSystem.getPassword());
        existingUserSystem.setEmail(userSystem.getEmail());
        return userSystemRepository.save(existingUserSystem);
    }

    @Override
    public void deleteUserSystem(Long id) {
        UserSystem userSystem = getUserSystemById(id);
        userSystemRepository.delete(userSystem);
    }
}
