package fstm.projet.model.bo;

import java.io.Serializable;
import java.util.Vector;

public class Socketinter implements Serializable {
    public final double temperaturee;
    public final Region region;
    public Vector<Symptoms> Mysymtoms;

    public Client MyClient;

    public Socketinter(Vector<Symptoms> sympo, Client Clie, double temperature, Region r) {
        Mysymtoms = sympo;
        MyClient = Clie;
        temperaturee = temperature;
        region = r;

    }

    @Override
    public String toString() {
        return "Socketinter{" +
                "Mysymtoms=" + Mysymtoms +
                ", MyClient=" + MyClient +
                '}';
    }


}
