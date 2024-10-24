package com.chatterbox.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotEmpty(message = "Content cannot be empty")
    @Column(nullable = false)
    private String content;

    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(Long messageId, Channel channel, User user, String content, LocalDateTime timestamp) {
        this.messageId = messageId;
        this.channel = channel;
        this.user = user;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public @NotEmpty(message = "Content cannot be empty") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "Content cannot be empty") String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
