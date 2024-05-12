import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<String> namaMahasiswa = new ArrayList<String>();
		int i = 0;
		while(true) {
			System.out.print("Masukan nama ke-" + (i+1) + ": ");
			namaMahasiswa.add(scanner.nextLine());
			try {
				if(namaMahasiswa.get(i).isEmpty()) {
					namaMahasiswa.remove(i);
					i--;
					throw new IllegalArgumentException("Nama tidak boleh kosong!");
				}else if(namaMahasiswa.get(i).equals("selesai")) {
					namaMahasiswa.remove(i);
					System.out.println("Daftar mahasiswa yang diinputkan: ");
					for (String nama : namaMahasiswa) {
						System.out.println("-" +  nama);
					}
					break;
				}
			} catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
			
			i++;
		}
	}

}
