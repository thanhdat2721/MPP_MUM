package model;

import java.time.LocalTime;

public class BorrowReturnBook {
	Book book = new Book();
	LibraryMember member = new LibraryMember();
	LocalTime borrowDate;
	LocalTime dueDate;
	LocalTime returnDate;
	String status;
	public LocalTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalTime returnDate) {
		this.returnDate = returnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BorrowReturnBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowReturnBook(String book, String member, String borrowDate, String dueDate,String realDate, String status) {
		super();
		this.book.setTitle(book);
		this.member.setFirstName(member);
		//this.borrowDate =(borrowDate);
		//this.dueDate = dueDate;
		//this.returnDate =realDate;
		this.setStatus(status);
	}
	public LibraryMember getMember() {
		return member;
	}
	public void setMember(LibraryMember member) {
		this.member = member;
	}
	public LocalTime getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalTime borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalTime dueDate) {
		this.dueDate = dueDate;
	}
	

}
