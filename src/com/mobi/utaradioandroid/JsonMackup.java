package com.mobi.utaradioandroid;

import java.util.ArrayList;
import java.util.List;

public class JsonMackup {

	private Track track;

	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public class Track {
		private Album album;
		private Artist artist;
		private String duration;
		private String id;
		private String listeners;
		private String mbid;
		private String name;
		private String playcount;
		private Streamable streamable;
		private Toptags toptags;
		private String url;
		private Wiki wiki;

		public Album getAlbum() {
			return this.album;
		}

		public void setAlbum(Album album) {
			this.album = album;
		}

		public Artist getArtist() {
			return this.artist;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}

		public String getDuration() {
			return this.duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getListeners() {
			return this.listeners;
		}

		public void setListeners(String listeners) {
			this.listeners = listeners;
		}

		public String getMbid() {
			return this.mbid;
		}

		public void setMbid(String mbid) {
			this.mbid = mbid;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPlaycount() {
			return this.playcount;
		}

		public void setPlaycount(String playcount) {
			this.playcount = playcount;
		}

		public Streamable getStreamable() {
			return this.streamable;
		}

		public void setStreamable(Streamable streamable) {
			this.streamable = streamable;
		}

		public Toptags getToptags() {
			return this.toptags;
		}

		public void setToptags(Toptags toptags) {
			this.toptags = toptags;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Wiki getWiki() {
			return this.wiki;
		}

		public void setWiki(Wiki wiki) {
			this.wiki = wiki;
		}
	}

	private class Wiki {
		private String content;
		private String published;
		private String summary;

		public String getContent() {
			return this.content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getPublished() {
			return this.published;
		}

		public void setPublished(String published) {
			this.published = published;
		}

		public String getSummary() {
			return this.summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}
	}

	private class Toptags {
		private List tag;

		public List getTag() {
			return this.tag;
		}

		public void setTag(List tag) {
			this.tag = tag;
		}
	}

	private class Tag {
		private String name;
		private String url;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	private class Streamable {
		private String text;
		private String fulltrack;

		public String gettext() {
			return this.text;
		}

		public void settext(String text) {
			this.text = text;
		}

		public String getFulltrack() {
			return this.fulltrack;
		}

		public void setFulltrack(String fulltrack) {
			this.fulltrack = fulltrack;
		}
	}

	public class Image {
		private String text;
		private String size;

		public String gettext() {
			return this.text;
		}

		public void settext(String text) {
			this.text = text;
		}

		public String getSize() {
			return this.size;
		}

		public void setSize(String size) {
			this.size = size;
		}
	}

	private class attr {
		private String position;

		public String getPosition() {
			return this.position;
		}

		public void setPosition(String position) {
			this.position = position;
		}
	}

	private class Artist {
		private String mbid;
		private String name;
		private String url;

		public String getMbid() {
			return this.mbid;
		}

		public void setMbid(String mbid) {
			this.mbid = mbid;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	public class Album {
		private attr attr;
		private String artist;
		private ArrayList<Image> image;
		private String mbid;
		private String title;
		private String url;

		public attr getattr() {
			return this.attr;
		}

		public void setattr(attr attr) {
			this.attr = attr;
		}

		public String getArtist() {
			return this.artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public ArrayList<Image> getImage() {
			return this.image ;
		}

		public void setImage(ArrayList<Image> image) {
			this.image = image;
		}

		public String getMbid() {
			return this.mbid;
		}

		public void setMbid(String mbid) {
			this.mbid = mbid;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

}
