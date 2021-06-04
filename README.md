# ISA-team22

### ISA-team22:
| Uloga  | Student |
| ------ | ------- |
| Student 1 | / | 
| Student 2 | / | 
| Student 3 | Kristina Đurić RA 211/2017|
| Student 4 | Maja Dragojlović RA 213/2017|

Tehnologije koje koristimo:<br />
  - Backend: Java + Spring Boot<br />
  - Frontend: Vue.js + Axios<br />
  - RDBMS: PostgreSQL<br />

Pre pokretanja potrebno je instalirati:<br />
  - NodeJS v14.15.4<br />
  - PostgreSQL<br />
  - VueJS v4.5.11<br />
  - axios<br />
  - vue-bootstrap<br />

Pokretanje projekta<br />
  - Prvo je potrebno skinuti projekat sa linka https://github.com/kristinadj980/ISA-team22<br />

Baza podataka: PostgreSQL
  - Baza se nalazi na portu 5432
  - Potrebno je kreirati bazu pod nazivom isa
  - Takodje, password za bazu je: root, a username: postgres
  - U sklopu foldera resources nalazi se skripta data.sql koje se pokreće pokretanjem backend projekta.
    
Pokretanje backend-a u Eclipse-u:
  - Importovati projekat kao maven project
  - Pozicionirati se na /src/main/java/ISATeam22 i desni klik na Team22Application.java -> Run As -> Java Application 
  - Backend se nalazi na portu 8085.

Frontend:
  - U okviru NodeJS pozicionirati se na folder frontend
  - Zatim u node js terminal unesite komande:
```sh
                                $ npm install
                                $ npm run serve
```

- Frontend ce biti pokrenut na portu `8081`. 

### Potrebni podaci za logovanje:
| Uloga  | Email  | Password |
| ------ | ------ | -------- |
| Dermatologist |derma@derma| 123 |
| Pharmacist | pharma@pharma | 123 |
| Supplier | mina@mina.com| 123 |
| Patient | maja98dragojlovic@gmail.com| 123 |
*** Prilikom registracije pacijenta koristiti ovaj mail isa22project@gmail.com

### Podaci za QR kodove (/src/main/resources/qrCodes):
| Slika  | Lekovi | Dostupnost u apotekama |
| ------ | ------ | ---------------------- |
| code1 | 4 brufena, 7 aspirina | Tilia, Zegin |
| code2 | 9 xyzala, 5 aspirina | nema ni u jednoj|
| code3 | 2 aeriusa, 2 aspirina| Tilia |
| code4 | 8 aspirina | Tilia, Zegin |
| code5 | 10 xyzala, 2 aspirina , 4 brufen | nema ni u jednoj|
| code6 | 4 cetirizina, 2 brufena | Zegin |
| code7 | 6 brufena | Tilia,Zegin |
| code8 | 2 cetirizina, 2 aeriusa, 1 xyzal | nema ni u jednoj|
| code9 | 3 brufena, 2 aeriusa | Tilia |
| code10 | nevalidan QR kod | nevalidan QR kod|