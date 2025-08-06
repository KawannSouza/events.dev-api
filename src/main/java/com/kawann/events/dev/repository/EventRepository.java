package com.kawann.events.dev.repository;

import com.kawann.events.dev.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
