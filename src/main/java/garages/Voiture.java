package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private final List<Stationnement> myStationnements = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}
		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?
                if(this.estDansUnGarage() == true){
                    throw new Exception ("La voiture est déjà stationnée dans un garage.");
                }
		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);
                }
	
	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
                if(this.estDansUnGarage() == false){
                    throw new Exception ("La voiture n'est pas stationnée dans un garage.");
                        }
                this.myStationnements.get(myStationnements.size() - 1).terminer();
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
                Set<Garage> gset = new HashSet<>();
		for (int i = 0; i <= this.myStationnements.size() - 1; i++){
                    gset.add(this.myStationnements.get(i).getGarage());
		}
		return gset;
        }

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		// Vrai si le dernier stationnement est en cours
        if(this.myStationnements.size() > 0){
            return this.myStationnements.get(myStationnements.size() - 1).estEnCours();
        } else {return false;}
	}
	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
            String imp ="";
		Set<Garage> garage = this.garagesVisites();
		for (Garage g : garage) {
			imp +=g.toString()+":\n";
			for (Stationnement st : this.myStationnements){
				if(st.getCar() == this && st.getGarage() == g) {
					imp +="\t"+st.toString()+"\n";
				}
			}
		}
		out.print(imp);

}

}
