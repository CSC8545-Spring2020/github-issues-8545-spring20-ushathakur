package edu.studio.issue;

import java.util.Date;

public class Issue implements Comparable<Issue> {
    private long id;
    private int number;
    private String state;
    private String title;
    private String body;
    private Date createdAt;
    @Override
    public String toString() {
        return "Issue [id=" + id + ", number=" + number + ", state=" + state
                + ", title=" + title + ", body=" + body + ", createdAt="
                + createdAt + ", closedAt=" + closedAt + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result
                + ((closedAt == null) ? 0 : closedAt.hashCode());
        result = prime * result
                + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + number;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Issue other = (Issue) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        }
        else if (!body.equals(other.body))
            return false;
        if (closedAt == null) {
            if (other.closedAt != null)
                return false;
        }
        else if (!closedAt.equals(other.closedAt))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!createdAt.equals(other.createdAt))
            return false;
        if (id != other.id)
            return false;
        if (number != other.number)
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        }
        else if (!state.equals(other.state))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        return true;
    }
    private Date closedAt;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getClosedAt() {
        return closedAt;
    }
    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }
    @Override
    public int compareTo(Issue o) {
        if(this.id == o.id) 
            return 0;
        if (this.id > o.id) 
            return 1;
        if (this.id < o.id)
            return -1;
        return 0;
    }
    
    
    
    

}
