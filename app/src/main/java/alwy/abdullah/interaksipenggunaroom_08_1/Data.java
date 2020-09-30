package alwy.abdullah.interaksipenggunaroom_08_1;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    String nama, nomerInduk, jenisKelamin, tanggalLahir, jurusan;

    public String getNama() {
        return nama;
    }

    public String getNomerInduk() {
        return nomerInduk;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getJurusan() {
        return jurusan;
    }

    public Data(String nama, String nomerInduk, String jenisKelamin, String tanggalLahir, String jurusan) {
        this.nama = nama;
        this.nomerInduk = nomerInduk;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.jurusan = jurusan;
    }

    protected Data(Parcel in) {
        nama = in.readString();
        nomerInduk = in.readString();
        jenisKelamin = in.readString();
        tanggalLahir = in.readString();
        jurusan = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(nomerInduk);
        parcel.writeString(jenisKelamin);
        parcel.writeString(tanggalLahir);
        parcel.writeString(jurusan);
    }
}
