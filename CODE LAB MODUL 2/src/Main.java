import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Mahasiswa mahasiswa = new Mahasiswa();
		try (Scanner scanner = new Scanner(System.in)) {
			int option;
			boolean cekNim = true;
			String nama = null,nim = null,jurusan = null;
			do {
			menu();
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
			case 1:
				int index = 0;
				while(mahasiswa.nama[index] !=null) {
					index++;
				}
					System.out.print("Masukan nama mahasiswa: ");
					nama = scanner.nextLine();
				while(cekNim) {
					System.out.print("Masukan NIM mahasiswa: ");
					nim =scanner.nextLine();
						if(nim.length() != 15) {
							System.out.println("NIM harus 15 digit!!!");
						}else {
							cekNim = false;
						}
				}
					System.out.print("Masukan jurusan mahasiswa: ");
					jurusan = scanner.nextLine();
				
				mahasiswa.nama[index] = nama;
				mahasiswa.nim[index] = nim;
				mahasiswa.jurusan[index] = jurusan;
				break;
			case 2:
				if(mahasiswa.nama[0] == null) {
					System.out.println("Belum ada data mahasiswa");
				}else {
					mahasiswa.tampilDataMahasiswa();
				}
				break;
			case 3:
				System.out.println("Thank you!");
				break;
			}
			}while(option!=3);
		}
	}
	public static void menu() {
		System.out.println("Menu:");
		System.out.println("1. Tambah Data Mahasiswa");
		System.out.println("2. Tampilkan Data Mahasiswa");
		System.out.println("3. Keluar");
		System.out.print("Pilihan Anda: ");
	}
}
