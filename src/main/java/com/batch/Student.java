package com.batch;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private String status;
	
	public Student(int id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Student student) {
		return name.compareTo(student.name);
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		  final int prime = 31;
	        int result = 1;
	        result = prime * result + id;
	        result = prime * result
	                 + ((name == null) ? 0 : name.hashCode());
	        return result;

	}

	@Override
	public boolean equals(Object obj) {
		
		if(this  == obj) 
			return  true;
		if(obj == null)
			return  false;
		if(getClass()!= obj.getClass())
			return false;
		
		Student source = (Student) obj;
		
		
		if(id != source.id)
			return false;
		if(name ==  null) {
			if(source.name  != null)
				return false;	
		} 
		else if(!name.equals(source.name))
			return false;
		
		return true;
	}
	
	
	

}
