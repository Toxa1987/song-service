package com.epam.esm.songservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.epam.esm.songservice.dto.SongMetadataDTO;
import com.epam.esm.songservice.entity.DeleteResponse;
import com.epam.esm.songservice.entity.SaveResponse;
import com.epam.esm.songservice.service.SongService;

@RestController
@RequestMapping("/songs")
@Validated
public class MetadataController {
  private SongService service;

  public MetadataController(SongService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<SaveResponse> saveMetadata(
      @RequestBody @ Valid SongMetadataDTO songMetadataDTO) {
    return new ResponseEntity<>(service.saveMetadata(songMetadataDTO), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SongMetadataDTO> getMetadata(
      @PathVariable @Min(value = 1, message = "Should be 1 or more.") long id) {
    return new ResponseEntity<>(service.getMetadata(id), HttpStatus.OK);
  }

  @DeleteMapping()
  public ResponseEntity<DeleteResponse> deleteSongs(
      @RequestParam @NotEmpty @Size(min = 1, max = 200, message = "Count of ids should be between 1 or 200.") long[] id) {
    return new ResponseEntity<>(new DeleteResponse(service.deleteMetadata(id)), HttpStatus.OK);
  }
}
