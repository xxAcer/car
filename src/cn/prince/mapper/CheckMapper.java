package cn.prince.mapper;

import java.util.List;

import cn.prince.pojo.Checktable;

public interface CheckMapper {

	int add(Checktable checktable);

	List<Checktable> findAll();

}
