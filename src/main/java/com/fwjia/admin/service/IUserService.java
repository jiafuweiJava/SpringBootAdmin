package com.fwjia.admin.service;


import com.fwjia.admin.entity.User;
import com.fwjia.admin.service.support.IBaseService;

/**
 * 用户服务类
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
public interface IUserService extends IBaseService<User, Integer> {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

	/**
	 * 增加或者修改用户
	 * @param user
	 */
	void saveOrUpdate(User user);



}
