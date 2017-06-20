package cn.prince.service;

import java.util.List;

import cn.prince.pojo.Car;
import cn.prince.utils.PageBean;

public interface CarService {

	List<Car> find();

	Car findById(int carnumber);

	int addCar(Car car);

	void toRent(int carid);

	void notRent(int carnumber);

	void findAll();

	void findAll(PageBean pageBean);

	int removeCars(Integer id);

	int updateCar(Car car);

	List<Car> getAllByExcel(String string);

}