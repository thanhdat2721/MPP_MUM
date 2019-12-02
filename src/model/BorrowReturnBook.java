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
		this.book = getBook("Template");
		this.member = getMember("No Name");
		this.borrowDate = LocalTime.now();
		this.dueDate = LocalTime.now();
		
		this.status = "No Status";
	}
	public Book getBook(String bookid)
	{
		Book b1= new Book();
		b1.setTitle(bookid);
		return b1;
		
	}
	public LibraryMember getMember(String memid)
	{
		LibraryMember mem = new LibraryMember();
		mem.setFirstName(memid);
		return mem;
	
	}
	/*public BorrowReturnBook(String book, String member, String borrowDate, String dueDate,String realDate, String status) {
		super();
		this.book.setTitle(book);
		this.member.setFirstName(member);
		//this.borrowDate =(borrowDate);
		//this.dueDate = dueDate;
		//this.returnDate =realDate;
		this.setStatus(status);
	}*/
	public LibraryMember getMember() {
		return member;
	}
	public BorrowReturnBook(String book, String member, LocalTime borrowDate, LocalTime dueDate,
			LocalTime returnDate, String status) {
		super();
		this.book = getBook(book);
		this.member = getMember(member);
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
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
