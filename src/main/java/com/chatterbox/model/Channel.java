package com.chatterbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


import java.time.LocalDateTime;

@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelId;

    @NotEmpty(message = "Channel name cannot be empty")
    @Column(nullable = false)
    private String channelName;

    @NotEmpty(message = "Channel code cannot be empty")
    @Column(unique = true, nullable = false)
    private String channelCode;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    public Channel() {
    }

    public Channel(Long channelId, String channelName, String channelCode, LocalDateTime createdAt, User createdBy) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelCode = channelCode;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public @NotEmpty(message = "Channel name cannot be empty") String getChannelName() {
        return channelName;
    }

    public void setChannelName(@NotEmpty(message = "Channel name cannot be empty") String channelName) {
        this.channelName = channelName;
    }

    public @NotEmpty(message = "Channel code cannot be empty") String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(@NotEmpty(message = "Channel code cannot be empty") String channelCode) {
        this.channelCode = channelCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}

