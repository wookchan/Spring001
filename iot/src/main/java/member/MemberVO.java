package member;

public class MemberVO {
	private String id,pw,gender,email,birth,phone,address,post,name,admin,salt,salt_pw;
	
	public MemberVO() {}
	

	
	
	
	public MemberVO(String id, String pw, String gender, String email, String birth, String phone, String address,
			String post, String name, String admin, String salt, String salt_pw) {
		super();
		this.id = id;
		this.pw = pw;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.post = post;
		this.name = name;
		this.admin = admin;
		this.salt = salt;
		this.salt_pw = salt_pw;
	}





	public String getAdmin() {
		return admin;
	}



	public void setAdmin(String admin) {
		this.admin = admin;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public String getSalt_pw() {
		return salt_pw;
	}



	public void setSalt_pw(String salt_pw) {
		this.salt_pw = salt_pw;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	



}
