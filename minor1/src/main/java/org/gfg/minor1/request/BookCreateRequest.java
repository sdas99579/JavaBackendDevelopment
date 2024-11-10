package org.gfg.minor1.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.gfg.minor1.model.Author;
import org.gfg.minor1.model.Book;
import org.gfg.minor1.model.BookType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequest {

    @NotBlank(message="Book name should ne null")
    private String name;

    @NotBlank(message="Book No name should ne null")
    private String bookNo;

    @Positive
    private int cost;

    private BookType type;

    private String authorName;

    private String authorEmail;

    public  Book toBook() {
        return Book.builder()
                .name(this.name)
                .bookNo(this.bookNo)
                .cost(this.cost)
                .type(this.type)
                .build();
    }

    public Author toAuthor() {
        return Author.builder().name(this.authorName)
                .email(this.authorEmail)
                .build();
    }
}
