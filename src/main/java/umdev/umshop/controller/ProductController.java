package umdev.umshop.controller;

import umdev.umshop.domain.Cate;
import umdev.umshop.domain.Product;
import umdev.umshop.dto.ProductDto;
import umdev.umshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String listProduct(Model model){
        ProductDto productDto = new ProductDto();

        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);
        return "products/productList";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "products/addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(ProductDto productDto){

        System.out.println("productDto ==>>>>>" + productDto);

        Product product = new Product();
        Cate cate = new Cate();

        cate.setId(productDto.getCateId());

        product.setName(productDto.getProductName());
        product.setStock(productDto.getStock());


        productService.saveProduct(product);
        return "redirect:/";
    }

}
