package com.mycompany.minpro12;

import model.SportFacility;
import model.Facility;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n--- Manajemen Fasilitas Olahraga ---");
                System.out.println("1. Tambah Fasilitas");
                System.out.println("2. Lihat Semua Fasilitas");
                System.out.println("3. Ubah Fasilitas");
                System.out.println("4. Hapus Fasilitas");
                System.out.println("5. Keluar");
                System.out.print("Pilih opsi: ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    switch (pilihan) {
                        case 1 -> {
                            System.out.print("Masukkan nama fasilitas: ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan tipe fasilitas: ");
                            String tipe = scanner.nextLine();
                            System.out.print("Masukkan kapasitas fasilitas: ");
                            int kapasitas = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer

                            if (kapasitas > 0) {
                                Facility fasilitasBaru = new SportFacility(nama, tipe, kapasitas);
                                SportFacilityService.addFacility(fasilitasBaru);
                            } else {
                                System.out.println("Kapasitas harus lebih dari 0.");
                            }
                        }
                        case 2 -> SportFacilityService.viewFacilities();
                        case 3 -> {
                            System.out.print("Masukkan nama fasilitas yang akan diubah: ");
                            String namaLama = scanner.nextLine();
                            System.out.print("Masukkan tipe baru fasilitas: ");
                            String tipeBaru = scanner.nextLine();
                            System.out.print("Masukkan kapasitas baru fasilitas: ");
                            int kapasitasBaru = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer

                            if (kapasitasBaru > 0) {
                                SportFacilityService.updateFacility(namaLama, namaLama, tipeBaru, kapasitasBaru);
                            } else {
                                System.out.println("Kapasitas harus lebih dari 0.");
                            }
                        }
                        case 4 -> {
                            System.out.print("Masukkan nama fasilitas yang akan dihapus: ");
                            String namaFasilitas = scanner.nextLine();
                            SportFacilityService.deleteFacility(namaFasilitas);
                        }
                        case 5 -> {
                            running = false;
                            System.out.println("Keluar...");
                        }
                        default -> System.out.println("Opsi tidak valid! Silakan coba lagi.");
                    }
                } catch (Exception e) {
                    System.out.println("Input tidak valid! Masukkan nomor yang benar.");
                    scanner.nextLine(); // Clear buffer
                }
            }
        }
    }
}
