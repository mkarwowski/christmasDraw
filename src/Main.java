import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String args[]) {
		ArrayList<Osoba> arr = new ArrayList<>();
		Osoba mariusz = new Osoba("Mariusz");
		Osoba asiaM = new Osoba("Asia M", mariusz);
		mariusz.setPara(asiaM);
		Osoba darek = new Osoba("Darek");
		Osoba asiaK = new Osoba("Asia K", darek);
		darek.setPara(asiaK);
		Osoba ania = new Osoba("Ania");
		Osoba janusz = new Osoba("Janusz", ania);
		ania.setPara(janusz);
		Osoba maria = new Osoba("Maria");
		Osoba tomek = new Osoba("Tomek", maria);
		maria.setPara(tomek);
		
		arr.add(ania);
		arr.add(janusz);
		arr.add(darek);
		arr.add(asiaK);
		arr.add(tomek);
		arr.add(maria);
		arr.add(mariusz);
		arr.add(asiaM);
		
		ArrayList<Osoba> cp = new ArrayList<>(arr);
		
		ArrayList<String> wynik = new ArrayList<>();
		
		int i = 0;
		
		while (!arr.isEmpty()) {
			String str = arr.get(i).imie;
			Random r = new Random();
			int rand = r.nextInt(cp.size());
			
			if (arr.get(i) != cp.get(rand) && arr.get(i).imie != cp.get(rand).para.imie) {
				wynik.add(arr.get(i).imie);
				wynik.add(cp.get(rand).imie);
				arr.remove(i);
				cp.remove(rand);
			}
		}
		
		for (i = 0; i < wynik.size(); i = i + 2) {
			System.out.println(wynik.get(i)+" kupuje prezent dla "+ wynik.get(i+1));
		}
	}
}

class Osoba {
	public String imie;
	public Osoba para;
	
	public Osoba(String imie) {
		this.imie = imie;
	}
	
	public Osoba(String imie, Osoba para) {
		this.imie = imie;
		this.para = para;
	}
	
	public void setPara(Osoba para) {
		this.para = para;
	}
}
