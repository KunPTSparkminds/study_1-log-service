package net.sparkminds.logservice.service;

import java.util.List;

import net.sparkminds.logservice.dto.LogResponseDto;

public interface KafkaListenerService {
    
    List<LogResponseDto> getAll();
    
//    void listener(String message);
    
    void createLog(String message);
}
