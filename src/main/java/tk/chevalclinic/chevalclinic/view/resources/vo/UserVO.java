package tk.chevalclinic.chevalclinic.view.resources.vo;

import lombok.Data;


@Data
public class UserVO {

	private long id;
	private String name;
	private String email;
	private String password;
	private String rol;
	private String typeUser;
	
	
}
