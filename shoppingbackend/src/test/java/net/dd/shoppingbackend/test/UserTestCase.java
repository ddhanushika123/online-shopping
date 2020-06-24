package net.dd.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.dd.shoppingbackend.dao.UserDAO;
import net.dd.shoppingbackend.dto.Address;
import net.dd.shoppingbackend.dto.Cart;
import net.dd.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.dd.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
/*	
	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!",true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B , Temple road");
		address.setAddressLineTwo("Godagama");
		address.setCity("Homagama");
		address.setState("Homagama1");
		address.setCountry("Sri Lanka");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link user with address using user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add address!",true, userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();			
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!",true, userDAO.addCart(cart));
			
			//add shipping address for this user
			address = new Address();
			address.setAddressLineOne("201/B , school road");
			address.setAddressLineTwo("Kottawa");
			address.setCity("Maharagama");
			address.setState("Maharagama1");
			address.setCountry("Sri Lanka");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			
			//link it with user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
			
			
		}
		
		
		
	}
*/	
	
/*	
	@Test
	public void testAdd() {
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart = new Cart();			
			cart.setUser(user);
			
			//attach cart eith the user
			user.setCart(cart);
			
		}

		//add the user
		assertEquals("Failed to add user!",true, userDAO.addUser(user));
		
		
	}
*/
	
/*	@Test
	public void testUpdateCart() {
		
		//fetch the user by its email
		user = userDAO.getByEmail("hr@gmail.com");
		
		//get the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(5555);
		
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
		
	}
*/
	
/*	
	@Test
	public void testAddAddress() {
		
		//we need to add an user
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!",true, userDAO.addUser(user));
		

		
		//we going to add an Address
		address = new Address();
		address.setAddressLineOne("101/B , Temple road");
		address.setAddressLineTwo("Godagama");
		address.setCity("Homagama");
		address.setState("Homagama1");
		address.setCountry("Sri Lanka");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//Attach the user to the Address
		address.setUser(user);
		assertEquals("Failed to add address!",true, userDAO.addAddress(address));
		
		
		//we are also going to add shipping address
		address = new Address();
		address.setAddressLineOne("201/B , school road");
		address.setAddressLineTwo("Kottawa");
		address.setCity("Maharagama");
		address.setState("Maharagama1");
		address.setCountry("Sri Lanka");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		//Attach the user to the Address
		address.setUser(user);
		assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
		
	}
*/	
	
/*	
	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		//we are also going to add shipping address
		address = new Address();
		address.setAddressLineOne("301/B , school road");
		address.setAddressLineTwo("Kottawa");
		address.setCity("Colombo");
		address.setState("Colombo1");
		address.setCountry("Sri Lanka");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
				
		//Attach the user to the Address
		address.setUser(user);
		assertEquals("Failed to add shipping address!",true, userDAO.addAddress(address));
				
	}
*/	

	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size does not match!", 2, userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fetch the billing address and size does not match!", "Homagama", userDAO.getBillingAddress(user).getCity());
		
		
	}

	
}

