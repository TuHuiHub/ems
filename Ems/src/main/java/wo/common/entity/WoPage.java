package wo.common.entity;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WoPage <T> {
	
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(WoPage.class);
	
	private Long results = 0L;
	
	private List<T> rows;
	
	public WoPage(List<T> rows) {
		super();
		this.rows = rows;
		this.results = Long.valueOf(rows.size());
	}
	
	public WoPage (List<T> rows, Long results) {
		super();
		this.rows = rows;
		this.results = results;
	}
	
	public WoPage() {
	}
	
	

	public Long getResults() {
		return results;
	}

	public void setResults(Long results) {
		this.results = results;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
