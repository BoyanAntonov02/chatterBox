package com.chatterbox.service;

import com.chatterbox.model.Channel;
import com.chatterbox.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    // Create a new channel
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    // Get channel by ID
    public Channel getChannel(Long id) {
        Optional<Channel> channel = channelRepository.findById(id);
        return channel.orElse(null);
    }

    // Get all channels
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    // Update an existing channel
    public Channel updateChannel(Long id, Channel channelDetails) {
        Channel channel = channelRepository.findById(id).orElse(null);
        if (channel != null) {
            channel.setChannelName(channelDetails.getChannelName());
            channel.setChannelCode(channelDetails.getChannelCode());
            return channelRepository.save(channel);
        }
        return null;
    }

    // Delete a channel by ID
    public boolean deleteChannel(Long id) {
        if (channelRepository.existsById(id)) {
            channelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
