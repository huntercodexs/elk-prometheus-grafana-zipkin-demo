package com.huntercodexs.clientdemo.proxies;

import com.huntercodexs.clientdemo.dto.request.OrderRequestDTO;
import com.huntercodexs.clientdemo.dto.response.OrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server-api-gateway-demo")
public interface MicroserviceOrderProxy {

    @PostMapping(value = "/microservice-order-demo/orders")
    OrderResponseDTO addOrder(@RequestBody OrderRequestDTO order);

}
