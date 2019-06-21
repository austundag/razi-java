package com.supmount.razi.model;

public class Language {
	private String code;
	private String name;
	private String nativeName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	@Override
	public String toString() {
		return "code: " + code + " " + "name: " + name + " native name: " + nativeName;
	}
}
