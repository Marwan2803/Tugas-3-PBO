import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getGrade() {
        if (nilai >= 80 && nilai <= 100)
            return "A";
        else if (nilai >= 70)
            return "B";
        else if (nilai >= 60)
            return "C";
        else if (nilai >= 50)
            return "D";
        else if (nilai >= 0)
            return "E";
        else
            return "Input nilai anda salah";
    }

    public boolean isLulus() {
        return nilai >= 60;
    }

    
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

            System.out.print("Masukkan jumlah mahasiswa: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < jumlah; i++) {
                System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
                System.out.print("NIM: ");
                String nim = scanner.nextLine();
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Nilai: ");
                int nilai = scanner.nextInt();
                scanner.nextLine(); 

                Mahasiswa mhs = new Mahasiswa(nim, nama, nilai);
                mahasiswaList.add(mhs);
            }

            int totalNilai = 0;
            int lulus = 0, tidakLulus = 0;
            ArrayList<String> listA = new ArrayList<>();
            ArrayList<String> listB = new ArrayList<>();
            ArrayList<String> listC = new ArrayList<>();
            ArrayList<String> listD = new ArrayList<>();

            for (Mahasiswa mhs : mahasiswaList) {
                System.out.println("===============================");
                System.out.println("NIM   : " + mhs.nim);
                System.out.println("Nama  : " + mhs.nama);
                System.out.println("Nilai : " + mhs.nilai);
                System.out.println("Grade : " + mhs.getGrade());

                totalNilai += mhs.nilai;
                if (mhs.isLulus()) {
                    lulus++;
                } else {
                    tidakLulus++;
                }
                if (mhs.getGrade().equals("A")) {
                    listA.add(mhs.nama);
                }
                if (mhs.getGrade().equals("B")) {
                    listB.add(mhs.nama);
                }
                if (mhs.getGrade().equals("C")) {
                    listC.add(mhs.nama);
                }
                if (mhs.getGrade().equals("D")) {
                    listD.add(mhs.nama);
                }
            }

            System.out.println("===============================");
            System.out.println("Jumlah Mahasiswa: " + mahasiswaList.size());
            System.out.println("Jumlah Mahasiswa yg Lulus: " + lulus + " yaitu " + String.join(", ", listA) + " " + String.join(", ", listB) + String.join(", ", listC));
            System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + tidakLulus);
            System.out.println("Jumlah Mahasiswa dengan Nilai A: " + listA.size() + " yaitu " + String.join(", ", listA));
            System.out.println("Jumlah Mahasiswa dengan Nilai B: " + listB.size() + " yaitu " + String.join(", ", listB));
            System.out.println("Jumlah Mahasiswa dengan Nilai C: " + listB.size() + " yaitu " + String.join(", ", listC));
            System.out.println("Jumlah Mahasiswa dengan Nilai D: " + listD.size() + " yaitu " + String.join(", ", listD));
            System.out.println("Rata-rata nilai mahasiswa adalah: " + (double) totalNilai / mahasiswaList.size());
        }
    }
}
