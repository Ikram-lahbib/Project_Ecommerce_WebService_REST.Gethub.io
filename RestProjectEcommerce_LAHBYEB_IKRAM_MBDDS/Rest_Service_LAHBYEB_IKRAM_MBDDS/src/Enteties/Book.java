package Enteties;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book implements  Serializable {
	private int Book_id;
	private String Book_Name ;
	private String Writer_Name;
	private String Book_Image ;
	private String Book_Summary;
	private double Book_Price;
	private int Book_Stock;
	private String Date_Add_Book;
	private Category Book_Catygory;
	
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public String getWriter_Name() {
		return Writer_Name;
	}
	public void setWriter_Name(String writer_Name) {
		Writer_Name = writer_Name;
	}
	public String getBook_Image() {
		return Book_Image;
	}
	public void setBook_Image(String book_Image) {
		Book_Image = book_Image;
	}
	public String getBook_Summary() {
		return Book_Summary;
	}
	public void setBook_Summary(String book_Summary) {
		Book_Summary = book_Summary;
	}
	public double getBook_Price() {
		return Book_Price;
	}
	public void setBook_Price(double book_Price) {
		Book_Price = book_Price;
	}
	public int getBook_Stock() {
		return Book_Stock;
	}
	public void setBook_Stock(int book_Stock) {
		Book_Stock = book_Stock;
	}
	public String getDate_Add_Book() {
		return Date_Add_Book;
	}
	public void setDate_Add_Book(String date_Add_Book) {
		Date_Add_Book = date_Add_Book;
	}
	public Category getBook_Catygory() {
		return Book_Catygory;
	}
	public void setBook_Catygory(Category book_Catygory) {
		Book_Catygory = book_Catygory;
	}
	public Book(String book_Name, String writer_Name, String book_Image, String book_Summary, double book_Price,
			int book_Stock, String date_Add_Book, Category book_Catygory) {
		super();
		Book_Name = book_Name;
		Writer_Name = writer_Name;
		Book_Image = book_Image;
		Book_Summary = book_Summary;
		Book_Price = book_Price;
		Book_Stock = book_Stock;
		Date_Add_Book = date_Add_Book;
		Book_Catygory = book_Catygory;
	}
	public Book() {
		super();
	}
	

}
