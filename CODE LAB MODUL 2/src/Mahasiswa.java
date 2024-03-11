
public class Mahasiswa {
	String[] nama = new String[100];
	String[] nim = new String[100]; // gabisa pake integer bang kalo 15 digit :)
	String[] jurusan = new String[100];
	
	static String tampilUniversitas(){
		return "Universitas Muhammadiyah Malang";
	}
	
	public String tampilDataMahasiswa(){
		System.out.println(tampilUniversitas());
		for (int i = 0; i < nama.length; i++) {
            if (nama[i] != null) {
                System.out.println("Nama: " + nama[i] + ", NIM: " + nim[i] + ", Jurusan: " + jurusan[i]);
            }
		}
		return null;
	}
}
