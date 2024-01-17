package SpringBoot.BulletinBoard.service;

import SpringBoot.BulletinBoard.DTO.BoardDTO;
import SpringBoot.BulletinBoard.domain.entity.Board;
import SpringBoot.BulletinBoard.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO.toEntity()).getId();
    }

    @Transactional
    public List<BoardDTO> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(Board board : boardList) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }

    @Transactional
    public BoardDTO getMyBoard(long id) {
        Board mybd = boardRepository.findById(id).orElse(null);

        BoardDTO build = BoardDTO.builder().id(mybd.getId())
                .author(mybd.getAuthor())
                .title(mybd.getTitle())
                .content(mybd.getContent())
                .filename(mybd.getFilename())
                .fileId(mybd.getFileId())
                .createdDate(mybd.getCreatedDate())
                .modifiedDate(mybd.getModifiedDate())
                .build();
        return build;
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
