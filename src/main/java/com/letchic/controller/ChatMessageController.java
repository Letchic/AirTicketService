package com.letchic.controller;

import com.letchic.model.ChatMessage;
import com.letchic.service.ChatMessageService;
import com.letchic.views.ChatMessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/chatmessage")
    @CrossOrigin(origins = "http://localhost:4200")
    public class ChatMessageController {

        @Autowired
        private ChatMessageService chatMessageService;

        @GetMapping("/findall")
        public List<ChatMessageView> findAllMessage() {
            return chatMessageService.findAllMessage();
        }

        @GetMapping("/findamessages")
        public List<ChatMessageView> findMessages(@RequestParam long userid) {
            return chatMessageService.findMessages(userid);
        }


        @PostMapping("/create")
        @ResponseStatus(value = HttpStatus.OK, reason = "Successful create message")
        public void updateTickets(@RequestBody ChatMessage chatMessage) {
            chatMessageService.createMessage(chatMessage);
        }
}
