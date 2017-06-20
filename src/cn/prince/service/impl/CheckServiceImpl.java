package cn.prince.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.prince.mapper.CheckMapper;
import cn.prince.pojo.Checktable;
import cn.prince.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService {
	@Resource
	CheckMapper checkMapper;

	@Override
	public int add(Checktable checktable) {
		// TODO Auto-generated method stub
		return checkMapper.add(checktable);
	}

	@Override
	public List<Checktable> findAll() {
		// TODO Auto-generated method stub
		return checkMapper.findAll();
	}
	
}
