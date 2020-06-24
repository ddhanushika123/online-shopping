package net.dd.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dd.shoppingbackend.dao.CartLineDAO;
import net.dd.shoppingbackend.dao.ProductDAO;
import net.dd.shoppingbackend.dao.UserDAO;
import net.dd.shoppingbackend.dto.Cart;
import net.dd.shoppingbackend.dto.CartLine;
import net.dd.shoppingbackend.dto.Product;
import net.dd.shoppingbackend.dto.User;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.dd.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		
	}
	
	@Test
	public void testAddNewCartLine() {
		
		//1.get the user
		user = userDAO.getByEmail("c@gmail.com");
		
		//2.fetch the cart
		cart = user.getCart();
		
		//3.get the product
		product = productDAO.get(1);
		
		//4.create a new cartline
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		cartLine.setTotal(cartLine.getProductCount()* product.getUnitPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
		
	}
	
/*	
	@Test
	public void testAddNewCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(2);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	
	*/
/*	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	}
*/	
	
	
}

