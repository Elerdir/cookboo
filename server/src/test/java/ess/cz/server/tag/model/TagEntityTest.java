package ess.cz.server.tag.model;

import ess.cz.server.mock.tag.TagMock;
import ess.cz.server.tag.dto.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class TagEntityTest {

    @Test
    void fromDtos() {
        // Given
        Tag tag = TagMock.defaultTag();

        // When
        TagEntity tagEntity = TagEntity.fromDto(tag);

        // Then
        assertThat(tagEntity, is(not(nullValue())));
        assertThat(tagEntity.getId(), is(tag.getId()));
        assertThat(tagEntity.getTagName(), is(tag.getTagName()));
    }

    @Test
    void fromDto() {
        // Given
        Tag tag = TagMock.defaultTag();

        // When
        Collection<TagEntity> tagEntities = TagEntity.fromDtos(Collections.singletonList(tag));

        // Then
        assertThat(tagEntities, is(not(nullValue())));
        assertThat(tagEntities.size(), is(equalTo(1)));

        TagEntity foundTag = tagEntities.stream()
                .filter(t -> t.getId().equals(tag.getId()))
                .findFirst()
                .orElse(null);

        assertThat(foundTag, is(not(nullValue())));
        assertThat(foundTag.getId(), is(tag.getId()));
        assertThat(foundTag.getTagName(), is(tag.getTagName()));
    }
}