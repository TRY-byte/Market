
public class Barang {
	public int stock = 0;
	public int harga = 0;
	public String nama, merek;
	public String jenis;

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getMerek() {
		return merek;
	}

	public void setMerek(String merek) {
		this.merek = merek;
	}

	public Barang(int stock, int harga, String nama, String merek){
		this.stock = stock;
		this.harga = harga;
		this.nama = nama;
		this.merek = merek;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

}
