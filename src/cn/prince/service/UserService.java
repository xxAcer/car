package cn.prince.service;

import java.util.List;

import cn.prince.pojo.Customers;
import cn.prince.pojo.User;

public interface UserService {


	User login(String username, String password);


	List find(String string);

	int add(User u);

	List<User> findAll();


	int removeUser(String username);


	User findUserByName(String username);


	int updateUser(User u);

}
