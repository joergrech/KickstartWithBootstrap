package kickstart

class _DemoPage {

	String	name		= "A Demo Page"

	// fields with special use (e.g., datepicker, new visual representation, etc.)
	Date	myDate
	Date	myDate2		// for testing standard grails datepicker (g:datepicker)
	boolean	myBoolean

	// other fields used in the scaffolding process:
	int		myInt
	short	myShort
	long	myLong
	float	myFloat
	double	myDouble
	byte	myByte
	char	myChar

	byte[]	myByteArray
//	char[]	myCharArray			// Grails original URL scaffolding seems to have problems

//	URL			myURL			// Grails original URL scaffolding seems to have problems
	Integer		myInteger
	TimeZone	myTimeZone
	Locale		myLocale
	Currency	myCurrency

	enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
	Suit	myEnum

	/* Automatic timestamping of GORM */
	Date	dateCreated
	Date	lastUpdated

//	static belongsTo	= []	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static mappedBy		= []	// specifies which property should be used in a mapping

	static mapWith = "none"

	static constraints = {
		// make all fields nullable to speed up demo usage (e.g., saves)
		name			nullable: true

		myDate			nullable: true
		myBoolean		nullable: true

		myInt			nullable: true
		myShort			nullable: true
		myLong			nullable: true
		myFloat			nullable: true
		myDouble		nullable: true
		myByte			nullable: true
		myChar			nullable: true

		myByteArray		nullable: true
//		myCharArray		nullable: true

//		myURL			nullable: true
		myInteger		nullable: true
		myTimeZone		nullable: true
		myLocale		nullable: true
		myCurrency		nullable: true
    }

	/*
	 * Methods of the Domain Class
	 */
	@Override
	String toString() {
		name
	}

	def list () {
		return []
	}
	def count () {
		return 0
	}
	def save () {
		return true
	}
}
