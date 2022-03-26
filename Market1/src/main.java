import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] Args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Users> arr_user = new ArrayList<>();
		ArrayList<Barang> arr_barang = new ArrayList<>();

		int user_input = 0;
		boolean check_login = false;
		boolean check;
		boolean admin = false;
		int admin_input = 0;

		do {
			try {
				System.out.println("Menu");
				System.out.println("-------");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.println("");
				user_input = Integer.parseInt(scanner.nextLine());

				//Checking Input
				if (user_input == 1) {
					//Register
					System.out.println("Register");
					System.out.println("=========");
					System.out.println("Username: ");
					String username = scanner.nextLine();
					System.out.println("Password: ");
					String password = scanner.nextLine();
					System.out.println("Nama");
					String nama = scanner.nextLine();

					check = true;
					//Checking if duplicate
					for (Users user: arr_user) {
						if(user.getUsername().equals(username)){
							check = false;
							System.out.println("Duplicate");
						}
					}

					//Check if user already exist
					if (check) {
						arr_user.add(new Users(username, password, nama));
						System.out.println("Add Username");
					} else if (!check) {
						System.out.println("Username already exists");
					}

				}else if (user_input == 2) {
					System.out.println("");
					System.out.println("login");
					System.out.println("---------");
					System.out.println("Username: ");
					String username_pass = scanner.nextLine();
					System.out.println("Password: ");
					String password_pass = scanner.nextLine();
;
					if (username_pass.equals("admin") && password_pass.equals("admin")) {
						do {
							//Diselesaikan Menu User
							System.out.println("You Are An Admin");
							System.out.println("1. Tambah Barang");
							System.out.println("2. Tambah Stok");
							System.out.println("3. Daftar Users");
							System.out.println("4. Delete Barang");
							System.out.println("5. Daftar Barang");
							System.out.println("6. Exit");

							admin_input = new Scanner(System.in).nextInt();

							if(admin_input == 1){
								//Nama, Merek, Stock, Harga
								System.out.println("Jenis Barang");
								String jenis_barang = scanner.nextLine();

								System.out.println("Nama");
								String sepatuNama = scanner.nextLine();

								System.out.println("Nama Merek");
								String sepatuMerek = scanner.nextLine();

								System.out.println("Stock");
								int sepatuStock = Integer.parseInt(scanner.nextLine());

								System.out.println("Harga");
								int sepatuHarga = Integer.parseInt(scanner.nextLine());

								boolean exist = false;
								for (Barang b :arr_barang) {
									if(b.getNama().equals(sepatuNama) && b.getJenis().equals(jenis_barang)
											&& b.getMerek().equals(sepatuMerek)){
										exist = true;
									}
								}

								if(exist){
									System.out.println("Duplicate! Barang Sudah Ada: " + sepatuNama);
								}else{
									if(jenis_barang.equals("sepatu")){
										arr_barang.add(new Sepatu(sepatuStock,sepatuHarga, sepatuNama, jenis_barang));
									}else if(jenis_barang.equals("sandal")){
										arr_barang.add(new Sandal(sepatuStock,sepatuHarga, sepatuNama, jenis_barang));
									}else if(jenis_barang.equals("ransel")){
										arr_barang.add(new Ransel(sepatuStock,sepatuHarga, sepatuNama, jenis_barang));
									}else{
										System.out.println("jenis not valid!! ");
									}

								}

							}
							else if(admin_input == 2){
								System.out.println("Nama Barang");
								String nama = scanner.nextLine();
								System.out.println("Jenis Barang");
								String barang = scanner.nextLine();
								System.out.println("Berapa Stok Yang Mau Di Tambahkan! ");
								int stock = Integer.parseInt(scanner.nextLine());
								boolean ada = false;
								for (Barang b: arr_barang) {
									if(b.getNama().equals(nama) && b.getJenis().equals(barang)){
										ada = true;
										b.setStock(b.getStock() + stock);
									}
								}
								if(!ada){
									System.out.println("Barang dan Jenis Tidak Ada, Not Found 404");
								}
							}
							else if(admin_input == 3){
								int input = -1;
								do{
									int num = 1;
									for (Users u : arr_user) {
										System.out.println(num + ". " + u.getUsername() + " - "+ u.getNama() + " - "+ u.getUang());
										num++;
									}
									System.out.println("0. Back");
									System.out.println("Input ");
									input = Integer.parseInt(scanner.nextLine());
									input -=1;
									if(input > -1){
										System.out.println("detail user");
										System.out.println("--------------");
										System.out.println("nama: " + arr_user.get(input).getNama());
										System.out.println("Username: " + arr_user.get(input).getUsername());
										System.out.println("Saldo: " + arr_user.get(input).getUang());
									}
								}while(input != -1);
							}
							else if(admin_input == 4){
								System.out.println("Jenis Barang");
								String JenisBarang = scanner.nextLine();

								System.out.println("Nama Barang");
								String Barang = scanner.nextLine();

								System.out.println("Nama Merek");
								String Merek = scanner.nextLine();

								int b = 0;
								for (Barang u : arr_barang) {
									if(u.getJenis().equals(JenisBarang) && u.getNama().equals(Barang) && u.getMerek().equals(Merek)){
										arr_user.remove(u);
										break;
									}
								}
							}
						}while(admin_input != 5);
					}
					else{
						for(Users userLogin : arr_user){
							if(userLogin.getUsername().equals(username_pass) &&
									userLogin.getPassword().equals(password_pass)){
								System.out.println("Found User " + userLogin.getUsername());
							}
						}
					}

				} else if (user_input == 3) {
					System.out.println("------");
					System.out.println("Exiting");
				}else {
					System.out.println("Invalid Input");
				}

			}catch (IndexOutOfBoundsException index){
				System.out.println("Error: " + index);
				System.exit(0);
			}
		}while (user_input != 3) ;

	}
}
