package com.epam.esm.songservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.epam.esm.songservice.dto.SongMetadataDTO;
import com.epam.esm.songservice.entity.SongMetadata;

@Mapper
public interface SongMapper {
  SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

  SongMetadataDTO toDto(SongMetadata songMetadata);

  SongMetadata toEntity(SongMetadataDTO songMetadatadto);
}
