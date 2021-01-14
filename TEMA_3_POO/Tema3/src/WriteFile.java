import java.io.*;

/** @author Chirila Albert */
public class WriteFile {
	/**
	 * Metoda scrie in fisierul de output
	 * @param s String ce urmeaza a fi scrisa in fisierul de output
	 * @param output_file fisierul de output
	 * @throws IOException eroare la scrierea in fisierul de output
	 */
	public void write(String s, String output_file) throws IOException {
		String file = output_file;
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s);
		bw.close();
	}
}
