package net.sparkminds.logservice.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.sparkminds.logservice.dto.LogResponseDto;
import net.sparkminds.logservice.entity.Log;
import net.sparkminds.logservice.repository.LogRepository;
import net.sparkminds.logservice.service.KafkaListenerService;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KafkaListenerServiceImplement implements KafkaListenerService {
    
    private final LogRepository logRepository;
    
    @Override
    @Transactional
    public void createLog(String message) {
        String cutMess = message.substring(1, message.length()-1);
        String email = cutMess.split(" ")[0];
        String ip = cutMess.split(" ")[1];
        String action = cutMess.split(" ")[2];
        
        Log log = new Log();
        log.setEmail(email);
        log.setIp(ip);  
        log.setMesseger(action);
        
        logRepository.save(log);
        
    }

    @Override
    public List<LogResponseDto> getAll() {
        
        List<LogResponseDto> logs = logRepository.findAll().stream().map(entity -> {
            LogResponseDto dto = new LogResponseDto();
            dto.setEmail(entity.getEmail());
            dto.setIp(entity.getIp());
            dto.setMesseger(entity.getMesseger());
            return dto;
        }).collect(Collectors.toList());
        
        return logs;
    }
}
