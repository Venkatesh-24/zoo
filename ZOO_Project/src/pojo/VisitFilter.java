package pojo;

public class VisitFilter {
	
	int userId;
	int start;
	int limit;
	
	public VisitFilter(int userId, int start, int limit) {
		
		this.userId = userId;
		this.start = start;
		this.limit = limit;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
