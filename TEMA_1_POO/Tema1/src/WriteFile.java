/** @author Chirila Albert */
import java.io.*;

public class WriteFile {
	
	/**
	 * Metoda ce scrie in fisierul de output
	 * @param s String ce urmeaza a fi scrisa in fisierul "queue.out"
	 * @throws IOException eroare la scrierea in fisierul "queue.out"
	 */
	public void write(String s) throws IOException {
		String file = "queue.out";
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s);
		bw.close();
	}
}
