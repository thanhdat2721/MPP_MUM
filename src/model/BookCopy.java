package model;

public class BookCopy {
	private int bookId;
	private int copyId;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public BookCopy(int bookId, int copyId) {
		this.bookId = bookId;
		this.copyId = copyId;

		this.status = "Available";
	}
}
