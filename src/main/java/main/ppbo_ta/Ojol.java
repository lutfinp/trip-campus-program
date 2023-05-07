package main.ppbo_ta;

public class Ojol extends Kendaraan{
    protected int harga = 13000;
    protected int waktu = 20;
    protected String asal;
    protected String idKendaraan = "Ojol";


    public Ojol(String asal){
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
