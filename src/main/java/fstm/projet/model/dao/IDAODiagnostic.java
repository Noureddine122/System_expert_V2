package fstm.projet.model.dao;

import fstm.projet.model.bo.Diagnostic;

public interface IDAODiagnostic {
    public void insert(Diagnostic d);

    public void retrive(int id);
}
