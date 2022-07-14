package com.epam.esm.songservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.esm.songservice.dto.SongMetadataDTO;
import com.epam.esm.songservice.entity.SongMetadata;
import com.epam.esm.songservice.mapper.SongMapper;

public class SongMapperTest {
    private static SongMetadataDTO songMetadataDTO;
    private static SongMetadata songMetadata;

    @BeforeAll
   static void setUp(){
        songMetadataDTO = SongMetadataDTO.builder()
                .songName("aaaaa")
                .artist("aaaa")
                .length("2:30")
                .resourceId(123)
                .year("1234")
                .build();
        songMetadata = SongMetadata.builder()
                .songName("aaaaa")
                .artist("aaaa")
                .length("2:30")
                .resourceId(123)
                .year("1234")
                .build();
    }
    @Test
    void testToDto() {
        SongMetadata actual = SongMapper.INSTANCE.toEntity(songMetadataDTO);
         Assertions.assertEquals(songMetadata,actual);
    }
}
