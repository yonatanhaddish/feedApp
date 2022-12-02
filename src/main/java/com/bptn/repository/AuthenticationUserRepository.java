package com.bptn.repository;

import com.bptn.model.AuthenticationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationUserRepository extends JpaRepository<AuthenticationUser, String> {

    AuthenticationUser findAuthenticationUserByIdAndUserPassword(String id, String password);

    AuthenticationUser findAuthenticationUserById(String id);
}