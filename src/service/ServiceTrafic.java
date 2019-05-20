/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.IGenericCrud;
import entities.StatueTrafic;
import entities.Trafic;
import entities.TypeTrafic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connection.MYSQLConnection;

/**
 *
 * @author Adly
 */
public class ServiceTrafic implements IGenericCrud<Trafic> {

    static Connection con = MYSQLConnection.conncet();
    static PreparedStatement ps;

    @Override
    public void add(Trafic t) {
        try {
            ps = con.prepareStatement("insert into trafic (description,type,statue,datedebut,datefin,ligne_id) values(?,?,?,?,?,?)");
            ps.setString(1, t.getDescription());
            ps.setString(2, t.getType().toString());
            ps.setString(3, t.getStatue().toString());
            ps.setString(4, t.getDateDebut());
            ps.setString(5, t.getDateFin());
            ps.setInt(6, t.getIdLigne());
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Trafic ajouter avec success");
            } else {
                System.out.println("Operation non aboutie");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Trafic t) {

        try {
            ps = con.prepareStatement("delete from trafic where id=?");
            ps.setInt(1, t.getId());
            System.out.println(t.getId() + " ");
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Suppression avec success");
            } else {
                System.out.println("id de trafic non existante");
            }
        } catch (Exception e) {
            System.out.println("Operation non aboutie");
        }

    }

    @Override
    public void display(ArrayList<Trafic> ls) {
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select * from trafic");
            while (res.next()) {

                ls.add(new Trafic(res.getInt(1), TypeTrafic.valueOf(res.getString(3)), StatueTrafic.valueOf(res.getString(4)), res.getString(2), res.getString(5), res.getString(6), res.getInt(7)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Trafic t, String s, String b, int y) {
        try {

            String req = "UPDATE`trafic` SET statue=?,type=?, ligne_id=?  WHERE id=? ";
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(2, s);
            ps.setString(1, b);
            ps.setInt(3, y);
            ps.setInt(4, t.getId());
            System.out.println("UPDATE`trafic` SET statue=" + s + ",type=?" + b + ",id_ligne=" + y + "WHERE id=" + t.getId());
            System.out.println(con);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Trafic findTraficByTraficStatue(String statue) {
        Trafic t = null;

        try {
            ps = con.prepareStatement("select * from trafic where staute=?");
            ps.setString(1, statue);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                t = new Trafic(
                        res.getInt(1),
                        TypeTrafic.valueOf(res.getString(3)),
                        StatueTrafic.valueOf(res.getString(2)),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getInt(7));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return t;
    }

    @Override
    public Trafic getTrafic(Trafic t, int id) {

        try {
            ps = con.prepareStatement("select * from trafic where id=?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                t = new Trafic(
                        res.getInt(1),
                        TypeTrafic.valueOf(res.getString(3)),
                        StatueTrafic.valueOf(res.getString(2)),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getInt(7));
                return t;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }

    public int traficmain() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT count(*) FROM trafic WHERE type like 'maintenance'");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                ret = res.getInt(1);
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }

    public int trafiFN() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT count(*) FROM trafic WHERE type like 'factureNaturels'");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                ret = res.getInt(1);
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }

    public int traficMS() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT count(*) FROM trafic WHERE type like 'mesuresDeSecurite'");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                ret = res.getInt(1);
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }

    public int traficComplet() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT count(*) FROM trafic WHERE type like 'complet'");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                ret = res.getInt(1);
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }

    public int traficPartiel() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT count(*) FROM trafic WHERE statue like 'partiel'");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                ret = res.getInt(1);
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }
        public int traficParYear() {
        int ret = 0;
        try {
            ps = con.prepareStatement("SELECT dateDebut FROM trafic");
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                String s = null;
                s = res.getString(1);
              String  ys = s.substring(s.length() - 4);
                ret = Integer.parseInt(ys);
                
                return ret;

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return ret;
    }
    
}
