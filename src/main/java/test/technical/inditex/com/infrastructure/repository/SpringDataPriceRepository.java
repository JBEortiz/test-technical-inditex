package test.technical.inditex.com.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.technical.inditex.com.infrastructure.entity.PriceEntity;

import java.sql.Timestamp;
import java.util.List;

public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query(value = "SELECT * FROM PRICES p WHERE p.product_id = :productId AND "
            + "p.brand_id = :brandId AND :dateApplication BETWEEN p.start_date AND p.end_date", nativeQuery = true)
    List<PriceEntity> findPricesByProductIdAndBrandIdAndDate(@Param("productId") Integer productId, @Param("brandId") Integer brandId, @Param("dateApplication") Timestamp dateApplication);
}