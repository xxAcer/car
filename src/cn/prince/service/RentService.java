package cn.prince.service;

import java.util.List;

import cn.prince.pojo.Rent;

public interface RentService {

	int addorder(Rent r);

	int update(int id);

	List<Rent> allrent();

	Rent findById(int tableid);

	void updateById(int id);

	List<Rent> yingHun(int carflag);

	List<Rent> allrentorder();

	Rent findByIdOrder(int tableid);

	int add(Rent r);

	void updateByIdOrder(int tableid);

	List<Rent> rentByC(String name);

	List<Rent> rentorderByC(String name);

}
