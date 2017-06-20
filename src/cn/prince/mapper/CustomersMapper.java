package cn.prince.mapper;

import java.util.List;

import cn.prince.pojo.Customers;

public interface CustomersMapper {

	List<Customers> find(String string);

	int add(Customers cu);

	List<Customers> findAll();

	Customers login(String name, String pwd);

	int removeCu(String cname);

	Customers findCuByName(String cname);

	int updateCu(Customers u);

}
