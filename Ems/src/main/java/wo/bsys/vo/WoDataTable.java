package wo.bsys.vo;
import java.util.ArrayList;
import java.util.List;


import wo.common.entity.WoPage;

/**
 * DataTable控件列表数据对象
 * @author 
 *
 * @param <T>
 */
public class WoDataTable<T> {
	
	
	private Integer draw = 0;
	
	private Long recordsTotal = 0L;
	
	private Long recordsFiltered = 0L;
	
	private List<T> data = new ArrayList<T>();

	
	public WoDataTable (WoPage<T> page, Integer draw) {
		recordsTotal = page.getResults();
		recordsFiltered = page.getResults();
		data = page.getRows();
		this.draw = draw;
	}
	
	@Override
	public String toString() {
		return "WoDataTable [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", data=" + data.size() + "]";
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
