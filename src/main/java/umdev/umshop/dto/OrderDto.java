package umdev.umshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class OrderDto {

    private Long id;
    private String name;
    private LocalDateTime orderDate;

}
