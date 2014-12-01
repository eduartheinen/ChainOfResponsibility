package chain;

import model.File;

public abstract class FileRetriever {
	private FileRetriever next;
	
	public FileRetriever(FileRetriever next){
		this.next = next;
	}
	
	public File fetch(String filename){
		File file = getFile(filename);
		if(file == null){
			System.out.println("Arquivo não encontrado, buscando no próximo...");
			return next(filename);
		} else {
			System.out.println("Arquivo encontrado, retornando...");
			return file;
		}
	}

	protected File next(String filename) {
		if(next == null)
			throw new RuntimeException("Não foi possível recuperar");
		return next.fetch(filename);
	}
	
	protected abstract File getFile(String filename);
}
