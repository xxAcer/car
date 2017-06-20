package cn.prince.mapper;

import java.util.List;

import cn.prince.pojo.Customers;
import cn.prince.pojo.User;

public interface UserMapper {

	User login(String username, String password);

	List<User> find(String string);

	int add(User u);

	List<User> findAll();

	int removeUser(String username);

	User userMapper(String username);

	User findUserByName(String username);

	int updateUser(User u);
	
}
