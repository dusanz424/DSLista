
public class DSLista {

	public CvorDSListe prvi;
	
	public boolean praznaLista(){
		return prvi==null;
	}
	
	public void ubaciNaPocetak(int podatak){
		prvi = new CvorDSListe(podatak, null, prvi);
		if(prvi.sledeci != null){
			prvi.sledeci.prethodni = prvi;
		}
	}
	
	public void ubaciNaKraj(int podatak){
		if(prvi==null)
			ubaciNaPocetak(podatak);
		CvorDSListe pom = prvi;
		while(pom.sledeci != null)
			pom = pom.sledeci;
		CvorDSListe novi = new CvorDSListe(podatak, pom, null);
		pom.sledeci = novi;
	}
	
	public void ispisi(){
		if(prvi==null)
			return;
		CvorDSListe pom = prvi;
		while(pom != null){
			System.out.print(pom.podatak + " -> ");
			pom = pom.sledeci;
		}
		System.out.println();
	}
	
	public int izbaciSaPocetka() throws Exception{
		if(prvi==null)
			throw new Exception("Greska! Lista je prazna");
		int podatak = prvi.podatak;
		prvi = prvi.sledeci;
		return podatak;
	}
	
	public int izbaciSaKraja() throws Exception{
		if(prvi==null)
			throw new Exception("Greska! Lista je prazna");
		if(prvi.sledeci==null)
			izbaciSaPocetka();
		CvorDSListe pom = prvi;
		while(pom.sledeci.sledeci != null)
			pom = pom.sledeci;
		int podatak = pom.sledeci.podatak;
		pom.sledeci = pom.sledeci.sledeci;
		return podatak;
	}
	
	public int min(){
		if(prvi==null)
			return Integer.MAX_VALUE;
		CvorDSListe pom = prvi;
		CvorDSListe min = prvi;
		while(pom != null){
			if(pom.podatak < min.podatak)
				min = pom;
			pom = pom.sledeci;
		}
		return min.podatak;
	}
	
	public int max(){
		if(prvi==null)
			return Integer.MIN_VALUE;
		CvorDSListe pom = prvi;
		CvorDSListe max = prvi;
		while(pom != null){
			if(pom.podatak > max.podatak)
				max = pom;
			pom = pom.sledeci;
		}
		return max.podatak;
	}
	
	public CvorDSListe maxCvor(){
		if(prvi==null)
			return null;
		CvorDSListe pom = prvi;
		CvorDSListe max = prvi;
		while(pom != null){
			if(pom.podatak > max.podatak)
				max = pom;
			pom = pom.sledeci;
		}
		return max;
	}
	
	public CvorDSListe minCvor(){
		if(prvi==null)
			return null;
		CvorDSListe pom = prvi;
		CvorDSListe min = prvi;
		while(pom != null){
			if(pom.podatak < min.podatak)
				min = pom;
			pom = pom.sledeci;
		}
		return min;
	}
	
	public void maxNaPocetak(){
		if(prvi==null || prvi.sledeci==null)
			return;
		CvorDSListe max = maxCvor();
		if(max == prvi)
			return;
		CvorDSListe pom = prvi;
		while(pom.sledeci != max)
			pom = pom.sledeci;
		pom.sledeci = pom.sledeci.sledeci;
		CvorDSListe novi = new CvorDSListe(max.podatak, null, prvi);
		novi.sledeci = prvi;
		 prvi = novi;
	}
	
