package cn.prince.service;

import java.util.List;

import cn.prince.pojo.Checktable;

public interface CheckService {

	int add(Checktable checktable);

	List<Checktable> findAll();

}
