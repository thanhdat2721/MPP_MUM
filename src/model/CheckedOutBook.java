package model;

import java.util.Date;

public class CheckedOutBook {
	
	private String bookName;
	private String memberName;
	private String checkoutDate;
	private String dueDate;
	
	public CheckedOutBook(String bookName, String memberName, String checkoutDate, String dueDate) {
		super();
		this.bookName = bookName;
		this.memberName = memberName;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
