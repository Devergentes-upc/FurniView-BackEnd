package com.upc.devergentes.furniview.account.model.repository;

import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository  extends JpaRepository<UserSystem, Long> {

    UserSystem findByUsername(String username);
}
