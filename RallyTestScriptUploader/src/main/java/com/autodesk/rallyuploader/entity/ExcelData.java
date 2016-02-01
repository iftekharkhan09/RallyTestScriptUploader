package com.autodesk.rallyuploader.entity;

public class ExcelData {
	private int testscenerioid;

	public int getTestscenerioid() {
		return testscenerioid;
	}

	public void setTestscenerioid(int testscenerioid) {
		this.testscenerioid = testscenerioid;
	}

	private int rowno;
	private int columnno;

	public int getRowno() {
		return rowno;
	}

	public void setRowno(int rowno) {
		this.rowno = rowno;
	}

	public int getColumnno() {
		return columnno;
	}

	public void setColumnno(int columnno) {
		this.columnno = columnno;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
}
