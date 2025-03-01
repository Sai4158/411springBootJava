package psu.edu.quiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employeedatatable") 
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private int id;

    @Column(name = "e_name")
    private String name;

    @Column(name = "e_salary")
    private double salary;

    @Column(name = "e_age")
    private int age;

    @Column(name = "e_gender")
    private String gender;

    @Column(name = "e_dept")
    private String department;

    public Employee() {}

    public Employee(String name, double salary, int age, String gender, String department) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.department = department;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", gender=" + gender
				+ ", department=" + department + "]";
	}
    
    
}