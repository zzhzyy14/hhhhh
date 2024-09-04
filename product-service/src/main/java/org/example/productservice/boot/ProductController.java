package org.example.productservice.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 缪嘉成
 */
@RestController
public class ProductController {
    @GetMapping("/product")
    public String getProduct(@RequestParam String productId) {

        return "product" + productId;
    }
}
