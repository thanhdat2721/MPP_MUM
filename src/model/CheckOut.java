package model;

import java.time.LocalDate;

public class CheckOut {
	Book book = new Book();
	public LibraryMember member = new LibraryMember();
	LocalDate borrowDate;
	LocalDate dueDate;
	LocalDate returnDate;
	String bookname;
	String membername;
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public String getBookt() {
		return book.getTitle();
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public CheckOut() {
		this.book = getBook("Template");
		this.member = getMember("No Name");
		this.borrowDate = LocalDate.now();
		this.dueDate = LocalDate.now();
		
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
	
	public LibraryMember getMember() {
		return member;
	}
	public String getMembern() {
		return member.getFirstName();
	}
	public CheckOut(String book, String member, LocalDate borrowDate, LocalDate dueDate,
			LocalDate returnDate, String status) {
		
		this.bookname = book;
		this.membername = member;//getMember(member);
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	public void setMember(LibraryMember member) {
		this.member = member;
	}
	
	

}
