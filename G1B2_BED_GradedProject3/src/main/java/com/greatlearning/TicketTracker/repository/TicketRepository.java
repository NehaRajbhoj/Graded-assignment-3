package com.greatlearning.TicketTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.TicketTracker.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
