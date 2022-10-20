package lessontwo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import lessonone.Address;
import lessonone.Email;
import lessonone.Gender;
import lessonone.Id;
import lessonone.PhoneNumber;

public class Person {
	
	/***
	 * Atributet e kesaj klase jane
	 * 
	 *  1. id				Id						e pandryshueshme
	 *  2. name				String					i ndryshueshem
	 *  3. surname			String					i ndryshueshem
	 *  4. birthdate		GregorianCalendar		e pandryshueshme
	 *  5. gender			Gender					e pandryshueshme
	 *  6. address			Address					e ndryshueshme
	 *  7. phoneNumbers		ArrayList<PhoneNumber>	e ndryshueshme 
	 *  											nuk mund te shtohen dy numra
	 *  											telefoni te njejte 
	 *  8. emails			ArrayList<Email>		e ndryshueshme 
	 *  											nuk mund te shtohen dy emaile
	 *  											te njejte
	 **/
        
	private final Id id;
	private String name;
	private String surname;
	private GregorianCalendar birthdate;
	private Gender gender;
	private Address address;
	private ArrayList<PhoneNumber> phoneNumbers;
	private ArrayList<Email> emails;

	public Person(Gender gender) {
		this(null, null, new GregorianCalendar(), gender, null);
	}
	
	
	public Person(GregorianCalendar birthdate,
		          Gender gender) {
		this(null, null, birthdate, gender, null);
	}
	
	
	public Person(String name, 
		          String surname,
		          GregorianCalendar birthdate,
		          Gender gender) {
		this(name, surname, birthdate, gender, null);
	}
	
	public Person(String name, 
			      String surname,
			      GregorianCalendar birthdate,
			      Gender gender, 
			      Address address) {
		id = new Id();
		if(birthdate == null) {
			// ndalohet krijimi i objektit 
			birthdate = new GregorianCalendar();
		}
		if(gender == null) {
			// ndalohet krijimi i objektit
			gender = Gender.OTHER;
		}
		this.name = name;
		this.surname = surname;
//		this.birthdate = new GregorianCalendar();
//		this.birthdate.setTimeInMillis(birthdate.getTimeInMillis());
		this.birthdate = (GregorianCalendar) birthdate.clone();
		this.gender = gender;
		this.address = address;
		phoneNumbers = new ArrayList<PhoneNumber>();
		emails = new ArrayList<Email>();
	}
	
	public Id getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public GregorianCalendar getBirthdate() {
		return birthdate;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public long getBirthdateInMillis() {
		return birthdate.getTimeInMillis();
	}
	
	public GregorianCalendar getBirthdateClone() {
		return (GregorianCalendar) birthdate.clone();
	}
	
	public int getNumberOfPhoneNumbers() {
		return phoneNumbers.size();
	}
	
	public PhoneNumber getPhoneNumber(int index) {
		if(index < 0 || index >= getNumberOfPhoneNumbers()) {
			return null;
		}
		return phoneNumbers.get(index);
	}
	
	public boolean addPhoneNumber(PhoneNumber phoneNumber) {
		if(phoneNumber == null || existPhoneNumber(phoneNumber)) {
			return false;
		}
		return phoneNumbers.add(phoneNumber);
	}
	
	public boolean removePhoneNumber(int index) {
		if(index < 0 || index >= getNumberOfPhoneNumbers()) {
			return false;
		}
		phoneNumbers.remove(index);
		return true;
	}
	
	public boolean removePhoneNumber(PhoneNumber phoneNumber) {
		if(phoneNumber == null) {
			return false;
		}
		for(int i = 0; i < phoneNumbers.size(); i++) {
			PhoneNumber value = phoneNumbers.get(i);
			if(value.getOriginalOperatorNumber() == phoneNumber.getActualOperatorNumber() &&
			   value.getSimCardNumber() == phoneNumber.getSimCardNumber()) {
				return removePhoneNumber(i);
			}
		}
		return false;
	}

	private boolean existPhoneNumber(PhoneNumber phoneNumber) {
		for(PhoneNumber value : phoneNumbers) {
			if(value.getOriginalOperatorNumber() == phoneNumber.getActualOperatorNumber() &&
			   value.getSimCardNumber() == phoneNumber.getSimCardNumber()) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumberOfEmails() {
		return emails.size();
	}
	
	public Email getEmail(int index) {
		if(index < 0 || index >= getNumberOfEmails()) {
			return null;
		}
		return emails.get(index);
	}
	
	public boolean addEmail(Email email) {
		if(email == null || existEmail(email)) {
			return false;
		}
		return emails.add(email);
	}
	
	private boolean existEmail(Email email) {
		for(Email value : emails) {
			if(email.getEmail().equals(value.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removeEmail(int index) {
	    if(index < 0 || index >= getNumberOfEmails()) {
	    	return false;
	    }
	    emails.remove(index);
		return true;
	}
	
	public boolean removeEmail(Email email) {
		if( email == null) {
			return false;
		}
		for(int i = 0; i < getNumberOfEmails(); i++) {
			Email value = emails.get(i);
			if(email.getEmail().equals(value.getEmail())) {
				return removeEmail(i);
			}
		}
		return false;
	}
	
}













