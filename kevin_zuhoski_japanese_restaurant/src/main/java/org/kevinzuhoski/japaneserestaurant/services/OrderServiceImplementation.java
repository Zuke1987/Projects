package org.kevinzuhoski.japaneserestaurant.services;

import java.util.Date;
import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.MenuItem;
import org.kevinzuhoski.japaneserestaurant.models.Order;
import org.kevinzuhoski.japaneserestaurant.models.OrderMenu;
import org.kevinzuhoski.japaneserestaurant.models.Restaurant;
import org.kevinzuhoski.japaneserestaurant.models.dto.OrderDTO;
import org.kevinzuhoski.japaneserestaurant.repositories.OrderMenuRepository;
import org.kevinzuhoski.japaneserestaurant.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {
	
	private OrderRepository orderRepository;
	private OrderMenuRepository orderMenuRepository;
	
	@Autowired
	public void OrderServiceImplementation(OrderRepository orderRepository, OrderMenuRepository orderMenuRepository) {
		this.orderRepository = orderRepository;
		this.orderMenuRepository = orderMenuRepository;
	}
	
	// Method for saving an order placed with orderDTO List and Customer parameters.  

	@Override
	public boolean saveOrderMenu(List<OrderDTO> orderDTO, Customer customer) {
		
		try {
			Order order = new Order();
			order.setOrderId(0);
			order.setCustomer(customer);
			order.setDate(new Date());
			
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId(1);
			
			order.setRestaurant(restaurant);
			
			Order savedOrder = orderRepository.save(order);
			
			for (OrderDTO itemOrderDTO : orderDTO) {
				OrderMenu orderMenu = new OrderMenu();
				orderMenu.setOrder(savedOrder);
				
				MenuItem menuItem = new MenuItem();
				menuItem.setMenuItemId(itemOrderDTO.getMenuItemId());
				
				orderMenu.setMenuItem(menuItem);
				orderMenu.setQuantity(itemOrderDTO.getQuantity());
				
				orderMenuRepository.save(orderMenu);
			}	
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
