package ess.cz.server.mock.tag;

import ess.cz.server.tag.dto.Tag;
import ess.cz.server.tag.model.TagEntity;

public class TagMock {

    public static final String IT_IS_OK = "It's OK";
    private static final String ID = "SADSAD-FGFDG-CXVXCV-D54FD";
    private static final String TAG_NAME = "Polívka";

    public static Tag defaultTag() {
        return Tag.builder()
                .id(ID)
                .tagName(TAG_NAME)
                .build();
    }

    public static TagEntity defaultTagEntity() {
        return TagEntity.builder()
                .id(ID)
                .tagName(TAG_NAME)
                .build();
    }
}
