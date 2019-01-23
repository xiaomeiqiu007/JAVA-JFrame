package pdsu.hrms.model;

public class History {
long hisId;
private String hisType;
private String oldInfo;
private String newInfo;
private String chgDtate;
private long chgNum;
private long personId;

//Õÿ’π Ù–‘
private String name;

public long getHisId() {
	return hisId;
}

public void setHisId(long hisId) {
	this.hisId = hisId;
}

public String getHisType() {
	return hisType;
}

public void setHisType(String hisType) {
	this.hisType = hisType;
}

public String getOldInfo() {
	return oldInfo;
}

public void setOldInfo(String oldInfo) {
	this.oldInfo = oldInfo;
}

public String getNewInfo() {
	return newInfo;
}

public void setNewInfo(String newInfo) {
	this.newInfo = newInfo;
}

public String getChgDtate() {
	return chgDtate;
}

public void setChgDtate(String chgDtate) {
	this.chgDtate = chgDtate;
}

public long getChgNum() {
	return chgNum;
}

public void setChgNum(long chgNum) {
	this.chgNum = chgNum;
}

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

}
