package User;

import java.sql.Timestamp;

public class VisitedDTO {
    private int id;
    private int userId;
    private String pageUrl;
    private Timestamp visited;

    public VisitedDTO() {
    }

    public VisitedDTO(int userId, String pageUrl) {
        this.userId = userId;
        this.pageUrl = pageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Timestamp getVisited() {
        return visited;
    }

    public void setVisited(Timestamp visited) {
        this.visited = visited;
    }

	@Override
	public String toString() {
		return "VisitedDTO [id=" + id + ", userId=" + userId + ", pageUrl=" + pageUrl + ", visited=" + visited + "]";
	}
    
}
