package com.phamluu.nn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NNSaver {
	public void saveNetworkToFile(Network nn, String name) {
		try {
			String fullName = name + ".nn";
			FileOutputStream fileOut = new FileOutputStream(fullName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(nn);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + fullName);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public Network loadNetworkFromFile(String name) {
		Network e = null;
		try {
			FileInputStream fileIn = new FileInputStream(name + ".nn");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Network) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}

		return e;

	}

}
