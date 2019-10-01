package idv.springboot.demo.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idv.springboot.demo.Entity.UserInfoEntity;

@Repository
public interface UserInfoDao extends CrudRepository<UserInfoEntity, String> {

}
