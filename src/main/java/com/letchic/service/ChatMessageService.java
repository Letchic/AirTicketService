package com.letchic.service;

import com.letchic.model.ChatMessage;
import com.letchic.repository.ChatMessageRepository;
import com.letchic.views.ChatMessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessageView> findAllMessage() {
        return chatMessageRepository.findAllMessage();
    }
    public List<ChatMessageView> findMessages(long userid) {
        return chatMessageRepository.findMessages(userid);
    }

    public void createMessage(ChatMessage chatmessage) {
        chatMessageRepository.save(chatmessage);
    }
}
