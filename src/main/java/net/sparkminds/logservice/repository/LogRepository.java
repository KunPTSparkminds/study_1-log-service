package net.sparkminds.logservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.logservice.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
