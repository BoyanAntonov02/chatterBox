package com.chatterbox.controller;

import com.chatterbox.model.Channel;
import com.chatterbox.service.ChannelService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {

    ChannelService channelService;

    // Display form to create a new channel
    @GetMapping("/create-channel")
    public String showCreateChannelForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("channel", new Channel());
        // You can also retrieve the currently logged-in user details here (userDetails)
        return "create_channel"; // View name
    }

    // Handle form submission and save the channel
    @PostMapping("/create-channel")
    public String createChannel(@ModelAttribute("channel") Channel channel) {
        channelService.createChannel(channel);
        return "redirect:/channels"; // Redirect to a list or success page
    }

    // Optional: Display list of channels
    @GetMapping("/channels")
    public String getAllChannels(Model model) {
        model.addAttribute("channels", channelService.getAllChannels());
        return "channel_list"; // View name for list of channels
    }
}
