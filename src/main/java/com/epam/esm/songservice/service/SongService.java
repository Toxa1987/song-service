package com.epam.esm.songservice.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.epam.esm.songservice.dao.SongRepository;
import com.epam.esm.songservice.dto.SongMetadataDTO;
import com.epam.esm.songservice.entity.SaveResponse;
import com.epam.esm.songservice.entity.SongMetadata;
import com.epam.esm.songservice.exception.ResourceNotFoundException;
import com.epam.esm.songservice.mapper.SongMapper;

@Service
@Transactional
public class SongService {
private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public SaveResponse saveMetadata(SongMetadataDTO songMetadataDTO){
    System.out.println();
        SongMetadata songMetadata = SongMapper.INSTANCE.toEntity(songMetadataDTO);
        songRepository.save(songMetadata);
        return new SaveResponse(songMetadata.getId());
    }

    public SongMetadataDTO getMetadata(long id) {
       SongMetadata songMetadata = songRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Resource doesn't exist with given id"));

        return SongMapper.INSTANCE.toDto(songMetadata);}

    public List<Long> deleteMetadata(long[] ids) {
        List<Long> listOfIds = Arrays.stream(ids)
                .boxed()
                .collect(Collectors.toList());
        Iterator<Long> iterator = listOfIds.iterator();
        while (iterator.hasNext()){
            Long currentId = iterator.next();
            if(songRepository.existsById(currentId)){
                 songRepository.deleteById(currentId);
            }else{
                iterator.remove();
            }
        }
        return listOfIds;
    }
}
