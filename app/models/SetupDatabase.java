package models;


/*
 * enthält Daten für die Dropdowns
 */
public class SetupDatabase {
	
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
		ItKnowledge ittid2 = new ItKnowledge(it2.getTid());
		ItKnowledge ittid3 = new ItKnowledge(it3.getTid());
		ItKnowledge ittid4 = new ItKnowledge(it4.getTid());
		
		ittid.setTranslation(it);
		ittid2.setTranslation(it2);
		ittid3.setTranslation(it3);
		ittid4.setTranslation(it4);
		
		ittid.save();
		ittid2.save();
		ittid3.save();
		ittid4.save();
		
		/*
		 * speichert die Einsatzbereiche in die Translation Tabelle
		 */
		Translation sport = new Translation("Skifahren","Alpine");
		Translation sport2 = new Translation("Snowboard","Snowboard");
		Translation sport3 = new Translation("Langlauf","Cross-country Skiing");
		Translation sport4 = new Translation("Biathlon","Biathlon");
		Translation sport5 = new Translation("Eislaufen","Ice-skating");
		Translation sport6 = new Translation("Eishockey","Ice-hockey");
		Translation sport7 = new Translation("Skifahren","Alpine");
		
		sport.save();
		sport2.save();
		sport3.save();
		sport4.save();
		sport5.save();
		sport6.save();
		sport7.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in CurrentJob Tabelle
		 */
		PreferredWorkingArea area = new PreferredWorkingArea(sport.getTid());
		PreferredWorkingArea area2 = new PreferredWorkingArea(sport2.getTid());
		PreferredWorkingArea area3 = new PreferredWorkingArea(sport3.getTid());
		PreferredWorkingArea area4 = new PreferredWorkingArea(sport4.getTid());
		PreferredWorkingArea area5 = new PreferredWorkingArea(sport5.getTid());
		PreferredWorkingArea area6 = new PreferredWorkingArea(sport6.getTid());
		PreferredWorkingArea area7 = new PreferredWorkingArea(sport7.getTid());
		
		area.setTranslation(sport);
		area2.setTranslation(sport2);
		area3.setTranslation(sport3);
		area4.setTranslation(sport4);
		area5.setTranslation(sport5);
		area6.setTranslation(sport6);
		area7.setTranslation(sport7);

		area.save();
		area2.save();
		area3.save();
		area4.save();
		area5.save();
		area6.save();
		area7.save();
		
		/*
		 * speichert die Sprachen in die Translation Tabelle
		 */
		Translation language = new Translation ("deutsch","german");
		Translation language2 = new Translation ("englisch","english");
		Translation language3 = new Translation ("spanisch","spanish");
		Translation language4 = new Translation ("italienisch","italian");
		Translation language5 = new Translation ("rumänisch","romanian");
		Translation language6 = new Translation ("russisch","russian");
		Translation language7 = new Translation ("chinesisch","chinese");
		Translation language8 = new Translation ("französisch","french");
		Translation language9 = new Translation ("arabisch","arabic");
		Translation language10 = new Translation ("tschechisch","czech");
		
		language.save();
		language2.save();
		language3.save();
		language4.save();
		language5.save();
		language6.save();
		language7.save();
		language8.save();
		language9.save();
		language10.save();
		
		/*
		 * Primärschlüssel der Translation Tabelle verweist auf Fremdschlüssel in Language Tabelle
		 */
		Language langtid = new Language(language.getTid());
		Language langtid2 = new Language(language2.getTid());
		Language langtid3 = new Language(language3.getTid());
		Language langtid4 = new Language(language4.getTid());
		Language langtid5 = new Language(language5.getTid());
		Language langtid6 = new Language(language6.getTid());
		Language langtid7 = new Language(language7.getTid());
		Language langtid8 = new Language(language8.getTid());
		Language langtid9 = new Language(language9.getTid());
		Language langtid10 = new Language(language10.getTid());
		
		langtid.setTranslation(language);
		langtid2.setTranslation(language2);
		langtid3.setTranslation(language3);
		langtid4.setTranslation(language4);
		langtid5.setTranslation(language5);
		langtid6.setTranslation(language6);
		langtid7.setTranslation(language7);
		langtid8.setTranslation(language8);
		langtid9.setTranslation(language9);
		langtid10.setTranslation(language10);
		
		langtid.save();
		langtid2.save();
		langtid3.save();
		langtid4.save();
		langtid5.save();
		langtid6.save();
		langtid7.save();
		langtid8.save();
		langtid9.save();
		langtid10.save();
		
		
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
