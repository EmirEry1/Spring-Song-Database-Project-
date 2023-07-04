package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

	void deleteById(int id);
	Song getById(int id);
	Song save(Song song);
	List<Song> getByArtist(Artist artist);
} 
