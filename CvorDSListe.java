
public class CvorDSListe {

	int podatak;
	
	public CvorDSListe prethodni;
	public CvorDSListe sledeci;
	
	public CvorDSListe(int podatak, CvorDSListe prethodni, CvorDSListe sledeci){
		this.podatak = podatak;
		this.prethodni = prethodni;
		this.sledeci = sledeci;
	}
}
