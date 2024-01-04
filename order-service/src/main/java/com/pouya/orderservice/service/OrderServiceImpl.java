package com.pouya.orderservice.service;

import com.pouya.orderservice.dto.InventoryResponse;
import com.pouya.orderservice.entities.Order;
import com.pouya.orderservice.entities.OrderLineItems;
import com.pouya.orderservice.exceptions.ExceptionsHandlerClass.CheckingCorrectnessOfResult;
import com.pouya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;

    @Override
    public void placeOrder(List<OrderLineItems> orderAsList) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItems(orderAsList);
        Stream<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode);
        InventoryResponse[] inventoryResponses = webClient.build().get().uri("http://inventory-service/api/inventory"
                        , uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class).block();


        boolean result = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        CheckingCorrectnessOfResult.availabilityOfProduct(result);

        orderRepository.save(order);
    }
}
