package com.greatlearning.TicketTracker.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.TicketTracker.model.Ticket;
import com.greatlearning.TicketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Ticket addTicket(Ticket ticket) {
		Date newDate = new Date();
		String formatedDate = dateFormat.format(newDate);
		ticket.setCreated_date(formatedDate);
		return ticketRepository.save(ticket);
	}


	@Override
	public Ticket getTicket(long ticketId) {

		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public List<Ticket> getAllTickets() {

		return ticketRepository.findAll();
	}

	@Override
	public void deleteTicket(long ticketId) {
		ticketRepository.deleteById(ticketId);

	}

	@Override
	public List<Ticket> searchByKeyword(String keyword) {
		
		return ticketRepository.findByTitleContainingIgnoreCase(keyword);
	}

	@Override
	public Ticket editTicket(long ticketId, Ticket ticket) {

		// creating Edited date
		Date editDate = new Date();
		String updateDate = dateFormat.format(editDate);

		Ticket ticket_db = getTicket(ticketId);
		ticket_db.setTitle(ticket.getTitle());
		ticket_db.setDescription(ticket.getDescription());
		ticket_db.setContent(ticket.getContent());
		ticket_db.setEdited_date(updateDate);

		return ticketRepository.save(ticket_db);
	}
}
