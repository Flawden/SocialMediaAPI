package ru.flawden.SocialMediaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.flawden.SocialMediaAPI.entity.Message;
import ru.flawden.SocialMediaAPI.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("FROM Message where author_id=?1")
    List<Message> findByAuthorid(Long id);

}
