package User;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	int id;
	String nickname, username,userpw,userid;
	String phone, email, mbti,grade;
	String address,address2;
	String photo;

	public UserDTO() {
	}

	public UserDTO(int id, String nickname, String username, String userpw, String userid, String phone, String email,
			String mbti, String grade, String address, String address2, String photo) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.username = username;
		this.userpw = userpw;
		this.userid = userid;
		this.phone = phone;
		this.email = email;
		this.mbti = mbti;
		this.grade = grade;
		this.address = address;
		this.address2 = address2;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nickname=" + nickname + ", username=" + username + ", userpw=" + userpw
				+ ", userid=" + userid + ", phone=" + phone + ", email=" + email + ", mbti=" + mbti + ", grade=" + grade
				+ ", address=" + address + ", address2=" + address2 + ", photo=" + photo + "]";
	}


}
