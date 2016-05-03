package my.edu.politeknik.antikidnapping;

public class Police {

	int _id;
	String _name;
	String _police_number;

	public Police() {

	}

	public Police(int id, String name, String _police_number) {
		this._id = id;
		this._name = name;
		this._police_number = _police_number;
	}

	public Police(String name, String _police_number) {
		this._name = name;
		this._police_number = _police_number;
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

	public String getPoliceNumber() {
		return this._police_number;
	}

	public void setPoliceNumber(String _police_number) {
		this._police_number = _police_number;
	}

}
