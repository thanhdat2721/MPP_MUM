package model;

import java.time.LocalDate;

public class LibraryMember extends Person {

	private int memberNum;	
	private LocalDate registeredDate;
	public LibraryMember() {
		
	}
	public LibraryMember(String firstName, String lastName, String mobileNo, String email, int memberNum, LocalDate registeredDate) {
		super(firstName, lastName, mobileNo, email);
		this.memberNum = memberNum;
		this.registeredDate = registeredDate;
	}

	public int getMemberNum() {
		return memberNum;
	}
	public String getFullName() {
		return getFirstName()+getLastName();
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
