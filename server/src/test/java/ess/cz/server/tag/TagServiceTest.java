package ess.cz.server.tag;

import ess.cz.server.common.exchange.GeneralResponse;
import ess.cz.server.common.util.StatusCode;
import ess.cz.server.mock.tag.TagMock;
import ess.cz.server.tag.dto.Tag;
import ess.cz.server.tag.model.TagEntity;
import ess.cz.server.tag.repository.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @InjectMocks
    private TagService tagService;

    @Mock
    private TagRepository tagRepository;

    @BeforeEach
    void setUp() {
        tagService = new TagService(tagRepository);
    }

    @Test
    void getAllTags() {
        // Given
        TagEntity defaultTagEntity = TagMock.defaultTagEntity();
        Tag tag = Tag.fromEntity(defaultTagEntity);

        when(tagRepository.findAll())
                .thenReturn(Collections.singletonList(defaultTagEntity));
        // When
        GeneralResponse generalResponse = tagService.getAllTags();

        // Then
        verify(tagRepository)
                .findAll();

        assertThat(generalResponse, is(not(nullValue())));
        assertThat(generalResponse.getStatusCode(), is(equalTo(StatusCode.OK.getCode())));
        assertThat(generalResponse.getMessage(), is(equalTo(TagMock.IT_IS_OK)));
        assertThat(generalResponse.getObject(), is(equalTo(Collections.singletonList(tag))));
    }

    @Test
    void saveTag() {
        // Given

        // When

        // Then
    }
}