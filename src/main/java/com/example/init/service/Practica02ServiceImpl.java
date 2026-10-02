package com.example.init.service;

import com.example.init.model.RespuestaDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Service
public class Practica02ServiceImpl implements Practica02Service {

    private ChatClient chatClient;

    @Value("${text.system}")
    private String system;

    @Value("${text.user}")
    private String user;

    public Practica02ServiceImpl(ChatClient chatClient) {
        super();
        this.chatClient = chatClient;
    }

    public List<RespuestaDTO> obtenerIDEs(String tecnologia) {
        var systemTemplate = new PromptTemplate(system);
        var userTemplate = new PromptTemplate(user);
        var prompt = new Prompt(systemTemplate.createMessage(), userTemplate.createMessage(Map.of("tecnologia", tecnologia)));

        return List.of(chatClient.prompt(prompt).call().entity(RespuestaDTO[].class));
    }

}
