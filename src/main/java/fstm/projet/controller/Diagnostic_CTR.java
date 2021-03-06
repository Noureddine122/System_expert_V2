package fstm.projet.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import fstm.projet.model.bo.*;
import fstm.projet.view.Acueil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.stream.Stream;

public class Diagnostic_CTR {
/*	

	public Diagnostic_CTR()
	{
		
		 
	}
	public static void charger_dia(Client c) {
		
		Acueil fram1= new Acueil(c);
		fram1.setVisible(true);
	}
public static void diagoniser(Client c,Vector<Symptoms> sys,Vector<Maladie_chronique> mal) {
	Docteur doc=new Docteur(1,"alami","ahmed");
 	
	 DroolsTest	d= new DroolsTest();
	 c.setMaladies(mal);
	 new DAOClient().updateMaladie(mal, c.getCmptCompte().getEmail());
	 
	 Diagnostic diag = new Diagnostic(1,c,sys,doc);
	
	 double resu=d.Start_Rules(diag);
	 diag.set_possi_presence(resu);
	 Acueil.Resul.setText(resu*100 + " %100");
	 new DAODiagnostic().insert(diag);
	 new DAOClient().updateDiagnostique(diag,c.getCmptCompte().getEmail() );
	 
		if(d.isEnvoy(doc)==true)
		JOptionPane.showMessageDialog(null, "possibilite de presence : " 
		+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyées aux autorités comptétentes",
		"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog( null,"possibilite de presence : " 
				+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);
	 
	 
	 
}

public static ArrayList<Symptoms> afficheSy(){
	DAOSymptom daoSymptom=new DAOSymptom();
	return daoSymptom.retreive();
}
public static ArrayList<Region> afficheRe(){
	DAORegion deDaoRegion=new DAORegion();
	return deDaoRegion.retreiveR();
}
public static void insertClient(String nom,String prenom,Boolean sexe,Calendar date,String email,String password) {
	Compte cmpCompte=new Compte(email, password);
	Client cli=new Client(nom, prenom, sexe, date, cmpCompte);
	DAOClient daoClient=new DAOClient();
	daoClient.insert(cli);
}
public static void updateClient(Client c,double temp,Region reg) {
	DAOClient daoClient=new DAOClient();
	daoClient.updateClient(c, temp, reg);
	charger_dia(c);
	
	
}
public static Client authClient (String email,String passString){
	DAOClient daoClient=new DAOClient();
return daoClient.Authentification(email, passString);
	
}

public static void rempliTable(DefaultTableModel model,Client c) {
	for(Diagnostic diag:c.getDiagnostics()) {
		model.addRow(new String[] {diag.getDate().toString(),""+diag.get_possi_presence()});
		System.out.println(diag);
	}
}
*/

    private static final String host = "192.168.31.17";
    private static final int port = 6000;

    public Diagnostic_CTR() {


    }

    public static void charger_dia(Client c, double temperature, Region r) throws IOException, ClassNotFoundException {

        Acueil fram1 = new Acueil(c, temperature, r);
        fram1.setVisible(true);
    }

