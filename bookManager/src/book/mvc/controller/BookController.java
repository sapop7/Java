package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {

	public void insertBook(Book b) {
		int result = new BookDao().insertBook(b);
		
		if(result > 0){
			System.out.println(result + "행이 추가 되었습니다.");
			new BookMenu().displayMenu();
		}
		else{
			System.out.println("새 도서 추가 실패");
			new BookMenu().displayMenu();
		}
	}

	public void upadateBook(Book b) {
		int result = new BookDao().updateBook(b);
		
		if(result > 0){
			System.out.println(result + "행이 수정 되었습니다.");
			new BookMenu().displayMenu();
		}
		else
			System.out.println("도서 수정 실패!");
			new BookMenu().displayMenu();
	}
	
	public void deleteBook(int bookId){
		int result = new BookDao().deleteBook(bookId);
		
		if(result > 0){
			System.out.println(result + "행이 삭제 되었습니다.");
			new BookMenu().displayMenu();
		}
		else{
			System.out.println("도서 삭제 실패!!");
			new BookMenu().displayMenu();
		}
	}
	
	public void searchBook(int bookId){
		 
		Book b = new BookDao().selectBook(bookId);
		new BookMenu().displayBook(b);
		
	}
	
	public void searchBookTitle(String bookTitle){
		ArrayList<Book> blist = new BookDao().searchBookTitle(bookTitle);
		new BookMenu().displayBooks(blist);
	}
	
	public void selectAll(){
		ArrayList<Book> blist = new BookDao().selectAllBooks();
		new BookMenu().displayBooks(blist);
	}
}
