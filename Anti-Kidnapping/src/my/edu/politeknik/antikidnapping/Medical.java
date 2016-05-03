package my.edu.politeknik.antikidnapping;

public class Medical {

	int _id;
	String _name;
	String _medical_number;

	public Medical() {

	}

	public Medical(int id, String name, String _medical_number) {
		this._id = id;
		this._name = name;
		this._medical_number = _medical_number;
	}

	public Medical(String name, String _medical_number) {
		this._name = name;
		this._medical_number = _medical_number;
	}

	public int getID() {
		return this._id;
	}

	public void setID(int id) {
		this._id = id;
	}

	public String getName() {
		return this._name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public String getMedicalNumber() {
		return this._medical_number;
	}

	public void setMedicalNumber(String _medical_number) {
		this._medical_number = _medical_number;
	}

}