	public void maxNaDrugoMesto(){
		if(prvi==null || prvi.sledeci == null)
			return;
		CvorDSListe max = maxCvor();
		if(prvi.sledeci == max)
			return;
		if(max==prvi){
			int pod = prvi.sledeci.podatak;
			prvi.sledeci.podatak = prvi.podatak;
			prvi.podatak = pod;
			return;
		}
		CvorDSListe pom = prvi;
		while(pom.sledeci != max){
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci;
		CvorDSListe novi = new CvorDSListe(max.podatak, prvi, prvi.sledeci);
		prvi.sledeci.prethodni = novi;
		prvi.sledeci = novi;
	}
	
	public void minNaPocetak(){
		if(prvi==null || prvi.sledeci == null)
			return;
		CvorDSListe min = minCvor();
		if(prvi==min)
			return;
		CvorDSListe pom = prvi;
		while(pom.sledeci != min){
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci;
		CvorDSListe novi = new CvorDSListe(min.podatak, null, prvi);
		novi.sledeci = prvi;
		prvi = novi;
	}
	
	public void minNaDrugoMesto(){
		if(prvi==null || prvi.sledeci==null)
			return;
		CvorDSListe min = minCvor();
		if(min==prvi){
			int pod = prvi.sledeci.podatak;
			prvi.sledeci.podatak = prvi.podatak;
			prvi.podatak = pod;
			return;
		}
		if(prvi.sledeci==min)
			return;
		CvorDSListe pom = prvi;
		while(pom.sledeci != min)
			pom = pom.sledeci;
		pom.sledeci = pom.sledeci.sledeci;
		CvorDSListe novi = new CvorDSListe(min.podatak, prvi, prvi.sledeci);
		prvi.sledeci.prethodni = novi;
		prvi.sledeci = novi;
	}
	//Min na prvo mesto bez pomocne strukture
	public void minPrvi(){
		if(prvi==null || prvi.sledeci==null)
			return;
		CvorDSListe min = minCvor();
		if(prvi==min)
			return;
		CvorDSListe pom = prvi;
		while(pom != min)
			pom = pom.sledeci;
		while(pom.prethodni != null){
			int pod = pom.prethodni.podatak;
			pom.prethodni.podatak = pom.podatak;
			pom.podatak = pod;
			pom = pom.prethodni;
		}
	}
	//Min na drugo mesto bez pomocne strukture
	public void minDrugi(){
		if(prvi==null || prvi.sledeci==null)
			return;
		CvorDSListe min = minCvor();
		if(prvi.sledeci == min)
			return;
		if(prvi==min){
			int pod = prvi.sledeci.podatak;
			prvi.sledeci.podatak = prvi.podatak;
			prvi.podatak = pod;
			return;
		}
		CvorDSListe pom = prvi;
		while(pom != min)
			pom = pom.sledeci;
		while(pom.prethodni.prethodni != null){
			int pod = pom.prethodni.podatak;
			pom.prethodni.podatak = pom.podatak;
			pom.podatak = pod;
			pom = pom.prethodni;
		}
	}
	//Max na prvo mesto bez pomocne strukture
	public void maxPrvo(){
		if(prvi==null || prvi.sledeci==null)
			return;
		CvorDSListe max = maxCvor();
		if(max==prvi)
			return;
		CvorDSListe pom = prvi;
		while(pom != max)
			pom = pom.sledeci;
		while(pom.prethodni != null){
			int pod = pom.prethodni.podatak;
			pom.prethodni.podatak = pom.podatak;
			pom.podatak = pod;
			pom = pom.prethodni;
		}
	}
	
	//Max na drugo mesto bez pomocne strukture
	public void maxDrugo(){
		if(prvi==null || prvi.sledeci == null)
			return;
		CvorDSListe max = maxCvor();
		if(prvi.sledeci == max)
			return;
		if(prvi==max){
			int pod = prvi.sledeci.podatak;
			prvi.sledeci.podatak = prvi.podatak;
			prvi.podatak = pod;
		}
		CvorDSListe pom = prvi;
		while(pom != max)
			pom = pom.sledeci;
		while(pom.prethodni.prethodni != null){
			int pod = pom.prethodni.podatak;
			pom.prethodni.podatak = pom.podatak;
			pom.podatak = pod;
			pom = pom.prethodni;
		}
	}
	//Npr. ulaz 2->5->7->5->8->3->2-> izlaz 2+5 = 7
	public int zbirPonavljajucihElemenata(){
		if(prvi==null)
			return 0;
		int zbir = 0;
		CvorDSListe pom = prvi;
		while(pom != null){
			if(brPonavljanja(pom) > 1 && !ponovljenoRanije(pom))
				zbir += pom.podatak;
			pom = pom.sledeci;
		}
		return zbir;
	}
	
	//pomocna metoda
	public boolean ponovljenoRanije(CvorDSListe p){
		if(p==null)
			return false;
		CvorDSListe pom = prvi;
		while(pom != p){
			if(pom.podatak == p.podatak)
				return true;
			pom = pom.sledeci;
		}
		return false;
	}
	//pomocna metoda
	public int brPonavljanja(CvorDSListe p){
		if(p==null)
			return 0;
		int brojac = 0;
		CvorDSListe pom = prvi;
		while(pom != null){
			if(pom.podatak == p.podatak)
				brojac++;
			pom = pom.sledeci;
		}
		return brojac;
	}
	public static void main(String[] args){
		DSLista ds = new DSLista();
		ds.ubaciNaPocetak(2);
		ds.ubaciNaKraj(5);
		ds.ubaciNaKraj(9);
		ds.ubaciNaPocetak(6);
		ds.ispisi();
		try{
			System.out.println("Izbaceni podatak sa pocetka liste: "+ds.izbaciSaPocetka());
		}catch(Exception e){
			System.out.println("Greska: "+e.getMessage());
		}
		try{
			System.out.println("Izbaceni podatak sa kraja liste: "+ds.izbaciSaKraja());
		}catch(Exception e){
			System.out.println("Greska: "+e.getMessage());
		}
		ds.ispisi();
		System.out.println("Max element u listi: "+ds.max() + " a min: "+ds.min());
		ds.ubaciNaPocetak(3);
		ds.ubaciNaPocetak(6);
		ds.ubaciNaKraj(9);
		ds.ispisi();
		ds.maxNaPocetak();
		ds.ispisi();ds.ubaciNaKraj(35);
		ds.maxNaDrugoMesto();
		ds.ispisi();
		ds.minNaPocetak();
		ds.ispisi();
		ds.minNaDrugoMesto();
		ds.ispisi();
		ds.ubaciNaKraj(1);
		ds.minNaDrugoMesto();
		ds.ispisi();
		ds.minPrvi();
		ds.ispisi();
		ds.maxPrvo();
		ds.ispisi();
		ds.ubaciNaKraj(35);
		ds.ubaciNaPocetak(2);
		ds.ubaciNaPocetak(5);
		ds.ispisi();
		System.out.println("Zbir ponavljajucih elemenata: "+ds.zbirPonavljajucihElemenata());
		ds.minDrugi();
		ds.ispisi();
		ds.maxDrugo();
		ds.ispisi();
	}
}
