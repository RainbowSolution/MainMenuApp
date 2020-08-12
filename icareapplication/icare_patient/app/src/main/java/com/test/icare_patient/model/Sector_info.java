package com.test.icare_patient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sector_info {

@SerializedName("id")
@Expose
private String id;
@SerializedName("department_name")
@Expose
private String departmentName;
@SerializedName("description")
@Expose
private String description;
@SerializedName("status")
@Expose
private String status;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getDepartmentName() {
return departmentName;
}

public void setDepartmentName(String departmentName) {
this.departmentName = departmentName;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}