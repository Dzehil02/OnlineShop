package by.iba.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import by.iba.entities.Catalog;

public class FileUtils {
	
	public static void writeCatalog(Catalog catalog) {
		
		try {
			FileOutputStream fos = new FileOutputStream("src/by/iba/resources/catalog.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(catalog);
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Catalog readCatalog() {
		
		try {
			FileInputStream fis = new FileInputStream("src/by/iba/resources/catalog.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Catalog catalog = (Catalog) ois.readObject();
			ois.close();
			System.out.println("ArrayList: " + catalog.getProductList());
			
			return catalog;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Catalog();
	}
}
