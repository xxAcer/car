package cn.prince.mapper;

import java.util.List;
import java.util.Map;

import cn.prince.pojo.Car;

public interface CarMapper {

	List<Car> find();

	Car findById(int carnumber);

	int addCar(Car car);

	void toRent(int carid);

	void notRent(int carnumber);

	int findCount();

	List<Car> findPage(Map map);

	int removeCar(Integer id);

	int updateCar(Car car);

}
