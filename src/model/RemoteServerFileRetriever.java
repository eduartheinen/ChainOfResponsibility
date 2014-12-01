package model;

import java.util.HashMap;
import java.util.Map;

import chain.FileRetriever;

public class RemoteServerFileRetriever extends FileRetriever {
	private Map<String, File> remoteServer = new HashMap<>();

	public RemoteServerFileRetriever(FileRetriever next) {
		super(next);
		remoteServer.put("file", new File());
	}

	@Override
	protected File getFile(String filename) {
		System.out.println("Buscando arquivo no remoteServer...");
		if(remoteServer.containsKey(filename))
			return remoteServer.get(filename);
		return null;
	}

	protected File next(String filename){
		File file = super.next(filename);
		remoteServer.put(filename, file);
		return file;
	}
}
