package idv.springboot.demo.Service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;

import idv.springboot.demo.Dao.UserInfoDao;
import idv.springboot.demo.Entity.UserInfoEntity;

@Service
public class UserInfoService extends WebService {

	@Autowired
	private UserInfoDao dao;

	public UserInfoEntity findById(String id) {

		UserInfoEntity entity = dao.findById(id).orElse(new UserInfoEntity());

		return entity;
	}

	public void add(UserInfoEntity entity) {

		dao.save(entity);
	}

	/**
	 * getInit 初始化
	 * 
	 * @return
	 */
	public String getInit() {

		Gson gson = new Gson();

		return gson.toJson(this.getDate());
	}

	/**
	 * getDate 取得當天日期
	 * 
	 * @return
	 */
	private String getDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Calendar cal = Calendar.getInstance();

		cal.setTime(new Date());

		cal.add(Calendar.YEAR, -20);

		return sdf.format(cal.getTime());
	}
}
