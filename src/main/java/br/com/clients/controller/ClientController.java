package br.com.clients.controller;

import br.com.clients.model.Client;
import br.com.clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "API de gerenciamento de clientes")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lista todos os clientes")
    public List<Client> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo ID")
    public Client getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cria um novo cliente")
    public Client create(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um cliente existente")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return service.update(id, client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um cliente pelo ID")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
