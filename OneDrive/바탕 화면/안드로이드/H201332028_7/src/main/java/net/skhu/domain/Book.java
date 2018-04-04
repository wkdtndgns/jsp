package net.skhu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    String title;
    String author;
    int price;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    
    @ManyToOne
    @JoinColumn(name = "publisherId")
    Publisher publisher;


    

}
