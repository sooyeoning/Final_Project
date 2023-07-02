package User;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	int id;
	String nickname, username,userpw,userid;
	String phone, email, mbti,grade;
	String address;

	public UserDTO() {
	}

	public UserDTO(int id, String nickname, String username, String userpw, String userid, String phone, String email,
			String mbti, String grade,String address) {
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nickname=" + nickname + ", username=" + username + ", userpw=" + userpw
				+ ", userid=" + userid + ", phone=" + phone + ", email=" + email + ", mbti=" + mbti + ", grade=" + grade
				+ ", address=" + address + "]";
	}

}
