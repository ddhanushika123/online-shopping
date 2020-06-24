package net.dd.shoppingbackend.dao;

import java.util.List;

import net.dd.shoppingbackend.dto.Cart;
import net.dd.shoppingbackend.dto.CartLine;
//import net.dd.shoppingbackend.dto.OrderDetail;

public interface CartLineDAO {
    
	//common methods from previously coded one
	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	
	
	//other business methode related to the cart line
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	
	// updating the cart
	boolean updateCart(Cart cart);

	
/*	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	

	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);
*/
	
}