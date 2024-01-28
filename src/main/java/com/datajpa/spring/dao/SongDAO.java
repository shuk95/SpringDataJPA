package com.datajpa.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datajpa.spring.entity.Song;

public interface SongDAO extends JpaRepository<Song, Integer>{

}
