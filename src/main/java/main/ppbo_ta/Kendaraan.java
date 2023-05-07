package main.ppbo_ta;

public class Kendaraan {
    protected int harga;
    protected int waktu;
    protected String idKendaraan;

    public int getHarga(){
        return harga;
    }


    public int getWaktu(){
        return waktu;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public String getIdKendaraan(){
        return idKendaraan;
    }
}
