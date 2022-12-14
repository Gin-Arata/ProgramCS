/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectbesar;

import com.sun.source.tree.BreakTree;
import java.awt.desktop.QuitEvent;
import java.awt.desktop.QuitResponse;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class programCS {

    static Scanner gaco = new Scanner(System.in);
    static int noRekening, pilihMenu, pinLama, counterLihat = 0, counterTambah = 0, counterTransaksi = 0, counterPembuatan = 0;
    static int counterLupa = 0;

    // Hal pribadi nasabah
    static int[] noRek = {123, 345, 567, 789, 890};
    static int[] saldoNasabah = {100, 200, 3000, 400, 500};
    static int[] pinNasabah = {123, 456, 789, 890, 234};

    // Prepare data nasabah
    static String[] namaNasabah = {"Hasan", "Joko", "Joni", "Asep", "Kaesang"};
    static String[][] dataNasabah = {
        {"06-12-2004", "Islam", "Jalan merdeka no 7, Yogyakarta, DIY", "\t085215510899"},
        {"14-02-2002", "Islam", "Jalan Kusuma no 7, Surabaya, Jawa Timur", "\t085215230899"},
        {"06-06-2006", "Islam", "Jalan Soehat No. 6, Kota Malang", "\t\t083415510899"},
        {"06-12-2003", "Buddha", "Jalan Kesemsem No. 9, Jakarta Selatan", "\t085215345299"},
        {"05-09-2005", "Hindu", "Jalan Buddha No. 89, Bali", "\t\t085215510888"}
    };

//    menu input saat transaksi nasabah
    static void transaksiNasabah14E() {
        System.out.println("");
        System.out.print("Silahkan masukkan nomor rekening Anda : "); // rekening input
        noRekening = gaco.nextInt();
        System.out.print("Silahkan masukkan pin anda : "); // pin input
        pinLama = gaco.nextInt();

        for (int i = 0; i < noRek.length; i++) {
            if (noRekening == noRek[i]) {
                if (pinLama == pinNasabah[i]) {
                    menuNasabah(i);
                    break;
                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Pin anda salah, silahkan masukkan pin ulang");
                    transaksiNasabah14E();
                    break;
                }
            }
        }
        System.out.println("Anda salah memasukkan nomer rekening");
        System.out.println("Silahkan coba lagi...");
        jedaWaktu();
        transaksiNasabah14E();
    }

//    Isi menu transaksi nasabah
    static void menuNasabah(int i) {
        System.out.println("----------------------------------------------------------");
        System.out.println("|\t Selamat datang nasabah yang terhormat \t\t |");
        System.out.println("----------------------------------------------------------");
        System.out.println("Silahkan pilih transaksi apa yang ingin anda lakukan : ");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Perubahan data nasabah");
        System.out.println("3. Tutup akun");
        System.out.println("4. Kembali");
        System.out.println("5. Keluar");
        System.out.print(" > ");
        pilihMenu = gaco.nextInt();

        if (pilihMenu == 1) {         // menu cek saldo nasabah
            System.out.println("----------------------------------------------------------");
            System.out.println("|\t            Menu Cek Saldo \t\t  \t |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Anda memiliki jumlah saldo : " + saldoNasabah[i]);
            System.out.println("----------------------------------------------------------");
            jedaWaktu();
            menuNasabah(i);
        } else if (pilihMenu == 2) { // menu ubah data nasabah
            perubahanData14E(i);
        } else if (pilihMenu == 3) {
            tutupAkun14E(i);
        } else if (pilihMenu == 4) {
            System.out.println("Anda akan dikembalikan menuju menu utama. Terima kasih!");
            jedaWaktu();
            counterTransaksi++;
            main(namaNasabah);
        } else if (pilihMenu == 5) {
            sampaiJumpa14E();
        }
    }

//    Menu perubahan data nasabah
    static void perubahanData14E(int i) {
        int pinBaru;
        String[] lengkapan = {"Agama", "Alamat", "No. telepon"};
        String[][] dataNasabahBR = new String[1][lengkapan.length];

        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Ubah Data \t\t  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.println("Silahkan pilih data apa yang ingin anda ubah : ");
        System.out.println("1. Ubah Pin");
        System.out.println("2. Ubah Data Nasabah");
        System.out.println("3. Lihat data nasabah");
        System.out.println("4. Kembali");
        System.out.println("5. Keluar");
        System.out.print(" > ");
        pilihMenu = gaco.nextInt();

        if (pilihMenu == 1) { // opsi ganti pin
            System.out.print("Silahkan masukkan pin lama Anda : ");
            pinLama = gaco.nextInt();
            if (pinLama == pinNasabah[i]) {
                System.out.print("Silahkan masukkan pin baru anda : ");
                pinBaru = gaco.nextInt();
                pinNasabah[i] = pinBaru;
                System.out.println("Selamat! pin anda sudah diubah");
                jedaWaktu();
                perubahanData14E(i);
            } else {
                System.out.println("Pin yang anda masukkan salah, silahkan masukkan ulang.");
                jedaWaktu();
                perubahanData14E(i);
            }
        } else if (pilihMenu == 2) { // opsi ubah data nasabah
            System.out.println("Silahkan masukkan data baru : ");
            for (int j = 0; j < dataNasabahBR[0].length; j++) {
                System.out.print(lengkapan[j] + " : ");
                dataNasabahBR[0][j] = gaco.next();
            }

            for (int j = 0; j < dataNasabahBR[0].length; j++) {
                dataNasabah[i][j + 1] = dataNasabahBR[0][j];
            }

            System.out.println("Perubahan data berhasil! Nasabah akan dikembalikan ke menu ubah data.");
            jedaWaktu();
            perubahanData14E(i);
        } else if (pilihMenu == 3) { // opsi lihat data nasabah saat ini
            System.out.println("Berikut adalah data nasabah saat ini : ");
            System.out.println("Nama\tTanggal Lahir\tAgama\t\t\tAlamat\t\t\t\tNo. Telpon");
            System.out.print(namaNasabah[i] + "\t");
            for (int j = 0; j < dataNasabah[0].length; j++) {
                System.out.print(dataNasabah[i][j] + "\t");
            }

            System.out.println("\nAnda akan dikembalikan ke menu ubah data...");
            jedaWaktu();
            perubahanData14E(i);
        } else if (pilihMenu == 4) { // opsi kembali
            System.out.println("Anda akan dialihkan ke menu nasabah mohon tunggu sebentar...");
            jedaWaktu();
            menuNasabah(i);
        } else if (pilihMenu == 5) { // opsi keluar
            sampaiJumpa14E();
        }
    }

//    Menu tutup akun nasabah
    static void tutupAkun14E(int i) {
        Scanner gaco2 = new Scanner(System.in);
        String yesNo;
        String[] nullArr = {null, null, null, null};
        int[] nullInt = {0};

        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Tutup Akun \t\t  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.print("Apakah anda yakin ingin melakukan penutupan akun? (y/t) ");
        yesNo = gaco2.next();

        if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("Penutupan akun akan dilakukan, mohon tunggu sebentar...");
            jedaWaktu();

            namaNasabah[i] = nullArr[0];
            noRek[i] = nullInt[0];
            saldoNasabah[i] = nullInt[0];
            pinNasabah[i] = nullInt[0];
            for (int j = 0; j < dataNasabah[0].length; j++) {
                dataNasabah[i][j] = nullArr[j];
            }

            System.out.println("Penghapusan akun berhasil! Anda akan dikembalikan ke menu utama");
            jedaWaktu();
            main(nullArr);
        } else {
            menuNasabah(i);
        }
    }

    // menu lihat data nasabah saat ini
    static void lihatDataNasabah14E() {
        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Lihat Data \t\t  \t |");
        System.out.println("----------------------------------------------------------\n");
        System.out.println("Nama\tTanggal Lahir\tAgama\t\t\tAlamat\t\t\t\tNo. Telpon");
        for (int i = 0; i < dataNasabah.length; i++) {
            System.out.print(namaNasabah[i] + "\t");
            for (int j = 0; j < dataNasabah[0].length; j++) {
                System.out.print(dataNasabah[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("Anda akan dikembalikan menuju menu utama...");
        jedaWaktu();
        counterLihat++;
        main(namaNasabah);
    }

//  Menu tambah data nasabah
    static void tambahdataNasabah14E() {
        Scanner gacoInputData = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Tambah Data \t\t  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.print("Masukkan banyaknya nasabah baru : ");
        int a = gacoInputData.nextInt();
        String[] lengkapan = {"Nama", "Tanggal Lahir", "Agama", "No. Telepon", "Alamat", "Jenis tabungan(Konvensional/Giro)"};
        String[][] gacoInput = new String[a][lengkapan.length];

        System.out.println("*Dikarenakan kekurangan kemampuan saya di java. Akan ada bug saat input data");
        jedaWaktu();
        System.out.println("*Dimohon untuk para penguji menggunakan tanda ( _ ) atau ( - ) sebagai pengganti spasi");
        jedaWaktu();
        System.out.println("Terima kasih!\n");
        jedaWaktu();

        System.out.println("Silahkan isi data-data dibawah ini : ");
        for (int i = 0; i < gacoInput.length; i++) { // input data nasabah
            System.out.println("Nasabah ke-" + (i + 1));
            for (int j = 0; j < gacoInput[0].length; j++) {
                System.out.print(lengkapan[j] + " : ");
                gacoInput[i][j] = gacoInputData.next();
            }
            System.out.println("");
        }
        counterTambah++;
        System.out.print("Apakah ingin cek ulang data? (y/t) ");
        String yesNo = gacoInputData.next();

        if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("Nama\tTanggal Lahir\tAgama\tNo. Telpon\tAlamat\t\tJenis Tabungan");
            for (int i = 0; i < gacoInput.length; i++) {
                for (int j = 0; j < gacoInput[0].length; j++) {
                    System.out.print(gacoInput[i][j] + "\t");
                }
                System.out.println("");
            }
            System.out.println("Anda akan dikembalikan ke menu utama dalam 2 detik...");
            jedaWaktu();
            main(lengkapan);
        } else {
            System.out.println("Anda akan dikembalikan ke menu utama dalam 2 detik...");
            jedaWaktu();
            main(lengkapan);
        }
    }

//    Menu pembuatan ATM
    static void pembuatanATM14E() {
        Scanner gacoInputData = new Scanner(System.in);
        String[] lengkapan = {"Nama", "Tanggal Lahir", "Agama", "No. Telepon", "Alamat", "Jenis tabungan(Konvensional/Giro)"};
        String[][] gacoInput = new String[1][lengkapan.length];
        String pin;

        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Buat ATM \t\t  \t |");
        System.out.println("----------------------------------------------------------");

        System.out.println("*Dikarenakan kekurangan kemampuan saya di java. Akan ada bug saat input data");
        jedaWaktu();
        System.out.println("*Dimohon untuk para penguji menggunakan tanda ( _ ) atau ( - ) sebagai pengganti spasi");
        jedaWaktu();
        System.out.println("*Terima kasih!\n");
        jedaWaktu();

        System.out.println("Sebelum membuat ATM silahkan isi data dibawah ini : ");
        for (int i = 0; i < gacoInput.length; i++) {
            for (int j = 0; j < gacoInput[0].length; j++) {
                System.out.print(lengkapan[j] + " : ");
                gacoInput[i][j] = gacoInputData.next();
            }
            System.out.println("");
            System.out.println("Input data berhasil mohon tunggu beberapa detik untuk pembuatan rekening....");
            jedaWaktu();
        }

        // Source Code buat atm
        int noRek14E = randomNum14E();
        System.out.println("No Rekening Anda : " + noRek14E);
        System.out.print("Silahkan masukkan pin baru : ");
        pin = gacoInputData.next();

        // cek atm
        System.out.println("Pembuatan ATM berhasil! Silahkan cek kembali data anda : ");
        System.out.println("No Rekening anda : " + noRek14E);
        System.out.println("Pin anda : " + pin);
        System.out.println("\nNama\tTanggal Lahir\tAgama\tNo. Telpon\tAlamat\t\t\tJenis Tabungan\n");
        for (int i = 0; i < gacoInput.length; i++) {
            for (int j = 0; j < gacoInput[0].length; j++) {
                System.out.print(gacoInput[i][j] + "\t");
            }
            System.out.println("");
        }
        counterPembuatan++;
        // kembali menu/tidak
        System.out.print("Apakah anda ingin kembali ke menu? (y/t) ");
        String yesNo = gacoInputData.next();

        if (yesNo.equalsIgnoreCase("y")) {
            main(lengkapan);
        } else {
            sampaiJumpa14E();
        }
    }

//    Menu Lupa Pin
    static void lupaPin14E() {
        int nomerRek, pinBR;

        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Lupa Pin \t\t  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.println("Hai! Selamat datang di menu Lupa Pin.");
        System.out.println("Silahkan ikut beberapa prosedur berikut : ");

        System.out.print("Sillahkan masukkan nomer rekening : ");
        nomerRek = gaco.nextInt();

        for (int i = 0; i < noRek.length; i++) {
            if (nomerRek == noRek[i]) {
                System.out.print("Masukkan pin baru : ");
                pinBR = gaco.nextInt();
                pinNasabah[i] = pinBR;
                System.out.println("Pin berhasil diubah! Anda akan dikembalikan menuju menu utama");
                jedaWaktu();
                counterLupa++;
                main(namaNasabah);
                break;
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Nomer rekening anda salah silahkan masukkan ulang.");
        jedaWaktu();
        lupaPin14E();
    }

//    Menu laporan nasabah
    static void laporanNasabah14E() {
        System.out.println("----------------------------------------------------------");
        System.out.println("|\t            Menu Laporan \t\t  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.println("Hai! Selamat datang di menu laporan Nasabah");
        System.out.println("Berikut adalah beberapa laporan yang sering para nasabah ajukan : ");
        System.out.println("1. Kehilangan kartu ATM");
        System.out.println("2. ATM Rusak");
        System.out.println("3. Lupa Pin ATM");
        System.out.println("4. Lainnya");
        System.out.println("5. Kembali");
        System.out.println("6. Keluar");
        System.out.print(" > ");
        pilihMenu = gaco.nextInt();

        if (pilihMenu == 1) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Jika anda kehilangan kartu atm, anda bisa pergi menuju opsi pembuatan ATM");
            System.out.println("Berikut alurnya : ");
            System.out.println("- Pembuatan ATM -> Masukkan data diri -> Masukkan pin baru/lama anda -> Selesai");
            System.out.println("----------------------------------------------------------");
            jedaWaktu();
            laporanNasabah14E();
        } else if (pilihMenu == 2) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Jika anda mengalami kerusakan pada kartu ATM");
            System.out.println("Anda bisa melakukan pembuatan ATM baru dan saldo anda akan tetap ada di bank kami");
            System.out.println("Berikut alur pembuatannya : ");
            System.out.println("- Pembuatan ATM -> Masukkan data diri -> Masukkan pin baru/lama anda -> Selesai");
            System.out.println("----------------------------------------------------------");
            jedaWaktu();
            laporanNasabah14E();
        } else if (pilihMenu == 3) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Jika anda mengalami lupa pin anda bisa mengubah pin anda melalui\n");
            System.out.println("Menu utama kami, berikut alur perubahan pin : ");
            System.out.println("- Lupa Pin -> Masukkan No Rekening -> Masukkan pin baru -> Selesai");
            System.out.println("----------------------------------------------------------");
            jedaWaktu();
            laporanNasabah14E();
        } else if (pilihMenu == 4) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Jika anda tidak memiliki semua permasalahan diatas");
            System.out.println("Anda bisa chat kami melalui whatsapp");
            System.out.println("Nomor Whatsapp : 085215510002");
            System.out.println("----------------------------------------------------------");
            jedaWaktu();
            laporanNasabah14E();
        } else if (pilihMenu == 5) {
            main(namaNasabah);
        } else if (pilihMenu == 6) {
            sampaiJumpa14E();
        }
    }

//    Laporan kegiatan CS
    static void kegiatanCS14E() {
        int counterTotal = counterLihat + counterLupa + counterPembuatan + counterTambah + counterTransaksi;
        System.out.println("----------------------------------------------------------");
        System.out.println("|\t         Menu Laporan Kegiatan \t\t \t |");
        System.out.println("----------------------------------------------------------");
        if (counterTotal == 0) {
            System.out.println("Anda tidak melakukan kegiatan apapun...");
            System.out.println("Sistem akan otomatis memindahkan anda ke menu utama.");
            jedaWaktu();
            main(namaNasabah);
        } else {
            System.out.println("\nCS Melakukan kegiatan melihat data nasabah sebanyak : " + counterLihat);
            System.out.println("CS Melakukan kegiatan tambah data nasabah sebanyak : " + counterTambah);
            System.out.println("CS Melakukan kegiatan transaksi sebanyak : " + counterTransaksi);
            System.out.println("CS Melakukan kegiatan pembuatan ATM sebanyak : " + counterPembuatan);
            System.out.println("CS Melakukan kegiatan penggantian pin sebanyak : " + counterLupa);
            System.out.print("\nApakah anda ingin kembali ke menu utama? (y/t)");
            String yesNo = gaco.next();

            if (yesNo.equalsIgnoreCase("y")) {
                System.out.println("Mohon tunggu sebentar...");
                main(namaNasabah);
            } else {
                sampaiJumpa14E();
            }
        }

    }

//    
    public static void main(String[] args) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("|\t   Selamat datang di CS Bank Snezhnaya  \t |");
        System.out.println("----------------------------------------------------------");
        System.out.println("Silahkan pilih salah satu menu dibawah ini : ");
        System.out.println("1. Lihat data nasabah");
        System.out.println("2. Tambah data nasabah");
        System.out.println("3. Transaksi");
        System.out.println("4. Pembuatan ATM");
        System.out.println("5. Lupa Pin");
        System.out.println("6. Laporan");
        System.out.println("7. Laporan Kegiatan CS");
        System.out.println("8. Keluar");
        System.out.print(" > ");
        pilihMenu = gaco.nextInt();

        if (pilihMenu == 1) {
            lihatDataNasabah14E();
        } else if (pilihMenu == 2) {
            tambahdataNasabah14E();
        } else if (pilihMenu == 3) {
            transaksiNasabah14E();
        } else if (pilihMenu == 4) {
            pembuatanATM14E();
        } else if (pilihMenu == 5) {
            lupaPin14E();
        } else if (pilihMenu == 6) {
            laporanNasabah14E();
        } else if (pilihMenu == 7) {
            kegiatanCS14E();
        } else if (pilihMenu == 8) {
            sampaiJumpa14E();

        } else {
            System.out.println("Maaf program tidak mengerti maksud anda.");
            System.out.println("Silahkan coba lagi dalam beberapa detik...");
            jedaWaktu();
            main(args);
        }
    }

//  Kumpulan pengaturan source code
    // Pengaturan waktu
    static void jedaWaktu() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(programCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Pengaturan random number
    static int randomNum14E() {
        int max = 999999999;
        int min = 0;
        return (int) (Math.random() * (max - min + 1) + min);
    }

    // Pengaturan sampai jumpa/opsi keluar
    static void sampaiJumpa14E() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan CS Bank Snezhnaya");
        System.out.println("Semoga harimu menyenangkan!");
        System.out.println("---------------------------------------------------------------------------");
        jedaWaktu();
        System.exit(0);
    }
}
