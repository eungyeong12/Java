package SpringBoot.BulletinBoard.domain.repository;

import SpringBoot.BulletinBoard.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
