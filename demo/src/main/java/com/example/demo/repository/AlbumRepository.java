package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

	
	Album getById(int id);
	List<Song> getSongsById(int id);
	
	/*
	
	@Modifying
	@Query("update Album a set a.songs=?1")
	void updateSongOfAlbum(List<Song> songs);
	
	@Modifying
	@Query("update Album a set a.artist=?1")
	void updateArtist(Artist artist);
	
	*/
	
	
	
	
	
	
}
