package SpringBoot.BulletinBoard.DTO;

import SpringBoot.BulletinBoard.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private String filename;
    private Long fileId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .filename(filename)
                .fileId(fileId)
                .build();
        return build;
    }

    @Builder
    public BoardDTO(Long id, String author, String title, String content, String filename, Long fileId, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.fileId = fileId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
