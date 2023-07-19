package com.greatlearning.TicketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.TicketTracker.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	 List<Ticket> findByTitleContainingIgnoreCase(String keyword);
}
