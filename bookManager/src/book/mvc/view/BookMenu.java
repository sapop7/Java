package book.mvc.view;

import java.util.*;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	 public BookMenu() {}	
	
		public void displayMenu() {
			int no;
			BookController bcontroll = new BookController();
			Book b = new Book();
			
			do{
			System.out.println("\n\n도서관리 프로그램\n");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			switch(no){
			case 1 : bcontroll.insertBook(inputBook()); 	break;
			case 2 : bcontroll.upadateBook(inputBook(b));	break;
			case 3 : bcontroll.deleteBook(inputBookId());	break;
			case 4 : bcontroll.searchBook(inputBookId());	break;
			case 5 : bcontroll.searchBookTitle(inputBookTitle());		break;
			case 6 : bcontroll.selectAll(); 	break;
			case 9 : System.out.print("정말 프로그램을 종료 하시겠습니까? (y/n) : ");
			 		   if(sc.next().toUpperCase().charAt(0) == 'Y')
			 			   return;
			 		   else
			 			   break;
	        default : System.out.println("번호 선택이 잘못 되었습니다.");
	        			System.out.println("다시 입력하십시요!");
				}
		}while(true);
	}

		private Book inputBook() {
			Book b = new Book();
			
			System.out.println("\n새 도서정보를 입력하시오.\n");
			sc.nextLine();
			System.out.print("도서이름 : ");
			b.setTitle(sc.nextLine());
			System.out.print("저자명 : ");
			b.setAuthor(sc.next());
			sc.nextLine();
			System.out.print("출판사 : ");
			b.setPubliSher(sc.nextLine());
			System.out.print("가격 : ");
			b.setPrice(sc.nextInt());
			
			return b;
		}

		public Book inputBook(Book b){
			System.out.print("\n수정할 도서 ID : ");
			b.setBookId(sc.nextInt());
			System.out.print("\n수정할 가격 : ");
			b.setPrice(sc.nextInt());
			
			return b;
			
		}
		
		public int inputBookId(){
			System.out.print("도서 아이디 : ");
			
			return sc.nextInt();
		}
		
		public String inputBookTitle(){
			System.out.print("도서 제목 : ");
			sc.nextLine();
			return sc.nextLine();
		}
		
		public void displayBooks(List<Book> list){
			for (Book book : list) {
				System.out.println(book);
			}
		}
		
		public void displayBook(Book b){
			System.out.println(b);
		}
		
		public void displayError(String message){
			
		}
	
}
