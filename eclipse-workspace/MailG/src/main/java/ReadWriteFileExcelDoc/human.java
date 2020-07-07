package ReadWriteFileExcelDoc;

public class human {
	private String id;
	private String name;
	private String salary;
	private String destination;
	
	human() {
	
		
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String ToString() {
		return " ID "+id+" Name :"+name+" Salary: "+salary+""+destination+"\n";
		
	}
	
}
