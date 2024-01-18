package ru.itgirl.libraryproject1.servise;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject1.dto.AuthorCreateDto;
import ru.itgirl.libraryproject1.dto.AuthorDto;
import ru.itgirl.libraryproject1.dto.AuthorUpdateDto;
import ru.itgirl.libraryproject1.dto.BookDto;
import ru.itgirl.libraryproject1.model.Author;
import ru.itgirl.libraryproject1.repository.AuthorRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return convertEntityToDto(author);
    }

    @Override
    public List<AuthorDto> getAuthorsByName(String name) {
        List<Author> authors = authorRepository.findAllAuthorsByName(name);
        return authors.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> getAuthorsByNameV1(String name) {
        List<Author> authors = authorRepository.findAllAuthorsByNameBySql(name);
        return authors.stream()
                .map((this::convertEntityToDto))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> getAuthorsByNameV2(String name) {
        Specification<Author> specification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });
        List<Author> authors = authorRepository.findAll(specification);
        return authors.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto) {
        Author author = authorRepository.save(convertDtoToEntity(authorCreateDto));
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto) {
        Author author = authorRepository.findById(authorUpdateDto.getId()).orElseThrow();
        author.setName(authorUpdateDto.getName());
        author.setSurname(authorUpdateDto.getSurname());
        Author savedAuthor = authorRepository.save(author);
        AuthorDto authorDto = convertEntityToDto(savedAuthor);
        return authorDto;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private Author convertDtoToEntity(AuthorCreateDto authorCreateDto) {
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname(authorCreateDto.getSurname())
                .build();
    }



    private AuthorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList = null;
        if (author.getBooks() !=null) {
            bookDtoList = author.getBooks()
                    .stream()
                    .map(book -> BookDto.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build()
                    ).toList();
        }
        AuthorDto authorDto = AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
        return authorDto;
    }
}

