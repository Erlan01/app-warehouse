package pdp.uz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pdp.uz.entity.InputProduct;
import pdp.uz.model.resp.ExpiredProducts;
import pdp.uz.model.resp.ExpiredProductsFullInfo;
import pdp.uz.model.resp.ProductReport;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InputProductRepo extends JpaRepository<InputProduct, Long> {
    @Query(value = "select p.name as name, ip.amount as amount, ip.price as price, (ip.amount * ip.price) as totalAmount\n" +
            "from input_product ip\n" +
            "         join input i on i.id = ip.input_id\n" +
            "         join product p on ip.product_id = p.id\n" +
            "where date(i.date) = :date", nativeQuery = true)
    List<ProductReport> findAllByDate(LocalDate date);


    @Query(value = " SELECT COUNT(p) FROM input_product ip\n" +
            " join input i on i.id = ip.input_id\n" +
            " join product p on p.id = ip.product_id\n" +
            " WHERE date(ip.expire_date) < :today", nativeQuery = true)
    ExpiredProducts findAllExpiredDate(LocalDate today);

    @Query(value = " SELECT p.name as name, ip.amount as amount, ip.price as price FROM input_product ip\n" +
            " join input i on i.id = ip.input_id\n" +
            " join product p on p.id = ip.product_id\n" +
            " WHERE date(ip.expire_date) < :today", nativeQuery = true)
    List<ExpiredProductsFullInfo> findAllExpiredDateFullInfo(LocalDate today);
}
