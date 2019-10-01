package idv.springboot.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_INFO")
public class UserInfoEntity {

	@Id
	private String id;

	@Column(name = "CNAME")
	private String cName;

	@Column(name = "ENAME")
	private String eName;

	private String phone;

	private String email;

	private String address;
}
