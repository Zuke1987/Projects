package org.kevinzuhoski.japaneserestaurant.services;

import java.util.List;

import org.kevinzuhoski.japaneserestaurant.models.Customer;
import org.kevinzuhoski.japaneserestaurant.models.dto.OrderDTO;

public interface OrderService {
	public boolean saveOrderMenu(List<OrderDTO> order, Customer customer);
}
