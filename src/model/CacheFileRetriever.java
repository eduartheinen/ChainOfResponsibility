package model;

import java.util.HashMap;
import java.util.Map;

import chain.FileRetriever;

public class CacheFileRetriever extends FileRetriever {
	private Map<String, File> cache = new HashMap<>();

	public CacheFileRetriever(FileRetriever next) {
		super(next);
	}

	@Override
	protected File getFile(String filename) {
		System.out.println("Buscando arquivo no cache...");
		if(cache.containsKey(filename))
			return cache.get(filename);
		return null;
	}

	protected File next(String filename){
		File file = super.next(filename);
		cache.put(filename, file);
		return file;
	}
}
