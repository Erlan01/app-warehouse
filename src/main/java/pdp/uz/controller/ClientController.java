package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.entity.Client;
import pdp.uz.model.ClientAddDto;
import pdp.uz.model.ClientDto;
import pdp.uz.model.SupplierAddDto;
import pdp.uz.model.SupplierDto;
import pdp.uz.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ClientDto add(@RequestBody ClientAddDto dto) {
        return clientService.add(dto);
    }

    @GetMapping("/getAll")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/get/{id}")
    public Client get(@PathVariable Long id){
        return clientService.get(id);
    }

    @PutMapping("/update/{id}")
    public Client update (@PathVariable Long id, @RequestBody ClientAddDto dto){
        return clientService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return clientService.delete(id);
    }
}
