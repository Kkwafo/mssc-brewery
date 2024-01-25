package kokwabeerframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableDto {
    private UUID id;
    private int orderNumber;
   /* private List<item> items;
   * */
    private double total;
}
