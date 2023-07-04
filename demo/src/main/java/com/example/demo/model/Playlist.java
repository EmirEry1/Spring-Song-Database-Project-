package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	
	//TODO: Specify Relationship
	//@ElementCollection(fetch = FetchType.LAZY)
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Song> songs = new ArrayList<>();
	

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "T_PLAYLIST_RELATIONSHIP",
	joinColumns = @JoinColumn(name = "PARENT_PLAYLIST",
	referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "CHILD_PLAYLIST",
	referencedColumnName = "ID"))
	private List<Playlist> playlist = new ArrayList<>();
	//TODO: Add Join Column

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	public Playlist() {
		// TODO Auto-generated constructor stub
	}

}
