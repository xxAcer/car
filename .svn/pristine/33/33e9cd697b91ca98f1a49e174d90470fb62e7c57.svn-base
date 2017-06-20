package cn.prince.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.prince.mapper.CustomersMapper;
import cn.prince.pojo.Customers;
import cn.prince.pojo.User;
import cn.prince.service.CustomersService;
@Service
public class CustomersServiceImpl implements CustomersService {
	
	@Resource	
	CustomersMapper customersMapper;

	@Override
	public List<Customers> find(String string) {
		// TODO Auto-generated method stub
		return customersMapper.find(string);
	}

	@Override
	public int add(Customers cu) {
		// TODO Auto-generated method stub
		return customersMapper.add(cu);
	}

	@Override
	public List<Customers> findAll() {
		// TODO Auto-generated method stub
		return customersMapper.findAll();
	}

	@Override
	public Customers login(String name, String pwd) {
		// TODO Auto-generated method stub
		return customersMapper.login(name,pwd);
	}

	@Override
	public int removeCu(String cname) {
		// TODO Auto-generated method stub
		return customersMapper.removeCu(cname);
	}

	@Override
	public Customers findCuByName(String cname) {
		// TODO Auto-generated method stub
		return customersMapper.findCuByName(cname);
	}

	@Override
	public int updateCu(Customers u) {
		// TODO Auto-generated method stub
		return customersMapper.updateCu(u);
	}
	
}
