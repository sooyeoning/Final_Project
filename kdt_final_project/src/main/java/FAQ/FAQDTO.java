package FAQ;

public class FAQDTO {
int id;
String writer, email, phone, category, content, attachment;
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
String agreement;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAttachment() {
	return attachment;
}
public void setAttachment(String attachment) {
	this.attachment = attachment;
}
public String getAgreement() {
	return agreement;
}
public void setAgreement(String agreement) {
	this.agreement = agreement;
}
}
