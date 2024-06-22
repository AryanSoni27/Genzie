package com.genzie.genzie_backend.services;

import com.genzie.genzie_backend.model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScrapingService {

    public List<Product> fetchProductsFromAmazon() throws IOException {
        List<Product> products = new ArrayList<>();
        String url = "https://www.amazon.in/s?k=products"; // Example URL, update it accordingly
        Document doc = Jsoup.connect(url).get();
        Elements productElements = doc.select(".s-main-slot .s-result-item");

        for (var element : productElements) {
            String name = element.select(".a-size-medium").text();
            String priceString = element.select(".a-price-whole").text().replace(",", "");
            double price = priceString.isEmpty() ? 0.0 : Double.parseDouble(priceString);
            String description = element.select(".a-text-normal").text();
            String brand = element.select(".s-line-clamp-1").text();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setBrand(brand);

            products.add(product);
        }

        return products;
    }

    // Similarly, create methods for Flipkart, Meesho, Ajio, eBay
}
