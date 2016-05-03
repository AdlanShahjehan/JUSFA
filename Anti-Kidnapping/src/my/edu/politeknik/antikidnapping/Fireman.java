package my.edu.politeknik.antikidnapping;

public class Fireman {

	int _id;
	String _name;
	String _fireman_number;

	public Fireman() {

	}

	public Fireman(int id, String name, String _fireman_number) {
		this._id = id;
		this._name = name;
		this._fireman_number = _fireman_number;
	}

	public Fireman(String name, String _fireman_number) {
		this._name = name;
		this._fireman_number = _fireman_number;
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

	public String getFiremanNumber() {
		return this._fireman_number;
	}

	public void setFiremanNumber(String _fireman_number) {
		this._fireman_number = _fireman_number;
	}

}
