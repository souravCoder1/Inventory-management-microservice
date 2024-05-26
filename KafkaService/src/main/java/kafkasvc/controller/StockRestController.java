package kafkasvc.controller;

import kafkasvc.Entity.JsonUtil;
import kafkasvc.Entity.MessageStore;
import kafkasvc.Entity.StockInfo;
import kafkasvc.Producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class StockRestController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private MessageStore messageStore;
    @PostMapping("/send")
    public String readMessage(@RequestParam String code, @RequestParam Double cost) {
        StockInfo stockInfo = StockInfo.builder()
                .stockcode(code)
                .stockcost(cost).build();

        String si = JsonUtil.convertToString(stockInfo);

        producerService.sendMessage(si);

        return "SENT";
    }

    @GetMapping("/all")
    public List<StockInfo> fetchAll() {
        return messageStore.findAll();
    }
}
