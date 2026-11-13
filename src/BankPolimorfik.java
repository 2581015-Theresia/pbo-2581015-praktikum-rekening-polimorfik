
public class BankPolimorfik {

    public static void main(String[] args) {

        // Membuat tiga objek rekening
        Tabungan ani = new Tabungan(
                "101", "Ani", 1000000, 2.5
        );

        Tabungan citra = new Tabungan(
                "102", "Citra", 300000, 2.0
        );

        Giro budi = new Giro(
                "201", "Budi", 200000, 500000
        );

        // Percobaan membuat objek dari abstract class
        // Rekening r = new Rekening("999", "Eko", 0);
        // Error: Rekening is abstract; cannot be instantiated

        // Array untuk semua rekening
        Rekening[] semua = { ani, citra, budi };

        // Array untuk rekening yang memiliki bunga
        BerBunga[] berbunga = { ani, citra };

        // Menampilkan rekening awal
        System.out.println("========== REKENING AWAL ==========");

        for (Rekening r : semua) {
            r.cetakInfo();
        }

        // Memotong biaya admin semua rekening
        System.out.println("========== AKHIR BULAN ============");

        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();

            System.out.println(
                    r.getNomor() +
                            " biaya admin  : " +
                            Rekening.formatRupiah(biaya)
            );
        }

        // Menambahkan bunga untuk rekening berbunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();

            System.out.println(
                    b.getNomor() +
                            " bunga        : " +
                            Rekening.formatRupiah(bunga)
            );
        }

        // Menampilkan rekening akhir
        System.out.println("========== REKENING AKHIR =========");

        int totalDana = 0;

        for (Rekening r : semua) {
            r.cetakInfo();
            totalDana += r.getSaldo();
        }

        System.out.println("-----------------------------------");

        System.out.println(
                "Total dana bank : " +
                        Rekening.formatRupiah(totalDana)
        );
    }
}
