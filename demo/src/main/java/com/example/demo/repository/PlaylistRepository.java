package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	void deleteById(int id);
	Playlist save(Playlist album);
	
}
