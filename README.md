# BookingSalonSystem

Fitur Lihat Data						
List Data Recent Reservation						
Fitur untuk menampilkan list dari object Reservation						
Reservation yang ditampilkan hanya reservation yang memiliki workstage "in process"						
List Employee						
Fitur untuk menampilkan list dari object Employee						
List Customer						
Fitur untuk menampilkan list dari object Customer						
List Reservation History + Keuntungan Total						
Fitur untuk menampilkan menampilkan semua reservation						
Keuntungan total didapat dari menjumlahkan reservation price						
Reservation price yang dijumlahkan hanya reservation yang memiliki workstage "Finish"						
						
Fitur Membuat Reservasi						
Fitur untuk booking service salon yang dapat dilakukan						
Reservation id						
Reservation id harus bersifat unique						
Reservation id bisa dimasukkan sebagai input atau diisi secara otomatis						
						
Memilih customer yang akan dibuatkan reservasi nya						
Input yang dilakukan adalah memasukkan customer id						
Jika customer id tidak ditemukan pasa list person, maka akan menampilkan pesan "Customer yang dicari tidak tersedia"						
Jika customer id tidak ditemukan pasa list person, maka akan diminta untuk input ulang customer id yang tersedia						
						
Memilih employee untuk dipekerjakan pada reservasi yang dibuat						
Input yang dilakukan adalah memasukkan employee id						
Jika employee id tidak ditemukan pasa list person, maka akan menampilkan pesan "Employee yang dicari tidak tersedia"						
Jika employeee id tidak ditemukan pasa list person, maka akan diminta untuk input ulang employee id yang tersedia						
						
Memilih service yang akan dipilih oleh customer						
Input yang dilakukan adalah memasukkan service id						
Jika service id tidak ditemukan pasa list service, maka akan menampilkan pesan "Service yang dicari tidak tersedia"						
Jika service id tidak ditemukan pasa list service, maka akan diminta untuk input ulang service id yang tersedia						
Pemilihan service bisa dilakukan secara berulang						
Ada input untuk menghentikan perulangan pemilihan service						
Service yang sudah dipilih tidak bisa dipilih kembali pada saat memasukkan service id						
Jika service id sudah ada pada pemilihan service sebelumnya, maka akan menampilkan pesan "Service sudah dipilih"						
Jika semua service berdasarkan list service sudah dipilih, maka tidak bisa melakukan pemilihan service lagi dan dilanjutkan ke proses selanjutnya						
						
Nilai workstage pada reservation secara otomatis terisi "In Process"						
Nilai reservationPrice pada reservation terisi secara otomatis berdasarkan ketentuan						
- Customer yang merupakan seorang member none tidak mendapatkan diskon						
- Customer yang merupakan seorang member silver mendapatkan diskon 5%						
- Customer yang merupakan seorang member gold mendapatkan diskon 10%						
 		
						
Fitur Finish/Cancel reservation						
Fitur untuk menampilkan list dari object Reservation						
Reservation yang ditampilkan hanya yang memiliki workstage "In process"						
Input yang dilakukan adalah memasukkan reservation id untuk mencari reservasi						
Ada input untuk kembali ke menu sebelumnya						
Reservasi yang dapat dicari hanya yang memiliki workstage "In process"						
Jika reservation id tidak ditemukan pasa list reservation, maka akan menampilkan pesan "Reservation yang dicari tidak tersedia"						
Jika reservation id yang ditemukan pasa list reservation bukan memiliki workstage dengan nilai "In process", maka akan menampilkan pesan "Reservation yang dicari sudah selesai"						
Jika reservation id tidak ditemukan pasa list reservation, maka akan diminta untuk input ulang reservation id yang tersedia						
						
Fitur Exit						
Ketika fitur ini dipilih, maka aplikasi akan selesai dijalankan						
						
Catatan						
Silahkan lengkapi class MenuService, ReservationService, PrintService dan Validation						
Boleh menambahkan Class, method/function, serta variable lainnya diluar template Sesuai dengan Kebutuhan.						
Boleh memodifikasi method/function, serta variable lainnya yang ada pada template Sesuai dengan Kebutuhan.						
						
