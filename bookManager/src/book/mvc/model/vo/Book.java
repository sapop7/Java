package book.mvc.model.vo;

import java.util.*;

public class Book implements java.io.Serializable {
	private int bookId;
	private String title;
	private String author;
	private String publiSher;
	private Date publishDate;
	private int price;
	
	public Book() {}

	public Book(int bookId, String title, String author, String publiSher, Date publishDate, int price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publiSher = publiSher;
		this.publishDate = publishDate;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubliSher() {
		return publiSher;
	}

	public void setPubliSher(String publiSher) {
		this.publiSher = publiSher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  bookId + ", " + title + ", " + author + ", " + publiSher
				+ ", " + publishDate + ", " + price;
	}

	

	
	
}
