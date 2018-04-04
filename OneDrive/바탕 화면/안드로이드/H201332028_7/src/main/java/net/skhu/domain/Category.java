package net.skhu.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import lombok.Data;

@Data
@ToString(exclude={"books"})
@EqualsAndHashCode(exclude={"books"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    

    String categoryName;
    
    @JsonIgnore
    @OneToMany(mappedBy="category")
    List<Book> books;
    
}
