package cn.prince.service;

import java.util.List;

import cn.prince.pojo.Loginlogs;

public interface LoginlogService {

	void loginlogAdd(String username, String ipAddr, String dateNowStr);

	List<Loginlogs> selectLog();

	List<Loginlogs> allLogs();

}