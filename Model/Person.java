package Model;

public abstract class Person {
	private String userName;
	private String passWord;
	private String birthday;
	private String phone;
	private String sex;
	private String address;
	
	public Person( String userName, String passWord,String phone, String birthday, String sex, String address) {
		this.userName = userName;
		this.passWord = passWord;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "userName : " + userName + "\npassWord : " + passWord + "\nbirthday : " + birthday + "\nphone : " + phone
				+ "\nsex : " + sex + "\naddress : " + address;
	}
	
	
}
