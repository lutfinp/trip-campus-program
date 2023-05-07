package main.ppbo_ta;

public class Angkot extends Kendaraan{
    protected int harga = 5000;
    protected int waktu = 30;
    protected String asal;
    protected String idKendaraan = "Angkot";
    public Angkot(String asal){
        this.asal = asal;
    }

    @Override
    public int getHarga() {
        return harga;
    }

    @Override
    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int getWaktu() {
        return waktu;
    }

    @Override
    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    @Override
    public String getIdKendaraan(){
        return idKendaraan;
    }
}
