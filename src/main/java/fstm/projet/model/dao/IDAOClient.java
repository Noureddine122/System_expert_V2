package fstm.projet.model.dao;

import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Maladie_chronique;
import fstm.projet.model.bo.Region;

import java.util.Vector;

/**
 * @author noureddine
 */
public interface IDAOClient {
    public void insert(Client client);

    public void updateClient(Client c, double temp, Region reg);

    public void updateMaladie(Vector<Maladie_chronique> mal, String email);

    public Boolean finfbyemail(String email);

    public Client Authentification(String email, String password);

}
