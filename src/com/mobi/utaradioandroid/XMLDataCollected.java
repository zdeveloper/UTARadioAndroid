package com.mobi.utaradioandroid;

public class XMLDataCollected {
	private String songName = null;
	private String artistName = null;
	
	public void setSong(String s)
	{
		this.songName = s;
	}
	
	public String getArtist()
	{
		return this.artistName;
	}
	
	public String getSong()
	{
		return this.songName;
	}
	
	public void setArtist(String a)
	{
		this.artistName = a;
	}
	
	public String dataToString()
	{
		return this.songName + "\n" + this.artistName;
	}
}
