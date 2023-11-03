package Exercitiu1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercitiu1 {
    public static void main(String[] args) {
        List<Angajat> angajati = new ArrayList<>();
        angajati = Angajat.citire();
        int opt;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Meniu");
            System.out.println("0-Iesire");
            System.out.println("1. Afișarea listei de angajați\n" +
                    "2. Afișarea angajaților care au salariul peste 2500 RON\n" +
                    "3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de\n" +
                    "conducere (postul conține unul din cuvintele sef sau director).\n" +
                    "4. Afișarea angajaților care nu au funcție de conducere (postul lor nu conține cuvintele\n" +
                    "director sau șef), în ordine descrescătoare a salariilor \n"+
                    "5. Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților\n" +
                    "scrise cu majuscule.\n" +
                    "6. Afișarea salariilor mai mici de 3000 de RON (doar salariile, fără alte informații)\n" +
                    "7. Afișarea datelor primului angajat al firmei.\n" +
                    "8. Afișarea de statistici referitoare la salariul angajaților. Se va afișa salariul mediu,\n" +
                    "salariul minim şi salariul maxim. \n" +
                    "9. Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”. Se vor\n" +
                    "afișa mesaje precum: „Firma are cel puțin un Ion angajat”, „Firma nu are nici un Ion\n" +
                    "angajat”\n" +
                    "10. Afișarea numărului de persoane care s-au angajat în vara anului precedent.\n");
            System.out.print("Alegeti optiunea: ");
            opt = scanner.nextInt();
            if(opt == 0)
                break;
            switch (opt) {
                case 1:
                    Angajat.afisare(angajati);
                    break;
                case 2:Angajat.afisare_filtrata1(angajati, a -> a.getSalar()>2500);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:Angajat.afisare_filtrata2(angajati, a -> a.getSalar()<3000);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Optiune gresita");
                    break;
            }
        }while(true);

    }
}
