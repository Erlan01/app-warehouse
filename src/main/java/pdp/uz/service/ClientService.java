package pdp.uz.service;

import pdp.uz.entity.Client;
import pdp.uz.model.ClientAddDto;
import pdp.uz.model.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto add(ClientAddDto dto);

    Client validate(Long id);

    List<Client> getAll();

    Client get(Long id);

    Client update(Long id, ClientAddDto dto);

    String delete(Long id);
}
