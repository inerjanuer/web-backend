package tk.chevalclinic.chevalclinic.view.resources.vo;

import java.util.Date;
import lombok.Data;
import tk.chevalclinic.chevalclinic.model.HorseEntity;

@Data
public class ContractsVO {
	
	
	private long id;
	private Date datecreated;
	private HorseEntity horseMaleEntity;
	private HorseEntity horseFemaleEntity;

}
