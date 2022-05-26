package ru.flawden.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.flawden.SocialMediaAPI.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    User findByUsername(String username);
    User findUserById(Long id);

}
