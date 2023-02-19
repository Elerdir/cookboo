package ess.cz.server.tag.model;

import ess.cz.server.tag.dto.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@Entity
@Table(name = "tag")
@EqualsAndHashCode
public class TagEntity {

    @Id
    private String id;

    @Column(name = "tag_name")
    private String tagName;

    public static Collection<TagEntity> fromDtos(Collection<Tag> tags) {
        return tags.stream()
                .map(TagEntity::fromDto)
                .collect(Collectors.toList());
    }

    public static TagEntity fromDto(Tag tag) {
        return TagEntity.builder()
                .id((tag.getId() != null) ? tag.getId() : String.valueOf(UUID.randomUUID()))
                .tagName(tag.getTagName())
                .build();
    }

    public static Collection<TagEntity> fromStrings(Collection<String> newTags) {
        return newTags.stream()
                .map(t -> TagEntity.builder()
                        .id(String.valueOf(UUID.randomUUID()))
                        .tagName(t)
                        .build())
                .collect(Collectors.toList());
    }
}
