package pdp.uz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pdp.uz.entity.User;
import pdp.uz.entity.Warehouse;
import pdp.uz.model.resp.UserReport;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findAllByActiveTrue();

    Optional<User> findByIdAndActiveTrue(Long id);

    @Query(value = "select u.id as id, u.first_name as firstName, u.last_name as lastName,\n" +
            "       u.phone_number as phoneNumber, u.code as code, u.password as password,\n" +
            "       w.id as warehouseId, w.name as warehouseName\n" +
            "from users u\n" +
            "join user_warehouse uw on u.id = uw.user_id\n" +
            "join warehouse w on w.id = uw.warehouse_id\n" +
            "where w.id = 1 and u.active = true", nativeQuery = true)
    List<UserReport> findAllByWarehousesIdAndActiveTrue(Long warehouses_id);


}
