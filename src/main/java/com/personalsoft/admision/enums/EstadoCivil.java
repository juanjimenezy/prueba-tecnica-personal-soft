package com.personalsoft.admision.enums;

public enum EstadoCivil {
	
S("Soltero"), C("Casado");
	
	private String value;
	
	private EstadoCivil() {
		
	}
	
	private EstadoCivil(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
