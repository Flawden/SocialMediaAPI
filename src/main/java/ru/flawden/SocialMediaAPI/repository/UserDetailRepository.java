package ru.flawden.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findUserDetailById(Long id);

}
