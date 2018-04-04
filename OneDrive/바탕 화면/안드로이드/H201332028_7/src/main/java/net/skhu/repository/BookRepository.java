package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.model.Option;
import net.skhu.model.Pagination;

import net.skhu.domain.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

		Option[] searchBy = { new Option(0, "검색 없음"), new Option(1, "제목"),
		            new Option(2, "저자"), new Option(3, "출판사"), new Option(4, "카테고리")   };
	
		
		public default List<Book> findAll(Pagination pagination) {
		Pageable pageable =
		  new PageRequest(pagination.getPg() - 1, 15);
		
		Page<Book> page;
		
		String searchText = pagination.getSt();
		switch (pagination.getSb()) {
		 case 1: page = this.findByTitle(searchText, pageable); break;
		 case 2: page = this.findByAuthor(searchText, pageable); break;
		 case 3: page = this.findByPublisherTitle(searchText, pageable); break;
		 case 4: page = this.findByCategoryName(searchText, pageable); break;
		 
		default: page = this.findAllByOrderById(pageable); break;
		}
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
		}
		
		
		
		public Page<Book> findAllByOrderById(Pageable pageable);
	    public Page<Book> findById(int id, Pageable pageable);
	 
	    public Page<Book> findByAuthor(String author, Pageable pageable);
	    
	    public Page<Book> findByTitleStartsWith(String title, Pageable pageable);
	
	    public Page<Book> findByPublisher(String publisherTitle,Pageable pageable);
	    
	    
	    @Query("SELECT b FROM Book b WHERE b.publisher.publisherTitle= :publisherTitle")
	    Page<Book> findByPublisherTitle(@Param("publisherTitle") String publisherTitle,Pageable pageable);
	    
	    @Query("SELECT b FROM Book b WHERE b.category.categoryName= :categoryName")
	    Page<Book> findByCategoryName(@Param("categoryName") String categoryName,Pageable pageable);

	    
	    @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT('%',:title,'%')")
	    Page<Book> findByTitle(@Param("title") String title,Pageable pageable);


}

