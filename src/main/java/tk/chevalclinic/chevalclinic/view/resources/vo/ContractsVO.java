package tk.chevalclinic.chevalclinic.view.resources.vo;

import java.util.Date;
import lombok.Data;

@Data
public class ContractsVO {
	
	
	private long id;
	private Date datecreated;
	private long idMale;
	private long idFemale;

}
