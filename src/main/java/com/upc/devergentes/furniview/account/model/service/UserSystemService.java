package com.upc.devergentes.furniview.account.model.service;

import com.upc.devergentes.furniview.account.model.domain.UserSystem;

import java.util.List;

public interface UserSystemService {

    List<UserSystem> getAllUserSystems();

    UserSystem getUserSystemById(Long id);

    UserSystem createUserSystem(UserSystem userSystem);

    UserSystem updateUserSystem(Long id, UserSystem userSystem);

    void deleteUserSystem(Long id);
}
