package ru.flawden.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.flawden.SocialMediaAPI.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {


    Optional<User> findByUsername(String username);

    //User findUserById(Long id); //Лишний, он уже есть

}