    public static void diagoniser(Client c, Vector<Symptoms> sys, Vector<Maladie_chronique> mal, double temperature, Region r) throws IOException, ClassNotFoundException {
        // c.setMaladies(mal);
        Socketinter socketinter = new Socketinter(sys, c, temperature, r, mal);
        System.out.println(c.getCmptCompte().getEmail());
        Socket socket = new Socket(host, port);
        System.out.println("Connected.................");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(socketinter);
        System.out.println("Sent to server.................");
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        String obj1 = (String) ois.readObject();

        JOptionPane.showMessageDialog(null, obj1, "Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		/*Docteur doc=new Docteur(1,"alami","ahmed");
 	
	 DroolsTest	d= new DroolsTest();
	 c.setMaladies(mal);
	 new DAOClient().updateMaladie(mal, c.getCmptCompte().getEmail());
	 
	 Diagnostic diag = new Diagnostic(1,c,sys,doc);
	
	 double resu=d.Start_Rules(diag);
	 diag.set_possi_presence(resu);
	 Acueil.Resul.setText(resu*100 + " %100");
	 new DAODiagnostic().insert(diag);
	 new DAOClient().updateDiagnostique(diag,c.getCmptCompte().getEmail() );
	 
		if(d.isEnvoy(doc)) {
			JOptionPane.showMessageDialog(null, "possibilite de presence : "
			+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoy�es aux autorit�s compt�tentes",
			"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog( null,"possibilite de presence : "
					+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		}*/


    }

    public static ArrayList<Symptoms> afficheSy() throws IOException, ClassNotFoundException {
        Socket socket = new Socket(host, port);
        System.out.println("Connected.................");

        Symptoms n = new Symptoms();
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(n);

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (ArrayList<Symptoms>) ois.readObject();
	/*//DAOSymptom daoSymptom=new DAOSymptom();
	return daoSymptom.retreive();*/
    }

    public static ArrayList<Region> afficheRe() throws IOException, ClassNotFoundException {
        Region obj2 = new Region();
        Socket socket = new Socket(host, port);
        System.out.println("Connected.................");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(obj2);

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (ArrayList<Region>) ois.readObject();
	/*DAORegion deDaoRegion=new DAORegion();
	return deDaoRegion.retreiveR();*/
    }

    public static void insertClient(String nom, String prenom, Boolean sexe, Calendar date, String email, String password) throws IOException, ClassNotFoundException {
        Compte cmpCompte = new Compte(email, password);
        Client cli = new Client(nom, prenom, sexe, date, cmpCompte);
        Socket socket = new Socket(host, port);
        System.out.println("Connected.................");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(cli);

	/*DAOClient daoClient=new DAOClient();
	daoClient.insert(cli);*/
    }

    public static void updateClient(Client c, double temp, Region reg) throws IOException, ClassNotFoundException {
	/*c.setTempareture(temp);
	c.setRegion(reg);
	SocketUpdate socketUpdate = new SocketUpdate(c,temp,reg);
	Socket socket = new Socket(host, port);
	System.out.println("Connected.................");

	OutputStream os = socket.getOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(os);
	oos.writeObject(socketUpdate);*/
		/*DAOClient daoClient=new DAOClient();
	daoClient.updateClient(c, temp, reg);*/
        charger_dia(c, temp, reg);
    }

    public static Client authClient(String email, String passString) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(host, port);
        System.out.println("Connected.................");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        SocketInscription n = new SocketInscription(email, passString);
        oos.writeObject(n);

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return (Client) ois.readObject();
		/*DAOClient daoClient=new DAOClient();
return daoClient.Authentification(email, passString);*/

    }

    public static void rempliTable(DefaultTableModel model, Client c) {
        for (Diagnostic diag : c.getDiagnostics()) {
            model.addRow(new String[]{diag.getDate().toString(), "" + diag.get_possi_presence()});
            System.out.println(diag);
        }

    }

    public static void Telecharger_doc(String ext, Client c, int idr) {
        Document document = new Document();
        System.out.println(c.getDiagnostics().get(idr - 1));
        try {
            PdfWriter.getInstance(document, new FileOutputStream("fich." + ext));
        } catch (FileNotFoundException | DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        font.setSize(40);
        font.setStyle(Font.BOLD);
        font.setColor(BaseColor.GRAY);
        Chunk chunk = new Chunk("Diagnostic", font);

        try {
            document.add(chunk);

            document.add(new Paragraph("\n" + c.getDiagnostics().get(idr - 1).getDate().toString()));
            // Informations de client

            font.setSize(15);
            font.setStyle(Font.BOLD);
            font.setColor(BaseColor.BLUE);
            document.add(new Chunk("\nInformations du client ", font));
            document.add(new Paragraph(" Nom :" + c.getNom() + "\n Prenom : " + c.getPrenom() + " \n Age : " + c.getage()));
            document.add(new Chunk("\nInformations du diagnostic ", font));
            document.add(new Paragraph("\n Temperature :" + c.getDiagnostics().get(idr - 1).getTemperature() + "\n Region :" + c.getDiagnostics().get(idr - 1).getRegion().getNom_region()));
            font.setSize(10);
            font.setStyle(Font.BOLD);
            font.setColor(BaseColor.LIGHT_GRAY);
            document.add(new Chunk("\nliste des maladies chronique\n ", font));
            StringBuilder symString = new StringBuilder("  ");
            for (Maladie_chronique s : c.getDiagnostics().get(idr - 1).getMaladies()) {
                symString.append("     ").append(s.getNom());
            }
            document.add(new Paragraph(symString.toString()));
            document.add(new Chunk("\nliste de symptom\n ", font));
            symString = new StringBuilder("  ");
            for (Symptoms s : c.getDiagnostics().get(idr - 1).getMysymtoms()) {
                symString.append("     ").append(s.designation);
            }
            document.add(new Paragraph(symString.toString()));
            font.setSize(15);
            font.setStyle(Font.BOLD);
            font.setColor(BaseColor.BLUE);
            document.add(new Chunk("\n Resultat du diagnostic\n ", font));
            document.add(new Paragraph("\n resultat :" + c.getDiagnostics().get(idr - 1).getResultat()));
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        document.close();
    }


    private static void addTableHeader(PdfPTable table) {
        Stream.of("column header 1", "column header 2", "column header 3")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private static void addRows(PdfPTable table) {
        table.addCell("row 1, col 1");
        table.addCell("row 1, col 2");
        table.addCell("row 1, col 3");
    }
}

	

