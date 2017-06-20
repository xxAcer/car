package cn.prince.mapper;

import java.util.List;

import cn.prince.pojo.Menu;

public interface MenuMapper {

	List<Menu> findMenuById(int id);

	List<Menu> findMenuById1(int id1);

}
