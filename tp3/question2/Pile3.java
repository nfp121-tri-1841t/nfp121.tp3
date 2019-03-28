package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

	private Vector<Object> vec;
private int cap; 
   public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }
	public Pile3(int taille) {
		// traiter le cas <=0
		  if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
		// à compléter
	}
	this.vec = new Vector<Object>();
        this.cap = taille;
    }
	public void empiler(Object o) throws PilePleineException {
		// à compléter
		 if(estPleine()){
                      throw new PilePleineException();
                 }
        this.vec.add(o);
	}

	public Object depiler() throws PileVideException {
		// à compléter
		 if(estVide()){
                      throw new PileVideException();
                 }
		return this.vec.remove(vec.lastIndexOf(sommet()));
	}

	public Object sommet() throws PileVideException {
		// à compléter
		 if (estVide())
            throw new PileVideException();
        return this.vec.lastElement();
		
	}

	public int taille() {
		// à compléter
		return this.vec.size();
	}

	public int capacite() {
		// à compléter
		return this.cap;
	}

	public boolean estVide() {
		// à compléter
		return this.vec.isEmpty();
	}

	public boolean estPleine() {
        return this.vec.size()==this.cap;
    }

    public String toString() {
        String s = "[";
        for (int i = this.vec.size() - 1; i >= 0; i--) {
            s+= this.vec.get(i).toString();
            if(i >0){
                s+= ", ";
            }

        }
        return s + "]"; 
    }
public boolean equals(Object o){
	if( this== o ){
            return true;
        }
        if(!(o instanceof Pile3)){
            return false;
        }
        Pile3 p = (Pile3) o;
        if(this.taille() == p.taille()){
            if(this.capacite() == p.capacite()){
               boolean estEgale = false; 
               for (int i = this.vec.size() - 1; i >= 0; i--) {
                    
                    boolean existe = false;
                    for(int j = this.vec.size() - 1; j >= 0; j--){
                        if((this.vec.get(i) == p.vec.get(i))){
                               existe = true;
                        }
                    }
                    if(existe){
                        estEgale = true;
                    } else{
                        return false;
                    }
                   
               }
                return true;
            }
                
        }
        return false;}
    


    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}