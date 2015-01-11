package models;

public class SetupDatabase {
	
	/*
	 * enthält Daten für die Dropdowns
	 */
	
	public static void setup(){
		
		SetupDatabase.setupTranslation();
		SetupDatabase.setupEvent();
		SetupDatabase.setupSizes();
		
	}

	/*
	 * speichert die Übersetzungen 
	 */
	private static void setupTranslation(){
		
		/*
		 * speichert Geschlechter in der Translationtabelle
		 */
		Translation sex1 = new Translation("maennlich","male");
		Translation sex2 = new Translation("weiblich","female");
		
		sex1.save();
		sex2.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in Sex Tabelle
		 */
		Sex sextid = new Sex(sex1.getTid());
		Sex sextid2 = new Sex(sex2.getTid());
		
		sextid.setTranslation(sex1);
		sextid2.setTranslation(sex2);
		
		sextid.save();
		sextid2.save();
		
		/*
		 * speichert den aktuellen Job in der Translationstabelle
		 */
		Translation job1 = new Translation("ausbildung","education");
		Translation job2 = new Translation("arbeiter/in","worker");
		Translation job3 = new Translation("pensioniert","retired");
		
		job1.save();
		job2.save();
		job3.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in CurrentJob Tabelle
		 */
		CurrentJob jobtid = new CurrentJob(job1.getTid());
		CurrentJob jobtid2 = new CurrentJob(job2.getTid());
		CurrentJob jobtid3 = new CurrentJob(job3.getTid());
		
		jobtid.setTranslation(job1);
		jobtid2.setTranslation(job2);
		jobtid3.setTranslation(job3);
		
		jobtid.save();
		jobtid2.save();
		jobtid3.save();
		
		/*
		 * speichert IT-Kenntnisse in der Translationstabelle
		 */
		Translation it = new Translation("MS Office","MS Office");
		Translation it2 = new Translation("IT","IT");
		Translation it3 = new Translation("Text-/Contentmanagement","text-/contentmanagment");
		Translation it4 = new Translation("Grafik-/Bildbearbeitung","graphics/layouting");
		
		it.save();
		it2.save();
		it3.save();
		it4.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in CurrentJob Tabelle
		 */
		ItKnowledge ittid = new ItKnowledge(it.getTid());
		ItKnowledge ittid2 = new ItKnowledge(it.getTid());
		ItKnowledge ittid3 = new ItKnowledge(it.getTid());
		ItKnowledge ittid4 = new ItKnowledge(it.getTid());
		
		ittid.setTranslation(it);
		ittid2.setTranslation(it2);
		ittid3.setTranslation(it3);
		ittid4.setTranslation(it4);
		
		ittid.save();
		ittid2.save();
		ittid3.save();
		ittid4.save();
		
	}
	private static void setupEvent(){
		
		Event eventname = new Event("ICG");
		
		eventname.save();
		
	}
	private static void setupSizes(){
		
		/*
		 * speichert die Größen S,M,L,XL und XXL in die Datenbank
		 */
		/** Jackengrößen*/
		JacketSizes jacketsizeS = new JacketSizes("S");
		JacketSizes jacketsizeM = new JacketSizes("M");
		JacketSizes jacketsizeL = new JacketSizes("L");
		JacketSizes jacketsizeXL = new JacketSizes("XL");
		JacketSizes jacketsizeXXL = new JacketSizes("XXL");
		
		jacketsizeS.save();
		jacketsizeM.save();
		jacketsizeL.save();
		jacketsizeXL.save();
		jacketsizeXXL.save();
		
		/** Hosengrößen*/
		TrousersSizes trousersSizeS = new TrousersSizes("S");
		TrousersSizes trousersSizeM = new TrousersSizes("M");
		TrousersSizes trousersSizeL = new TrousersSizes("L");
		TrousersSizes trousersSizeXL = new TrousersSizes("XL");
		TrousersSizes trousersSizeXXL = new TrousersSizes("XXL");
		
		trousersSizeS.save();
		trousersSizeM.save();
		trousersSizeL.save();
		trousersSizeXL.save();
		trousersSizeXXL.save();
		
		/** Schuhgrößen*/
		ShoeSizes shoeSize36 = new ShoeSizes(36);
		ShoeSizes shoeSize37 = new ShoeSizes(37);
		ShoeSizes shoeSize38 = new ShoeSizes(38);
		ShoeSizes shoeSize39 = new ShoeSizes(39);
		ShoeSizes shoeSize40 = new ShoeSizes(40);
		ShoeSizes shoeSize41 = new ShoeSizes(41);
		ShoeSizes shoeSize42 = new ShoeSizes(42);
		
		shoeSize36.save();
		shoeSize37.save();
		shoeSize38.save();
		shoeSize39.save();
		shoeSize40.save();
		shoeSize41.save();
		shoeSize42.save();
		
		
	}
	
	
}
