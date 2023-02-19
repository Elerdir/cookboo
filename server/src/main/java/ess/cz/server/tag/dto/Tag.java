package ess.cz.server.tag.dto;

import ess.cz.server.tag.exchange.TagRequest;
import ess.cz.server.tag.model.TagEntity;
import lombok.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Tag {

    private String id;

    private String tagName;

    public static Collection<Tag> fromEntities(Collection<TagEntity> tags) {
        return tags.stream()
                .map(Tag::fromEntity)
                .collect(Collectors.toList());
    }

    public static Tag fromEntity(TagEntity tag) {
        return Tag.builder()
                .id(tag.getId())
                .tagName(tag.getTagName())
                .build();
    }

    public static Tag fromRequest(TagRequest tagRequest) {
        return Tag.builder()
                .tagName(tagRequest.getTagName())
                .build();
    }
}
