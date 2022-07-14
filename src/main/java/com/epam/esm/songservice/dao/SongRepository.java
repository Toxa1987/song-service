package com.epam.esm.songservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.esm.songservice.entity.SongMetadata;

public interface SongRepository extends JpaRepository<SongMetadata,Long> {
}
