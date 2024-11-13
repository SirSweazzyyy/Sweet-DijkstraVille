package sweet;

import javafx.application.Application;
import javafx.stage.Stage;
import sweetJFC.GestionnaireIG;
import sweetJFC.GestionnaireSuites;


/**
 * L'application Sweet.
 * 
 */
public class Sweet extends Application {

	@Override
	public void start(Stage stage) {
		GestionnaireIG gestionnaireIG=new GestionnaireIG(stage);
		GestionnaireSuites gestionnaireSuites=new GestionnaireSuites(16);
		gestionnaireIG.lancerVueSuites(gestionnaireSuites);
	}

	public static void main(String[] args) {
		launch();
	}

}