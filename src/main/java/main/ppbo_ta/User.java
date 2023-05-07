package main.ppbo_ta;

import java.util.ArrayList;
import java.util.List;

public class User {
        private String asal;

        List<Kendaraan> listKendaraan = new ArrayList<Kendaraan>();
        public User(String asal){
            this.asal = asal;
            setAsalKota();
        }
        protected Kota asalKota;
        public void setAsalKota(){
            if (this.asal.equals("Jakarta")){
                asalKota = new Jakarta();
            } else if (this.asal.equals("Bogor")) {
                asalKota = new Bogor();
            } else if (this.asal.equals("Bekasi")) {
                asalKota = new Bekasi();
            } else if (this.asal.equals("Tangerang")) {
                asalKota = new Tangerang();
            } else {
                asalKota = new Depok();
            }
        }

        public void setListKendaraan(String kendaraan) {
            if (kendaraan.equals("Kereta")){
                this.listKendaraan.add(new Kereta(this.asal, this.asalKota));
            } else if (kendaraan.equals("Angkot")) {
                this.listKendaraan.add(new Angkot(this.asal));
            } else if (kendaraan.equals("Ojek Online")){
                this.listKendaraan.add(new Ojol(this.asal));
            }
        }

        public String getAsal(){
            return asal;
        }

        protected int totalHarga = 0;
        public int getTotalHarga(){
            for (int i = 0; i < listKendaraan.size(); i++){
                this.totalHarga += listKendaraan.get(i).getHarga();
            }
            return totalHarga;
        }

        protected int totalWaktu = 0;
        public int getTotalWaktu(){
            for (int i = 0; i < listKendaraan.size(); i++){
                this.totalWaktu += listKendaraan.get(i).getWaktu();
            }
            return totalWaktu;
        }

        public String getSemuaKendaraan(){
            String kendaraan = "";
            for (int i = 0; i < listKendaraan.size(); i++){
                if (i == 0){
                    kendaraan +=  listKendaraan.get(i).getIdKendaraan();
                }else{
                    kendaraan +=  ", " + listKendaraan.get(i).getIdKendaraan();
                }
            }
            return kendaraan;
        }

        public List<Kendaraan> getListKendaraan(){
            return listKendaraan;
        }
}
