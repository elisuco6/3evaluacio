package Repaso3;

public class Tupla implements Comparable {
	private char paises;
	private int occurrences;

	public char getPaises() {
		return paises;
	}

	public void setPaises(char paises) {
		this.paises = paises;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public Tupla() {

	}

	public Tupla(char paises, int occurrences) {
		this.paises = paises;
		this.occurrences = occurrences;
	}

	@Override
	public int compareTo(Object o) {
		Tupla t = (Tupla) o;
		if(t.getOccurrences() < occurrences){
            return 1;
        }
		else if(t.getOccurrences() == occurrences){
            return 0;
        }
		else{
            return -1;
        }
	}
}
