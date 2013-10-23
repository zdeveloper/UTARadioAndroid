package com.mobi.utaradioandroid;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler {
	
	private String songNameString;
	private String artistNameString;
	private boolean songName= false;
	private boolean artistName = false;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if(localName.equalsIgnoreCase("title"))
		{
			songName = true;
		} 
		else if (localName.equals("artist"))
		{
			artistName = true;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//this.characters = ch.toString();
		if(songName){
			
			songName = false;
			songNameString =  new String(ch, start, length) ;
			
		} else if(artistName){
			
			artistName = false;
			artistNameString = new String(ch, start, length);
			
		}
	}
	
	public String getSong() {
		return this.songNameString;
	}
	
	public String getArtist() {
		return this.artistNameString;
	}

}
