package pdsu.hrms.model;

public class Person {
private long personId;
private String name;
private String sex;
private String birth;
private String nat;
private String address;
private long deptId;
private String salary;
private String assess;
private String other;
public long getPersonId() {
	return personId;
}
public void setPersonId(long personId) {
	this.personId = personId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getNat() {
	return nat;
}
public void setNat(String nat) {
	this.nat = nat;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getDeptId() {
	return deptId;
}
public void setDeptId(long deptId) {
	this.deptId = deptId;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getAssess() {
	return assess;
}
public void setAssess(String assess) {
	this.assess = assess;
}
public String getOther() {
	return other;
}
public void setOther(String other) {
	this.other = other;
}

}
