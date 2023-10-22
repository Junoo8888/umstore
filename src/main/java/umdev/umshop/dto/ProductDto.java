package umdev.umshop.dto;


import umdev.umshop.domain.Product;
import lombok.Data;

@Data
public class ProductDto {

    ///Field
    private Long productId;
    private String productName;
    private int price;
    private int stock;
    private Long cateId;

    ///Constructor
    public ProductDto(){
    }

    public ProductDto(Product product){
        productId = product.getId();
        productName = product.getName();
        price = product.getPrice();
        stock = product.getStock();

    }
}
