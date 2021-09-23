package Lee;

import java.sql.Date;

public class ManagementDTO {
private int seq;
private String id;
private String password;
private String name;
private String gender;
private String tel;
private String email;
private Date createDate;


public void setSeq(int seq) {
    this.seq = seq;
}
public int getSeq() {
    return seq;
}
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getGender() {
    return gender;
}
public void setGender(String gender) {
    this.gender = gender;
}
public String getTel() {
    return tel;
}
public void setTel(String tel) {
    this.tel = tel;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Date getCreateDate() {
    return createDate;
}
public void setCreateDate(Date createDate) {
    this.createDate = createDate;
}
@Override
public String toString() {
    return "ManagementDTO [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name + ", gender="
            + gender + ", tel=" + tel + ", email=" + email + ", createDate=" + createDate + "]";
   }
}