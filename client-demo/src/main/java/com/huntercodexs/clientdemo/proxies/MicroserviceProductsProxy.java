package com.huntercodexs.clientdemo.proxies;


import com.huntercodexs.clientdemo.dto.response.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server-api-gateway-demo")
public interface MicroserviceProductsProxy {

    @GetMapping(value = "/microservice-product-demo/products")
    List<ProductResponseDTO> findAll();

    @GetMapping(value = "/microservice-product-demo/products/{id}")
    ProductResponseDTO findById(@PathVariable("id") int id);

}
