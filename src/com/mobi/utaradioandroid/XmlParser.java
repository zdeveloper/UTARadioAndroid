package com.mobi.utaradioandroid;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.os.AsyncTask;
import android.util.Log;



public class XmlParser{
	
	//static final String baseURL = "http://radio.uta.edu/mediaplayer/nowplaying.xml";
	public String information;
	
	public String getInfo()
	{
		return this.information;
	}

	public String doInBackground(String  URL, ContentHandler XMLHandler) {
		
		try{
			 
			 URL website = new URL( URL );
			 
			 SAXParserFactory spf = SAXParserFactory.newInstance();
			 SAXParser sp = spf.newSAXParser();
			 XMLReader xr = sp.getXMLReader();
			 HandlingXMLStuff xmlHandler = (HandlingXMLStuff) XMLHandler;
			 xr.setContentHandler(xmlHandler);
			 xr.parse(new InputSource(website.openStream()));
			 this.information = xmlHandler.getInfomation();
			 
		}
		catch (Exception e)
		{
			Log.d("USER", e.toString());
		}
		
		return information;	
	}
	
}
