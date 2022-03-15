package MenschAergereDichNicht;

import java.util.Random;
public class Spielfeld {
	

	// Attribute
	
	private int l=20;										// Spielfeldgr��e
	private Spielfigur[] startfeld = new Spielfigur[16]; 	// Startfeld der L�nge 16 - Spieler 1 (0-3), Spieler 2(4-7), Spieler 3(8-11), Spieler 4 (12-15)
	private Spielfigur[] zielfeld = new Spielfigur[16];  	// Zielfeld der L�nge 16 - Spieler 1 (0-3), Spieler 2(4-7), Spieler 3(8-11), Spieler 4 (12-15)
	private Spielfigur[] feld = new Spielfigur[l]; 			// Eigentliches Spielfeld
	private Spieler[] spieler;
	
	//---------------------------------------------------------------------------
	
	// Konstruktor

	public Spielfeld(Spieler... spieler) {
		this.spieler = spieler;
		
		
	}
	
	//---------------------------------------------------------------------------	
	
	// Setter und Getter

	public Spielfigur[] getStartfeld() {
		return startfeld;
	}


	public void setStartfeld(Spielfigur[] startfeld) {
		this.startfeld = startfeld;
	}


	public Spielfigur[] getZielfeld() {
		return zielfeld;
	}


	public void setZielfeld(Spielfigur[] zielfeld) {
		this.zielfeld = zielfeld;
	}


	public Spielfigur[] getFeld() {
		return feld;
	}


	public void setFeld(Spielfigur[] feld) {
		this.feld = feld;
	}

	//---------------------------------------------------------------------------
	
	// Ausgabe des Spielfeldes

	
	private static void ausgabe_spielfeld(Spielfigur[] ausgabefelder, String spielfeldname) {
		System.out.print(spielfeldname+"\t");						
		for (int z=0; z<ausgabefelder.length; z++) {
			if (ausgabefelder.length<20 && (z==4 || z==8 || z==12))  {					// Viererbl�cke im Start- und Zielfeld
				System.out.print("\t");
			}
			if (ausgabefelder[z]!=null) {												// Spielfiguren werden geschrieben
			System.out.print(ausgabefelder[z]+"\t");
			} else {
				System.out.print("O\t");												// Leere Felder werden geschrieben
			}
		}
		System.out.println();	
	}
	
	
	public void ausgabe() {																// Aufrufe der verschiedenen Spielfelder
		feld[0]=spieler[0].getFiguren()[0];
		feld[1]=spieler[1].getFiguren()[0];
		
		Spielfeld.ausgabe_spielfeld(startfeld, "Startfeld:" );
		Spielfeld.ausgabe_spielfeld(feld, "Spielfeld:" );
		Spielfeld.ausgabe_spielfeld(zielfeld, "Zielfeld:" );
	}
	
	//---------------------------------------------------------------------------
	
	// Methoden und Funktionen
		
	public int wuerfeln() {										// Methode W�rfeln
		Random r = new Random();
		int w = r.nextInt(6)+1;
		System.out.println("Sie haben eine "+w+" gew�rfelt!");
		return w;		
	}
	
	public int sucheFeldposition(Spielfigur[]sf, Spielfigur spielfigur) {
		for (int i = 0; i < sf.length; i++) {
		if (sf[i] == spielfigur) {
		return i;
		}
		}
		return -1;
		}
	
	public int ziehen(int w, int i, boolean zugMoeglich){
		if (zugMoeglich == true) {
		int neuePosition = i + w;
		return neuePosition;
		}else {
			return -1;
		}
	}
	
	public void rauswerfen(int neuePosition, int i) {
		if (neuePosition == null) {
			
		}
	}
	
}
