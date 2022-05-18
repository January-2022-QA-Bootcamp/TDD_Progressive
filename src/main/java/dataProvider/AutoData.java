package dataProvider;

public class AutoData {

	private String zipCode;
	private String firstName;
	private char middleName;
	private String lastName;
	private String suffix;
	private String dob;
	private String address;
	private String aptNo;
	private String city;
	private boolean isPOBox;
	private String vYear;
	private String vMake;
	private String vModel;
	private String bodyType;
	private String primaryUse;
	private boolean isRideShare;
	private String ownOrLease;
	private String ownedDuration;
	private String alarmType;
	private boolean isEnable;
	private boolean isDayTimeLamp;
	
	public AutoData(String zipCode, String firstName, char middleName, String lastName, String suffix, String dob,
			String address, String aptNo, String city, boolean isPOBox, String vYear, String vMake, String vModel,
			String bodyType, String primaryUse, boolean isRideShare, String ownOrLease, String ownedDuration,
			String alarmType, boolean isEnable, boolean isDayTimeLamp) {
		this.zipCode = zipCode;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.dob = dob;
		this.address = address;
		this.aptNo = aptNo;
		this.city = city;
		this.isPOBox = isPOBox;
		this.vYear = vYear;
		this.vMake = vMake;
		this.vModel = vModel;
		this.bodyType = bodyType;
		this.primaryUse = primaryUse;
		this.isRideShare = isRideShare;
		this.ownOrLease = ownOrLease;
		this.ownedDuration = ownedDuration;
		this.alarmType = alarmType;
		this.isEnable = isEnable;
		this.isDayTimeLamp = isDayTimeLamp;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public char getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public String getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	public String getAptNo() {
		return aptNo;
	}
	public String getCity() {
		return city;
	}
	public boolean isPOBox() {
		return isPOBox;
	}
	public String getvYear() {
		return vYear;
	}
	public String getvMake() {
		return vMake;
	}
	public String getvModel() {
		return vModel;
	}
	public String getBodyType() {
		return bodyType;
	}
	public String getPrimaryUse() {
		return primaryUse;
	}
	public boolean isRideShare() {
		return isRideShare;
	}
	public String getOwnOrLease() {
		return ownOrLease;
	}
	public String getOwnedDuration() {
		return ownedDuration;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public boolean isDayTimeLamp() {
		return isDayTimeLamp;
	}
	
}
