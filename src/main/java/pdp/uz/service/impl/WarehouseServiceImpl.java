package pdp.uz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.entity.Warehouse;
import pdp.uz.helpers.MapstructMapper;
import pdp.uz.helpers.Utils;
import pdp.uz.model.WarehouseAddDto;
import pdp.uz.model.WarehouseDto;
import pdp.uz.repository.WarehouseRepo;
import pdp.uz.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepo warehouseRepo;
    private final MapstructMapper mapstructMapper;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepo warehouseRepo, MapstructMapper mapstructMapper) {
        this.warehouseRepo = warehouseRepo;
        this.mapstructMapper = mapstructMapper;
    }

    @Override
    public List<WarehouseDto> getList() {
        List<Warehouse> list = warehouseRepo.findAllByActiveTrue();
        return mapstructMapper.toWarehouseDto(list);
    }

    @Override
    public WarehouseDto add(WarehouseAddDto dto) {
        String name = dto.getName();
        if (Utils.isEmpty(name)) {
            throw new RuntimeException("Warehouse name should not be null!");
        } else {
            Optional<Warehouse> warehouseOpt = warehouseRepo.findByName(name);
            if (warehouseOpt.isPresent()) {
                throw new RuntimeException("This name is already exist!");
            }
        }
        Warehouse warehouse = mapstructMapper.toWarehouse(dto);

        Warehouse savedWarehouse = warehouseRepo.save(warehouse);

        return mapstructMapper.toWarehouseDto(savedWarehouse);
    }

    @Override
    public boolean active(Warehouse warehouse) {
        if (Utils.isEmpty(warehouse)) {
            return false;
        }
        return warehouse.getActive();
    }

    public Warehouse validate(Long id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepo.findById(id);
        if (!optionalWarehouse.isPresent()) {
            throw new RuntimeException("Warehouse id = " + id + ", not found!");
        }
        Warehouse warehouse = optionalWarehouse.get();
        if (!warehouse.getActive()) {
            throw new RuntimeException("Category id = " + id + ", is inactive!");
        }
        return warehouse;
    }
}
