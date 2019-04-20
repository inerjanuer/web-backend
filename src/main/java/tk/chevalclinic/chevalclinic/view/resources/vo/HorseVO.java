package tk.chevalclinic.chevalclinic.view.resources.vo;


import lombok.Data;
import tk.chevalclinic.chevalclinic.model.ClientEntity;
import tk.chevalclinic.chevalclinic.model.TypeStatusEntity;


@Data
public class HorseVO {

	private long id;
	private String typeOfJob;
	private String sex;
	private String name;
	private String color;
	private String age;
	private String race;
	private String particularSigns;
	private String diet;
	private String comments;
	private String image;
	private String collectionDays;
	private TypeStatusEntity typeStatusEntity;
	private ClientEntity clientEntity;
	
	
}
