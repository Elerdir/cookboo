package ess.cz.server.tag.repository;

import ess.cz.server.tag.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, String> {

    Collection<TagEntity> findAllByTagName(String tagName);
}
