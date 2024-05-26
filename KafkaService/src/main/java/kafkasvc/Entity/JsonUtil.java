package kafkasvc.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    /**
     * @param message
     * @return
     */
    public static StockInfo convertToObj(String message) {
        try {
            return new ObjectMapper().readValue(message, StockInfo.class);
        } catch (JsonProcessingException e) {
            log.info("{}", e);
        }
        throw new RuntimeException();
    }

    public static String convertToString(StockInfo stockInfo) {
        try {
            return new ObjectMapper().writeValueAsString(stockInfo);
        } catch (JsonProcessingException e) {
            log.info("{}", e);
        }
        throw new RuntimeException();
    }
}
