package lessontwo;

import java.util.GregorianCalendar;

import extra.Util;
import lessonone.Address;
import lessonone.Gender;

public class Example1 {
	
	/***
	 *	Ne krijimin e klasave te reja, mund te ndodhe qe ne trupin e nje klase
	 *	te kemi permbajtje te plote te nje klase ekzistuese, ku shtohet kod i ri.
	 *
	 * 	A{
	 * 	antar1;
	 * 	antar2;
	 * }
	 * 
	 * B {
	 * 	antar1;
	 * 	antar2;
	 * 	dickaTjeter;
	 * }
	 * 
	 * Per situata si keto ne gjuhe te orientuara ne objekte, klasat formojne
	 * marredhenie mes tyre, pra, midis klases ekzistuese dhe asaj te re
	 * krijohet nje prej marredhenieve:
	 * 
	 * 	1. shoqerimi (association)
	 * 		a) shoqerimi (association)
	 * 
	 * 			Ne krijimin e dy klasave percaktohen ne fushat e te dhenave
	 * 			atribute me tipin e klases tjeter (nje apo me shume).	
	 * 
	 * 			A{
	 * 				tip atrA;
	 * 				tip atrB;
	 * 				B atrC;
	 * 				...
	 * 			}		
	 * 
	 * 			B{
	 * 				tip atr1;
	 * 				tip atr2;
	 * 				A atr3;
	 * 				...
	 * 			}
	 * 
	 * 			Student	 - 	Course
	 * 
	 * 			Ne klasen Student vendoset nje atribut
	 * 
	 * 				ArrayList<Course> courses;
	 * 
	 * 			per te ruajtur te dhenat e kurseve qe ndjek studenti.
	 * 
	 * 			Ne klasen Course vendoset nje atribut
	 * 
	 * 				ArrayList<Student> students;
	 * 
	 * 			per te ruajtur te dhenat e studenteve qe ndjekin kursin.
	 * 	
	 * 
	 * 		b) grumbullimi (aggregation)
	 * 
	 * 			Marredhenie shoqerimi ku vetem njera klase e perdor klasen tjeter.
	 * 			Pra vetem ne njeren klase ka atribut me tipin e klases tjeter.
	 * 			Kjo marredhenie krijon kushtet e nje raporti Pronar - Prone.
	 * 			Klasa pronare eshte klasa qe ka ne trupin e saj atribut me tipin
	 * 			e klases tjeter, asaj ekzistuese.
	 * 			Klasa pronare krijon objektin pronar.
	 * 			Klasa prone krijon objektin prone.
	 * 			Raporti mes tyre mund te shprehet zakonisht me ane te foljes "ka".
	 * 			Pronari ka prone.
	 * 			Pronari mund te jete i tille per nje prone qe ne te njejten kohe
	 * 			mund ta kete edhe dikush tjeter.
	 * 
	 * 			Psh, banoret e nje shtepie jane qe te gjithe pronare te saj.
	 * 
	 * 			Studentet kane nje adrese ku jetojne.
	 * 
	 * 			Student {
	 * 				...
	 * 				private Address address;
	 * 				...
	 * 			} 
	 * 
	 * 		c) kompozimi/perberje (composition)
	 * 
	 * 			Eshte marredhenie grumbullimi, ku pronari i prones eshte i vetmi
	 * 			pronar i saj.
	 * 
	 * 			Nqs nuk ekziston objekti pronar nuk ekziston as objekti prone.
	 * 
	 * 	2. trashegimie (inheritance)
	 * 
	 **/
	
	public static void main(String[] args) {
		
		GregorianCalendar birth = new GregorianCalendar(1986, GregorianCalendar.SEPTEMBER, 26);
		
		Person theKing = new Person("Rigels", "Rajku", birth, Gender.MALE, 
									new Address("Albania", "Durres", null));
		
		birth.set(GregorianCalendar.DAY_OF_MONTH, 27);
		
		System.out.println(Util.millisOfDateToString(theKing.getBirthdateInMillis()));
		System.out.println(Util.millisOfDateToString(birth.getTimeInMillis()));
		
		theKing.getBirthdateClone().set(GregorianCalendar.DAY_OF_MONTH, 27);

		System.out.println(Util.millisOfDateToString(theKing.getBirthdateInMillis()));
		
	}

}
