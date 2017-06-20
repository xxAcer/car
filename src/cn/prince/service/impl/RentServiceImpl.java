package cn.prince.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.prince.mapper.RentMapper;
import cn.prince.pojo.Rent;
import cn.prince.service.RentService;
@Service
public class RentServiceImpl implements RentService {
	@Resource
	RentMapper rentMapper;

	@Override
	public int addorder(Rent r) {
		// TODO Auto-generated method stub
		return rentMapper.addorder(r);
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return rentMapper.update(id);
	}

	@Override
	public List<Rent> allrent() {
		// TODO Auto-generated method stub
		return rentMapper.allrent();
	}

	@Override
	public Rent findById(int tableid) {
		// TODO Auto-generated method stub
		return rentMapper.findById(tableid);
	}

	@Override
	public void updateById(int id) {
		
		rentMapper.updateById(id);
	}

	@Override
	public List<Rent> yingHun(int carflag) {
		// TODO Auto-generated method stub
		return rentMapper.yingHuan(carflag);
	}

	@Override
	public List<Rent> allrentorder() {
		// TODO Auto-generated method stub
		return rentMapper.allrentorder();
	}

	@Override
	public Rent findByIdOrder(int tableid) {
		// TODO Auto-generated method stub
		return rentMapper.findByIdOrder(tableid);
	}

	@Override
	public int add(Rent r) {
		// TODO Auto-generated method stub
		return rentMapper.add(r);
	}

	@Override
	public void updateByIdOrder(int tableid) {
		// TODO Auto-generated method stub
		rentMapper.updateByIdOrder(tableid);
	}

	@Override
	public List<Rent> rentByC(String string) {
		// TODO Auto-generated method stub
		return rentMapper.rentByC(string);
	}

	@Override
	public List<Rent> rentorderByC(String id) {
		// TODO Auto-generated method stub
		return rentMapper.rentorderByC(id);
	}
}
