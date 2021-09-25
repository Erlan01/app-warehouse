package pdp.uz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pdp.uz.entity.OutputProduct;
import pdp.uz.model.resp.OutputProductReport;
import pdp.uz.model.resp.ProductReport;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OutputProductRepo extends JpaRepository<OutputProduct, Long> {

    @Query(nativeQuery = true, value = " with t as (select p.name as name, op.amount as amount from output_product op\n" +
            "join output o on o.id = op.output_id\n" +
            "join product p on p.id = op.product_id\n" +
            "where date(o.date) = :today)\n" +
            "select t.name as name from t order by t.amount desc limit 1;")
    OutputProductReport findAllByDate(LocalDate today);
}
