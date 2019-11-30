package application;


import java.time.LocalDate;


public class LibraryMember {
	
	private int memberNum;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String email;
	private LocalDate registeredDate;
	
	public LibraryMember( ) {
		// TODO Auto-generated constructor stub
		memberNum=0;
		
		
	}
	public LibraryMember(int memNo, String fname, String lname, String mobile, String emailAdr ) {
		// TODO Auto-generated constructor stub
		firstName=fname;
		lastName=lname;
		mobileNo=mobile;
		email=emailAdr;
		registeredDate=LocalDate.now();
		memberNum=memNo;
		
	}
	
	public LibraryMember(int memNo, String fname, String lname, String mobile, String emailAdr , LocalDate rdate ) {
		// TODO Auto-generated constructor stub
		firstName=fname;
		lastName=lname;
		mobileNo=mobile;
		email=emailAdr;
		registeredDate=rdate;
		memberNum=memNo;
		
	}
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobilNo) {
		this.mobileNo = mobilNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

}
