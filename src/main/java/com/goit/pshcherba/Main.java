package com.goit.pshcherba;

import com.goit.pshcherba.domain.Client;
import com.goit.pshcherba.domain.Planet;
import com.goit.pshcherba.domain.Ticket;
import com.goit.pshcherba.service.ClientCrudService;
import com.goit.pshcherba.service.PlanetCrudService;
import com.goit.pshcherba.service.TicketCrudService;

import java.util.List;

/**
 * The {@link Main} class is the entry point of the application.
 * It demonstrates the CRUD (Create, Read, Update, Delete) operations
 * for {@link Client}, {@link Planet}, and {@link Ticket} entities using the respective
 * service classes:
 * {@link ClientCrudService}, {@link PlanetCrudService}, and {@link TicketCrudService}.
 * <p>
 * The {@link Main} class is used to test the basic functionality of interacting
 * with the database for both {@link Client}, {@link Planet}, and {@link Ticket} entities.
 * It performs operations like:
 * <ul>
 *   <li>Finding entities by ID</li>
 *   <li>Retrieving a range of entities</li>
 *   <li>Saving new entities</li>
 *   <li>Updating existing entities</li>
 *   <li>Deleting entities</li>
 * </ul>
 *
 * @see com.goit.pshcherba.service.ClientCrudService
 * @see com.goit.pshcherba.service.PlanetCrudService
 * @see com.goit.pshcherba.service.TicketCrudService
 * @see com.goit.pshcherba.domain.Client
 * @see com.goit.pshcherba.domain.Planet
 * @see com.goit.pshcherba.domain.Ticket
 */
public class Main {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        // Find client by id
        int clientId = 5;
        Client client = clientCrudService.findById(clientId);
        System.out.println("Find client by id = " + clientId);
        System.out.println(client);

        // Get items clients
        int offset = 1;
        int count = 4;
        List<Client> clients = clientCrudService.getItems(offset, count);
        System.out.println("Clients. Get items. Offset " + offset + ". Count = " + count);
        clients.forEach(System.out::println);

        // Find all clients
        List<Client> allClients = clientCrudService.findlAll();
        allClients.forEach(System.out::println);

        // Find client
        Client savedClient = clientCrudService.save(Client.builder().name("Chris Rock").build());
        System.out.println("Client saved: " + savedClient);

        // Update client
        savedClient.setName("Criss Pratt");
        clientCrudService.update(savedClient);
        System.out.println("Updated client " + savedClient);

        // Delete client
        Client deletedClient = clientCrudService.findById(savedClient.getId());
        clientCrudService.delete(deletedClient);
        System.out.println("Deleted client: " + deletedClient);

        // Find planet by id
        int planetId = 3;
        Planet planet = planetCrudService.findById(planetId);
        System.out.println("Find planet by id = " + planetId);
        System.out.println(planet);

        // Get items planets
        List<Planet> planets = planetCrudService.getItems(offset, count);
        System.out.println("Planets. Get items. Offset " + offset + ". Count = " + count);
        planets.forEach(System.out::println);

        // Find all planets
        List<Planet> allPlanets = planetCrudService.findlAll();
        allPlanets.forEach(System.out::println);

        // Save planet
        Planet savedPlanet = planetCrudService.save(Planet.builder().id("PLNT6").name("Neptune").build());
        System.out.println("Planet saved: " + savedPlanet);

        // Update planet
        savedPlanet.setName("Uranus");
        planetCrudService.update(savedPlanet);
        System.out.println("Updated planet: " + savedPlanet);

        // Delete planet
        Planet deletedPlanet = planetCrudService.findById(savedPlanet.getId());
        planetCrudService.delete(deletedPlanet);
        System.out.println("Deleted planet: " + deletedPlanet);


        // Create Ticket with associated Client and Planets
        Ticket newTicket = Ticket.builder()
                .client(clientCrudService.findById(1))
                .fromPlanet(savedPlanet)
                .toPlanet(savedPlanet)
                .build();

        // Save ticket
        Ticket savedTicket = ticketCrudService.save(newTicket);
        System.out.println("Ticket saved: " + savedTicket);

        // Find ticket by id
        Ticket foundTicket = ticketCrudService.findById(savedTicket.getId());
        System.out.println("Find ticket by id = " + savedTicket.getId());
        System.out.println(foundTicket);

        // Get items tickets
        List<Ticket> tickets = ticketCrudService.getItems(offset, count);
        System.out.println("Tickets. Get items. Offset " + offset + ". Count = " + count);
        tickets.forEach(System.out::println);

        // Find all tickets
        List<Ticket> allTickets = ticketCrudService.findlAll();
        allTickets.forEach(System.out::println);

        // Update ticket
        savedTicket.setFromPlanet(planetCrudService.findById("PLNT6"));
        savedTicket.setToPlanet(planetCrudService.findById("PLNT6"));
        ticketCrudService.update(savedTicket);
        System.out.println("Updated ticket: " + savedTicket);

        // Delete ticket
        Ticket deletedTicket = ticketCrudService.findById(savedTicket.getId());
        ticketCrudService.delete(deletedTicket);
        System.out.println("Deleted ticket: " + deletedTicket);
    }
}
