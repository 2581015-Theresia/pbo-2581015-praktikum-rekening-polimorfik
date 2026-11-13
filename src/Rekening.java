import java.util.Locale;

public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin(){
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public void cetakInfo() {
        System.out.printf(
                "%s | %-6s | %12s%n",
                nomor, pemilik, formatRupiah(saldo));
    }

    protected static String formatRupiah(int angka) {
        String digit = String.format(
                Locale.US, "%,d", Math.abs(angka)
        ).replace(',', '.');


        return "Rp" + (angka < 0 ? "-" : "") + digit;
    }
}
