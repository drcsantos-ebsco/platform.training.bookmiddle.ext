package com.ebsco.training.bookmiddle.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.ebsco.training.bookmiddle.dto.BookDto;

@Repository("MongoDBBookDao")
public class MongoDBBookDao implements BookDao {
    
    public static String COLLECTION = "books";
    
    @Autowired @Qualifier("mongoTemplate")
    private MongoOperations mongoOperation;

    /* (non-Javadoc)
     * @see com.ebsco.training.bookmiddle.dao.BookDao#getBooks()
     */
    @Override
    public List<BookDto> getBooks() {
        return mongoOperation.findAll(BookDto.class, this.COLLECTION);
    }

    /* (non-Javadoc)
     * @see com.ebsco.training.bookmiddle.dao.BookDao#getBookById(java.lang.String)
     */
    @Override
    public Optional<BookDto> getBookById(String id) {
        return Optional.of(mongoOperation.findById(id, BookDto.class, this.COLLECTION));
    }

    /* (non-Javadoc)
     * @see com.ebsco.training.bookmiddle.dao.BookDao#deleteBook(java.lang.String)
     */
    @Override
    public Optional<BookDto> deleteBook(String id) {
        Optional<BookDto> result = this.getBookById(id);
        if (result.isPresent()) {
            mongoOperation.remove(result.get(), this.COLLECTION);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.ebsco.training.bookmiddle.dao.BookDao#createBook(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public BookDto createBook(String title, String author, String genre) {
        BookDto instance = new BookDto(null, title, author, genre);
        mongoOperation.insert(instance, this.COLLECTION);
        
        return instance;
    }

    /* (non-Javadoc)
     * @see com.ebsco.training.bookmiddle.dao.BookDao#updateBook(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Optional<BookDto> updateBook(String id, String title, String author, String genre) {
        Optional<BookDto> result = this.getBookById(id);
        if (result.isPresent()) {
            BookDto instance = result.get();
            instance.setTitle(title);
            instance.setAuthor(author);
            instance.setGenre(genre);
            
            mongoOperation.save(instance, this.COLLECTION);
        }
        return result;
    }
}