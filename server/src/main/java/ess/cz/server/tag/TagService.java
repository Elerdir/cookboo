package ess.cz.server.tag;

import ess.cz.server.common.exchange.GeneralResponse;
import ess.cz.server.common.util.StatusCode;
import ess.cz.server.tag.dto.Tag;
import ess.cz.server.tag.model.TagEntity;
import ess.cz.server.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TagService {

    public static final Logger logger = LoggerFactory.getLogger(TagService.class);

    private static final String IT_IS_OK = "It's OK";

    private final TagRepository tagRepository;

    public GeneralResponse getAllTags() {
        Collection<Tag> allTags = Tag.fromEntities(tagRepository.findAll());

        return GeneralResponse.builder()
                .statusCode(StatusCode.OK.getCode())
                .message(IT_IS_OK)
                .object(allTags)
                .build();
    }

    public Tag findByTagName(String tagName) {
        Collection<Tag> tags = Tag.fromEntities(tagRepository.findAllByTagName(tagName));

        return tags.stream()
                .findFirst()
                .orElse(null);
    }

    public GeneralResponse saveTag(Tag tag) {
        logger.info("Start saving new Tag");

        Collection<TagEntity> tagsByName = tagRepository.findAllByTagName(tag.getTagName());

        if (tagsByName.size() > 0) {
            return GeneralResponse.builder()
                    .statusCode(StatusCode.NO_FOUND_TAG.getCode())
                    .message(String.format("New Tag with name '%s' existing.", tag.getTagName()))
                    .object(null)
                    .build();
        }

        tagRepository.saveAndFlush(TagEntity.fromDto(tag));
//        tagRepository.flush();

        logger.info("Finished save new Tag");

        return GeneralResponse.builder()
                .statusCode(StatusCode.OK.getCode())
                .message(String.format("New tag '%s' saved.", tag.getTagName()))
                .object(null)
                .build();
    }

    public Collection<Tag> saveAllTags(Collection<String> tags) {
        Collection<TagEntity> newTags = TagEntity.fromStrings(tags);

        tagRepository.saveAllAndFlush(newTags);

        return Tag.fromEntities(newTags);
    }
}
