package umdev.umshop.dto;

import lombok.Data;

@Data
public class CartDto {

    ///Field
    private Long id;
    private int quantity;

    ///Constructor
    public CartDto(){
    }
}
