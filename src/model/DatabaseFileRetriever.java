package model;

import java.util.HashMap;
import java.util.Map;

import chain.FileRetriever;

public class DatabaseFileRetriever extends FileRetriever {
	private Map<String, File> database = new HashMap<>();

	public DatabaseFileRetriever(FileRetriever next) {
		super(next);
	}

	@Override
	protected File getFile(String filename) {
		System.out.println("Buscando arquivo na database...");
		if(database.containsKey(filename))
			return database.get(filename);
		return null;
	}

	protected File next(String filename){
		File file = super.next(filename);
		database.put(filename, file);
		return file;
	}
}
