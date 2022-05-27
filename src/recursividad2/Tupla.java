package recursividad2;



public class Tupla implements Comparable {
	private String nationality;
	private int occurrences;
	
	public Tupla() {
		
	}
	
	public Tupla(String nationality, int occurrences) {
		this.nationality = nationality;
		this.occurrences = occurrences;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	@Override
	public int compareTo(Object o) {
		Tupla t = (Tupla) o;
		if(t.getOccurrences() < occurrences){
            return -1;
        } else if(t.getOccurrences()==occurrences){
            return 0;
        } else{
            return 1;
        }
	}
}
