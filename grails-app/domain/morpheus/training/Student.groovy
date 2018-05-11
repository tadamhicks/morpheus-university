package morpheus.training

class Student {
	String firstName
	String lastName
	String email

	static constraints = {
		firstName nullable: false
		lastName nullable: false
		email nullable: false
		email(unique: ['firstName', 'lastName'])

	}
}
