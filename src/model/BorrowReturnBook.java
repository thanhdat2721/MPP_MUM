package model;

import java.time.LocalDate;

public class BorrowReturnBook {
	Book book = new Book();
	LibraryMember member = new LibraryMember();
	LocalDate borrowDate;
	LocalDate dueDate;
	LocalDate returnDate;
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
	public BorrowReturnBook() {
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
	public String getMembern() {
		return member.getFirstName();
	}
	public BorrowReturnBook(String book, String member, LocalDate borrowDate, LocalDate dueDate,
			LocalDate returnDate, String status) {
		
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
	
	

}
