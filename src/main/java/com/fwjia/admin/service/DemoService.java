package com.fwjia.admin.service;

import javax.annotation.Resource;

import com.fwjia.admin.dao.DemoDao;
import com.fwjia.admin.po.Demo;
import com.fwjia.admin.po.DemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 提供Demo服务类.
 * @author fwjia
 *
 */
@Service
public class DemoService {
	
	@Resource
    private DemoRepository demoRepository;
	
	@Resource
    private DemoDao demoDao;
	
	@Transactional
    public void save(Demo demo){
       demoRepository.save(demo);
    }
	
	public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return demoDao.getById(id);
 }
	
}
