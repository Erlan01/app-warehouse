package pdp.uz.service;

import pdp.uz.entity.User;
import pdp.uz.model.UserAddDto;
import pdp.uz.model.UserDto;
import pdp.uz.model.resp.UserReport;

import java.util.List;

public interface UserService {

    UserDto add(UserAddDto dto);

    List<User> getAll();

    User get(Long id);

    List<UserReport> getByWarehouse(Long warehouseId);

    User update(Long id, UserAddDto dto);

    String delete(Long id);
}
