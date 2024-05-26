package kafkasvc.Entity;


import kafkasvc.repo.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link StockInfo}
 */

@Component
public class MessageStore implements Serializable {

    @Autowired
    private StockInfoRepository stockInfoRepository;

    public void add(String message) {
        StockInfo stockInfo = JsonUtil.convertToObj(message);
        stockInfoRepository.save(stockInfo);
    }


    public List<StockInfo> findAll() {
        return stockInfoRepository.findAll();
    }
}