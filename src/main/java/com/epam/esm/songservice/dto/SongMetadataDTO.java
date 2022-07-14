package com.epam.esm.songservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SongMetadataDTO {
  private long id;
  @NotNull(message = "Validation error missing metadata")
  @Pattern(regexp = "\\w{1,99}", message = "Validation error song name should be less 100 characters.")
  private String songName;
  private String artist;
  private String album;
  @Pattern(regexp = "\\d+:\\d{2}", message = "Validation error length should be in min:sec format.")
  private String length;
  @NotNull(message = "Validation error missing metadata")
  @Min(value = 1)
  private long resourceId;
  private String year;
}
