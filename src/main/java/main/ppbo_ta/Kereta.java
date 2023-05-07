package main.ppbo_ta;

public class Kereta extends Kendaraan{
    protected String asal;
    protected int harga;
    protected int waktu = 60;
    protected String idKendaraan = "Kereta";

    public Kereta(String asal, Kota namaKota){
        this.asal = asal;
        setHarga(namaKota.getHargaKereta());
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
