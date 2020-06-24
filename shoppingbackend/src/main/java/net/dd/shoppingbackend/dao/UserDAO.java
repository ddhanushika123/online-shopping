package net.dd.shoppingbackend.dao;

import java.util.List;

import net.dd.shoppingbackend.dto.Address;
import net.dd.shoppingbackend.dto.Cart;
import net.dd.shoppingbackend.dto.User;

public interface UserDAO {

    //add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	//alternative
		//Address getBillingAddress(int userId);
	    //List<Address> listShippingAddresses(int userId);
	
	Address getBillingAddress(User user);
    List<Address> listShippingAddresses(User user);

}