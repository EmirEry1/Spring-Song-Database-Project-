package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.PlaylistRepository;
import com.example.demo.repository.SongRepository;

@Service
public class MusicService {

	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ArtistRepository artistRepository;
	
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	PlaylistRepository playlistRepository;
	
	public MusicService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void saveAlbum(Album album) {
		albumRepository.save(album);
	}
	
	public void addSongToAlbum(int albumId, Song song) {
		Album album = albumRepository.getById(albumId);
		album.getSongs().add(song);
		songRepository.getById(song.getId()).setAlbum(album);
		songRepository.save(song);
		albumRepository.save(album);
		//albumRepository.updateSongOfAlbum(songs);
	}
	
	public void deleteSong(int songId) {
		songRepository.deleteById(songId);
	}
	
	public List<Song> findSongsWithArtistId(int id) {
		Artist artist = artistRepository.getById(id);
		return songRepository.getByArtist(artist);
	}
	
	public void deleteAlbum(int albumId)  {
		albumRepository.deleteById(albumId);
	}
	
	public void assignArtistToAlbum(int albumId, int artistId) {
		
		Album album = albumRepository.getById(albumId);
		album.setArtist(artistRepository.getById(artistId));
		albumRepository.save(album);
	
		//albumRepository.updateArtist(artistRepository.getById(artistId));
	}
	
	//Methods from this point on are created for test purposes
	
	public Album getAlbumById(int albumId) {
		return albumRepository.getById(albumId);
	}
	
	public Song getSongById(int songId) {
		return songRepository.getById(songId);
	}
	
	public void saveArtist(Artist artist) {
		artistRepository.save(artist);
	}
	
	public void saveSong(Song song) {
		songRepository.save(song);
	}
	public Album getAlbumOfSong(int songId) {
		return songRepository.getById(songId).getAlbum();
	}

}
