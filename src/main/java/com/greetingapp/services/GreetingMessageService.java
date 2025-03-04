package com.greetingapp.services;
import com.greetingapp.dto.GreetingMessageDTO;
import com.greetingapp.entities.GreetingMessageEntity;
import com.greetingapp.repositories.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingMessageService {

    final ModelMapper modelMapper;
    final GreetingRepository greetingRepository;

    public GreetingMessageService(ModelMapper modelMapper, GreetingRepository greetingRepository) {
        this.modelMapper = modelMapper;
        this.greetingRepository = greetingRepository;
    }

    public GreetingMessageDTO createMessage(GreetingMessageDTO greetingMessageDTO){
        GreetingMessageEntity greetingMessageEntity = modelMapper.map(greetingMessageDTO , GreetingMessageEntity.class);
        return modelMapper.map(greetingRepository.save(greetingMessageEntity),GreetingMessageDTO.class);
    }

    public List<GreetingMessageDTO> getAllMessages() {

        return greetingRepository
                .findAll()
                .stream()
                .map(greetingMessageEntity -> modelMapper.map(greetingMessageEntity, GreetingMessageDTO.class))
                .collect(Collectors.toList());
    }
    public String getMessageById(Integer id) {
        GreetingMessageEntity greetingMessageEntity =  greetingRepository.findById(id).orElse(null);
        if(greetingMessageEntity == null) return "No Messages";
        return greetingMessageEntity.getMessage();
    }
    public List<String> getAllMessage() {
        return greetingRepository
                .findAll()
                .stream()
                .map(greetingMessageEntity -> greetingMessageEntity.getMessage())
                .collect(Collectors.toList());
    }

}