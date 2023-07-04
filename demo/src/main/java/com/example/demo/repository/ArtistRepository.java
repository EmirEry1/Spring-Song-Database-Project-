package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;


public interface ArtistRepository extends JpaRepository<Artist, Integer>{

	
	
	List<Song> getSongsById(int id);
	
	//@Query("select s from Song s where s.artist = 1?")
	//List<Song> getSongsByArtist(Artist artist);
	
	Artist getById(int id);
	Artist save(Artist artist);
	
}
