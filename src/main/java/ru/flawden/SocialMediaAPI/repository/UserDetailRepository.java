package ru.flawden.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.entity.UserInfo;

public interface UserDetailRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findUserDetailById(Long id);

}
