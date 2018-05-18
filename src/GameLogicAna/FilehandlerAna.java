package GameLogicAna;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;

import javax.swing.filechooser.FileSystemView;

import GameLogicAna.UserAna;
import GameLogicAna.UserServiceAna;

public class FilehandlerAna {
	public static File directory = new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
			+ File.separatorChar + ".AnagramGame");
	public static File userA = new File(directory.getAbsolutePath() + "userA.obj");

	public static void makeFiles() {
		try {
			if (userA.exists() != true) {
				System.out.println(userA.createNewFile());
			}
		} catch (IOException e) {
			userA.mkdirs();
			makeFiles();
		}
	}

	public static void serialDump() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userA));
			oos.writeObject(UserServiceAna.userA);
			oos.close();
		} catch (IOException e) {
			makeFiles();
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, UserAna> getFromFile() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userA));
			Map<String, UserAna> m = (Map<String, UserAna>) ois.readObject();
			ois.close();
			return m;
		} catch (IOException | ClassNotFoundException e) {
			System.err.println(e.getMessage());
			makeFiles();
			return null;
		}
	}
}
