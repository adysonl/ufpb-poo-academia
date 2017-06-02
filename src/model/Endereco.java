package model;

public class Endereco {
	private String cidade;
	private String estado;
	private String rua;
	private String numeroDaCasa;
	
	
	public Endereco(String cidade, String estado, String rua, String numeroDaCasa) {
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.numeroDaCasa = numeroDaCasa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}
	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}
}
