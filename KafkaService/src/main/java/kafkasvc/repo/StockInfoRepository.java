package kafkasvc.repo;

import kafkasvc.Entity.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInfoRepository extends JpaRepository<StockInfo, Long> {
}