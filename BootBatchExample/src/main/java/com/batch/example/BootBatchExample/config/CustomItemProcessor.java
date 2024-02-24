package com.batch.example.BootBatchExample.config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        // transform logic
        // calculate discount price
        // original price - discount
        int discountPer = Integer.parseInt(item.getDiscount());
        double originalPrice = Double.parseDouble(item.getPrice());
        double discount = (discountPer / 100) * originalPrice;
        double finalPrice = originalPrice - discount;
        item.setDiscountedPrice(String.valueOf(finalPrice));
        return item;
    }
}
