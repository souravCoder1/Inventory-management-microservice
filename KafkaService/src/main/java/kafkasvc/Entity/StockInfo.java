package kafkasvc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long stockid;

    @Column(name = "scode")
    private String stockcode;

    @Column(name = "scost")
    private Double stockcost;

}
