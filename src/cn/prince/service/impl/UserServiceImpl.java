package cn.prince.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.prince.mapper.UserMapper;
import cn.prince.pojo.Customers;
import cn.prince.pojo.User;
import cn.prince.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Resource
	UserMapper userMapper;
	

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.login(username,password);
	}



	@Override
	public List<User> find(String string) {
		// TODO Auto-generated method stub
		return userMapper.find(string);
	}


	@Override
	public int add(User u) {
		// TODO Auto-generated method stub
		return userMapper.add(u);
	}


	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		System.out.println("查询用户");
		return userMapper.findAll();
	}



	@Override
	public int removeUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.removeUser(username);
	}



	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(username);
	}



	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(u);
	}

}
