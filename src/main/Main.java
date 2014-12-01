package main;

import model.CacheFileRetriever;
import model.DatabaseFileRetriever;
import model.File;
import model.RemoteServerFileRetriever;
import chain.FileRetriever;

public class Main {
	public static void main(String[] args){
		FileRetriever remoteServer = new RemoteServerFileRetriever(null);
		FileRetriever database = new DatabaseFileRetriever(remoteServer);
		FileRetriever cache = new CacheFileRetriever(database);
		
		File file = cache.fetch("file");
	}
}
