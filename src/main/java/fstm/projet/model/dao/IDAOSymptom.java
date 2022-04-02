package fstm.projet.model.dao;

import fstm.projet.model.bo.Symptoms;

import java.util.ArrayList;

public interface IDAOSymptom {
    public void insert(Symptoms s);

    public ArrayList<Symptoms> retreive();
}
