package idv.springboot.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.springboot.demo.Dao.UserInfoDao;
import idv.springboot.demo.Entity.UserInfoEntity;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao dao;

	public UserInfoEntity findById(String id) {

		UserInfoEntity entity = dao.findById(id).orElse(new UserInfoEntity());

		return entity;
	}
	
	public void add(UserInfoEntity entity) {

		dao.save(entity);
	}
}
