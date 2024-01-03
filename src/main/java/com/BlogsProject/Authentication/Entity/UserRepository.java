package com.BlogsProject.Authentication.Entity;

import com.BlogsProject.Functions.Entity.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByEmail(String email);

    @Query("SELECT U FROM userAccount U WHERE (U.firstname ILIKE :debut%) OR (U.lastname ILIKE :debut%)")
    Page<User> findUserByNameDebut(@Param("debut") String debut, Pageable pageable);

    @Query("SELECT U FROM userAccount U ")
    Page<User> findAll(Pageable pageable);

    @Query("SELECT U FROM userAccount U WHERE U.uid = :uid")
    User findByUid(@Param("uid") String uid);
}
