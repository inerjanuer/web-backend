package tk.chevalclinic.chevalclinic.view.resources.vo;

import lombok.Data;

@Data
public class DailyWorkVO {

	private long id;
	private String comments;
	private String observations;
	private String washeddat;
	private String transfer;
	private String pregnancyTest;
	private long idHorse;
	
}
