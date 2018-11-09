package papb.learn.fauzan.printin.Entity;

import java.util.Date;

public class Order {
    private String dokumen;
    private String tanggal;

    public Order(String dokumen, String tanggal) {
        this.dokumen = dokumen;
        this.tanggal = tanggal;
    }

    public String getDokumen() {
        return dokumen;
    }

    public void setDokumen(String dokumen) {
        this.dokumen = dokumen;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
