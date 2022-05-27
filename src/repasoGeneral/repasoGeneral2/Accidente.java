package repasoGeneral2;

public class Accidente {
	
	private String tipoAccidente;
	private int veces;
	
	public Accidente(String tipoAccidente, int veces) {
		this.tipoAccidente = tipoAccidente;
		this.veces = veces;
	}

	public String getTipoAccidente() {
		return tipoAccidente;
	}
	
	public void setTipoAccidente(String tipoAccidente) {
		this.tipoAccidente = tipoAccidente;
	}
	
	public int getVeces() {
		return veces;
	}
	
	public void setVeces(int veces) {
		this.veces = veces;
	}

	@Override
	public String toString() {
		return "Accidente [tipoAccidente=" + tipoAccidente + ", veces=" + veces + "]";
	}
	
	

}
