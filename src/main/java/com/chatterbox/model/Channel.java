package com.chatterbox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


import java.time.LocalDateTime;

@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Channel name cannot be empty")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Channel code cannot be empty")
    @Column(unique = true, nullable = false)
    private String code;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    public Channel() {
    }

    public Channel(Long channelId, String channelName, String channelCode, LocalDateTime createdAt, User createdBy) {
        this.Id = channelId;
        this.name = channelName;
        this.code = channelCode;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Long getChannelId() {
        return Id;
    }

    public void setChannelId(Long channelId) {
        this.Id = channelId;
    }

    public @NotEmpty(message = "Channel name cannot be empty") String getChannelName() {
        return name;
    }

    public void setChannelName(@NotEmpty(message = "Channel name cannot be empty") String channelName) {
        this.name = channelName;
    }

    public @NotEmpty(message = "Channel code cannot be empty") String getChannelCode() {
        return code;
    }

    public void setChannelCode(@NotEmpty(message = "Channel code cannot be empty") String channelCode) {
        this.code = channelCode;
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

