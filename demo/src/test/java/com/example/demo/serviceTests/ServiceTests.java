package com.example.demo.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Playlist;
import com.example.demo.model.Song;
import com.example.demo.service.MusicService;

@SpringBootTest
public class ServiceTests {

	@Autowired
	MusicService musicService;
	
	Artist artist = new Artist();
	
	Playlist playlist = new Playlist();
	Song song = new Song();
	
	@Test
	@Transactional
	public void testSaveAlbum() {
	
		Album album = new Album();
		album.setName("Eryýlmaz");
		musicService.saveAlbum(album);
		assertEquals(album.getName(), musicService.getAlbumById(album.getId()).getName());
	}
	
	@Test
	public void testAddSongToAlbum() {
		
		Album album = new Album();
		album.setName("Album1");
		Song song = new Song();
		song.setName("Þarký1");
		musicService.saveAlbum(album);
		musicService.saveSong(song);
		musicService.addSongToAlbum(album.getId(), song);
		//musicService.getAlbumOfSong(song.getId());
		assertEquals(musicService.getAlbumOfSong(song.getId()), album);
	}
	
	@Test
	@Transactional
	public void testDeleteAlbum() {
		Boolean deleted = false;
		Album album = new Album();
		album.setName("Eryýlmaz");
		musicService.saveAlbum(album);
		Song song = new Song();
		song.setName("Þarký3");
		musicService.saveSong(song);
		musicService.addSongToAlbum(album.getId(), song);
		musicService.deleteAlbum(album.getId());
		try {
			musicService.getAlbumById(album.getId());
		} catch (Exception e1){
			deleted = true; 
		}
		assertTrue(deleted);
	}
	
	@Test
	@Transactional
	public void testDeleteSong() {
		Boolean deleted = false;
		Album album = new Album();
		album.setName("Album1");
		musicService.saveAlbum(album);
		Song song = new Song();
		song.setName("Þarký");
		musicService.saveSong(song);
		musicService.addSongToAlbum(album.getId(), song);
		musicService.deleteSong(song.getId());
		try {
			musicService.getSongById(song.getId());
		} catch (Exception e){
			deleted = true; 
		}
		assertTrue(deleted);
	}
	
	@Test
	@Transactional
	public void testFindSongsWithArtistId() {
		//TODO: Write Complete Test
		Artist artist = new Artist();
		artist.setName("Bilal");
		Song song1 = new Song();
		Song song2 = new Song();
		song1.setArtist(artist);
		song2.setArtist(artist);
		musicService.saveArtist(artist);
		musicService.saveSong(song1);
		musicService.saveSong(song2);
		assertEquals(2,musicService.findSongsWithArtistId(artist.getId()).size());
	}
	
	@Test
	@Transactional
	public void testAssignArtistToAlbum() {
		Album album = new Album();
		musicService.saveAlbum(album);
		Artist artist = new Artist();
		artist.setName("Bilgehan");
		musicService.saveArtist(artist);
		musicService.assignArtistToAlbum(album.getId(), artist.getId());
		assertEquals(artist.getName(),musicService.getAlbumById(album.getId()).getArtist().getName());	
	}
	
	public ServiceTests() {
		// TODO Auto-generated constructor stub
	}
	
}
