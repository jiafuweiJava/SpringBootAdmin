package com.fwjia.admin.dao;


import com.fwjia.admin.dao.support.IBaseDao;
import com.fwjia.admin.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

	User findByUserName(String username);

}
