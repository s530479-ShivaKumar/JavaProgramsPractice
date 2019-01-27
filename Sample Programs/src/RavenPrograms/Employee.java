package RavenPrograms;

public class Employee implements Comparable<Employee>{
	int id;
	int age;
	String name;
	
	public Employee(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		if(this.id<arg0.id) {
			return -1;
		}
		else if(this.id>arg0.id) {
			return 1;
		}
		else
			return 0;
	}

}
