package com.chatterbox.repository;

import com.chatterbox.model.Channel;
import com.chatterbox.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
