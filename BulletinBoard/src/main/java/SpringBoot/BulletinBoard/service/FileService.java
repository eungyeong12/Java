package SpringBoot.BulletinBoard.service;

import SpringBoot.BulletinBoard.DTO.FileDTO;
import SpringBoot.BulletinBoard.domain.entity.File;
import SpringBoot.BulletinBoard.domain.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDTO fileDTO) {
        return fileRepository.save(fileDTO.toEntity()).getId();
    }

    @Transactional
    public FileDTO getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDTO fileDTO = FileDTO.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDTO;
    }
}
