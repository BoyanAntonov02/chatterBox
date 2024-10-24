package com.chatterbox.service;

import com.chatterbox.model.Message;
import com.chatterbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Create a new message
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    // Get message by ID
    public Message getMessage(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null);
    }

//    // Get all messages in a channel
//    public List<Message> getMessagesByChannel(Long channelId) {
//        // You can create a custom query method in MessageRepository for this
//        return messageRepository.findAllByChannelId(channelId); // Assuming you define this method
//    }

    // Update an existing message
    public Message updateMessage(Long id, Message messageDetails) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message != null) {
            message.setContent(messageDetails.getContent());
            return messageRepository.save(message);
        }
        return null;
    }

    // Delete a message by ID
    public boolean deleteMessage(Long id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
