package harjoitustyo.omalista;

import harjoitustyo.apulaiset.Ooperoiva;
import java.util.LinkedList;

/**
 * Geneerinen Oma lista-luokka
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public class OmaLista<E> extends LinkedList<E> implements Ooperoiva<E> {
    @SuppressWarnings("unchecked")
    public void lisää(E uusi) throws IllegalArgumentException {
        if(uusi != null && uusi instanceof Comparable){
            if(this.size() == 0){
                this.add(uusi);  
            }
            else{
                Comparable vertailtavaUusi = (Comparable)uusi;

                for(int i = 0; i < this.size(); i++){
                    Comparable vert = (Comparable)this.get(i); 

                    if (vert.compareTo(vertailtavaUusi) >= 1){
                        this.add(i, uusi);
                        break;
                    }
                    if(i == this.size() - 1){
                        this.addLast(uusi);
                        break;
                    }
                }
            } 
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}