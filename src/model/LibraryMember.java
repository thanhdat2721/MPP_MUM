package model;

import java.time.LocalDate;

public class LibraryMember extends Person {

	private int memberNum;	
	private LocalDate registeredDate;
	
	public LibraryMember() {
		// TODO Auto-generated constructor stub
		memberNum = 0;
		registeredDate=LocalDate.now();

	}

	public LibraryMember(int memberNum, LocalDate registeredDate) {
		super();
		this.memberNum = memberNum;
		this.registeredDate = registeredDate;
	}



	public LibraryMember(int memNo, String fname, String lname, String mobile, String emailAdr, LocalDate rdate) {
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setMobileNo(mobile);
		this.setEmail(emailAdr);
		registeredDate = rdate;
		memberNum = memNo;

	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}

}
