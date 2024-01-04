package com.pouya.inventoryservice;

import com.pouya.inventoryservice.entities.Inventory;
import com.pouya.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner localData (InventoryRepository inventoryRepository)
	{
		return  args -> {
			Inventory inventory = new Inventory() ;
			inventory.setQuantity(100);
			inventory.setSkuCode(UUID.randomUUID().toString());
			inventoryRepository.save(inventory) ;


			Inventory inventory1 = new Inventory() ;
			inventory1.setQuantity(0);
			inventory1.setSkuCode(UUID.randomUUID().toString());
			inventoryRepository.save(inventory1) ;

		} ;
	}

}
