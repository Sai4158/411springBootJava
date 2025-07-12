package sql.test.demo.topiccontroller;


public class Topics {
	private String id;
	private String name;
	private String descString;
	public Topics(String id, String name, String descString) {
		super();
		this.id = id;
		this.name = name;
		this.descString = descString;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescString() {
		return descString;
	}
	public void setDescString(String descString) {
		this.descString = descString;
	}



}
