package librarySystem;

public class Request {
	private int id;
	private String firstName, lastName, idLibrary, title, authorFirstName, authorLastName, moreInfo;
	
	public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDLibrary() {
        return idLibrary;
    }
    public void setIDLibrary(String idLibrary) {
        this.idLibrary = idLibrary;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getMoreInfo() {
        return moreInfo;
    }
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
