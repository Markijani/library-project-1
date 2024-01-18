package ru.itgirl.libraryproject1.servise;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject1.dto.BookCreateDto;
import ru.itgirl.libraryproject1.dto.BookDto;
import ru.itgirl.libraryproject1.dto.BookUpdateDto;
import ru.itgirl.libraryproject1.model.Book;
import ru.itgirl.libraryproject1.repository.BookRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDto> getByNameV1(String name) {
        List<Book> books = bookRepository.findAllByName(name);
        return books.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getByNameV2(String name) {
        List<Book> books = bookRepository.findAllByNameBySql(name);
        return books.stream()
                .map((this::convertEntityToDto))
                .collect(Collectors.toList());

    }

    @Override
    public List<BookDto> getByNameV3(String name) {
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });

        List<Book> books = bookRepository.findAll(specification);
        return books.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Book book = bookRepository.save(convertDtoToEntity(bookCreateDto));
        BookDto bookDto = convertEntityToDto(book);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        Book book = bookRepository.findById(bookUpdateDto.getId()).orElseThrow();
        book.setName(bookUpdateDto.getName());
        book.setGenre(bookUpdateDto.getGenre());
        Book savedBook = bookRepository.save(book);
        BookDto bookDto = convertEntityToDto(savedBook);
        return bookDto;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        return Book.builder()
                .name(bookCreateDto.getName())
                .genre(bookCreateDto.getGenre())
                .build();
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private BookDto convertEntityToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .genre(book.getGenre().getName())
                .name(book.getName())
                .build();
    }
}