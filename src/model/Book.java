package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
	private final StringProperty title;
	private final StringProperty author;
	private final StringProperty issn;
	private final ObjectProperty<LocalDate> publishedDate;

	public Book() {
		this(null, null);
	}
	
	public Book(String title, String author) {
		this.title = new SimpleStringProperty(title);
		this.author = new SimpleStringProperty(author);
		this.issn = new SimpleStringProperty("issn goes here");
		this.publishedDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	}
	
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public String getTitle() {
		return this.title.get();
	}
	
	public StringProperty titleProperty() {
		return this.title;
	}
	
	public void setAuthor(String author) {
		this.author.set(author);
	}
	
	public String getAuthor() {
		return this.author.get();
	}
	
	public StringProperty authorProperty() {
		return this.author;
	}
	
	public void setIssn(String issn) {
		this.issn.set(issn);
	}
	
	public String getIssn() {
		return this.issn.get();
	}
	
	public StringProperty issnProperty() {
		return this.issn;
	}
	
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate.set(publishedDate);
	}
	
	public LocalDate getPublishedDate() {
		return this.publishedDate.get();
	}
	
	public ObjectProperty<LocalDate> publishedDateProperty(){
		return this.publishedDate;
	}
}
