package com.fwjia.admin.service.impl;

import com.fwjia.admin.dao.IUserDao;
import com.fwjia.admin.dao.support.IBaseDao;
import com.fwjia.admin.entity.User;
import com.fwjia.admin.service.IUserService;
import com.fwjia.admin.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户账户表  服务实现类
 * @author  fwjia
 * @email   jiafuwei_7@163.com
 * @date    2019.1.18
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

	@Autowired
	private IUserDao userDao;
	

	@Override
	public IBaseDao<User, Integer> getBaseDao() {
		return this.userDao;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId() != null){
			User dbUser = find(user.getId());

			update(dbUser);
		}else{
			save(user);
		}
	}
	
	

	@Override
	public void delete(Integer id) {
		User user = find(id);
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能删除");
		super.delete(id);
	}


	
}
