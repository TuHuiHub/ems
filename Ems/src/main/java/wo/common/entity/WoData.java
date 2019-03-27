package wo.common.entity;
import java.util.ArrayList;
import java.util.List;


import com.dream.ems.po.Major;
public class WoData {

	private List<Major> majors = new ArrayList<>();

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	
}
