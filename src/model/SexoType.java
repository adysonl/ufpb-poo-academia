package model;

public enum SexoType {
	M("Masculino"), F("Feminino");

	private String sexo;

	SexoType(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}

}