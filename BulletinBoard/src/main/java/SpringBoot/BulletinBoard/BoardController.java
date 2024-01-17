package SpringBoot.BulletinBoard;

import SpringBoot.BulletinBoard.DTO.BoardDTO;
import SpringBoot.BulletinBoard.DTO.FileDTO;
import SpringBoot.BulletinBoard.service.BoardService;
import SpringBoot.BulletinBoard.service.FileService;
import SpringBoot.BulletinBoard.util.MD5Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;
    private FileService fileService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    public BoardController(BoardService boardService, FileService fileService) {
        this.boardService = boardService;
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("postList", boardDTOList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }
    
    @PostMapping("/post")
    public String write(@RequestParam("file")MultipartFile files, BoardDTO boardDTO) {
        try {
            String origFilename = files.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
            String savePath = System.getProperty("user.dir") + "\\files";
            if(!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));

            FileDTO fileDTO = new FileDTO();
            fileDTO.setOrigFilename(origFilename);
            fileDTO.setFilename(filename);
            fileDTO.setFilePath(filePath);

            Long fileId = fileService.saveFile(fileDTO);
            boardDTO.setFileId(fileId);
            boardDTO.setFilename(origFilename);
            boardService.savePost(boardDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id")Long id, Model model) {
        BoardDTO boardDTO = boardService.getMyBoard(id);
        model.addAttribute("post", boardDTO);
        return "board/detail.html";
    }

    @GetMapping("/correction")
    public String correct(@RequestParam("id")Long id, Model model) {

        BoardDTO boardDTOList = boardService.getMyBoard(id);
        String my_id = id.toString();
        log.info(my_id);
        model.addAttribute("postList", boardDTOList);
        return "board/correction.html";
    }

    @PostMapping("/correction")
    @Transactional
    public String update(@RequestParam("file")MultipartFile files, BoardDTO boardDTO) {
        Long my_id = boardDTO.getId();
        BoardDTO myBoard = new BoardDTO();
        String temp = my_id.toString();

        myBoard = boardService.getMyBoard(my_id);
        if(myBoard!=null) {
            myBoard.setAuthor(boardDTO.getAuthor());
            myBoard.setId(boardDTO.getId());
            myBoard.setContent(boardDTO.getContent());
            myBoard.setModifiedDate(boardDTO.getModifiedDate());
            myBoard.setTitle(boardDTO.getTitle());
            try {
                String origFilename = files.getOriginalFilename();
                String filename = new MD5Generator(origFilename).toString();
                String savePath = System.getProperty("user.dir") + "\\files";
                if(!new File(savePath).exists()) {
                    try {
                        new File(savePath).mkdir();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
                String filePath = savePath + "\\" + filename;
                files.transferTo(new File(filePath));

                FileDTO fileDTO = new FileDTO();
                fileDTO.setOrigFilename(origFilename);
                fileDTO.setFilename(filename);
                fileDTO.setFilePath(filePath);

                Long fileId = fileService.saveFile(fileDTO);
                myBoard.setFileId(fileId);
                myBoard.setFilename(origFilename);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boardService.savePost(myBoard);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")Long id) {
        boardService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> fileDownload(@PathVariable("fileId")Long fileId) throws IOException {
        FileDTO fileDTO = fileService.getFile(fileId);
        Path path = Paths.get(fileDTO.getFilePath());
        Resource resource = new InputStreamResource(Files.newInputStream(path));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + fileDTO.getOrigFilename() + "\"")
                .body(resource);
    }
}
