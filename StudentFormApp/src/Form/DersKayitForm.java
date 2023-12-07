package Form;

import Models.Ders;
import Services.DosyaServis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DersKayitForm extends JFrame{
    private JTextField dersKoduField;
    private JTextField dersAdField;
    private JTextField dersDonemField;
    private JComboBox HocaListesi;
    private JButton kaydetButton;
    private JPanel DersKayitForm;
    Ders ders = new Ders();
    String dersKod = ders.DersKod;
    String dersAd = ders.DersAd;
    String dersDonem = ders.DersDonem;

    DosyaServis dosyaServis = new DosyaServis();
    public DersKayitForm() {
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dersKod = dersKoduField.getText();
                dersAd = dersAdField.getText();
                dersDonem = dersDonemField.getText();
                String hocaListe = (String) HocaListesi.getSelectedItem();

                System.out.println("Ders Bilgileri:");
                System.out.println("Ders Kodu: " + dersKod);
                System.out.println("Ders Adı: " + dersAd);
                System.out.println("Ders Dönemi: " + dersDonem);
                System.out.println("Seçilen Hoca: " + hocaListe);
                System.out.println();

                dosyaServis.dosyayaKaydetDers(dersKod, dersAd, dersDonem, hocaListe);
            }
        });

        setContentPane(DersKayitForm);
        setTitle("Ders Kayit Formu");
        setMinimumSize(new Dimension(500,300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        DersKayitForm dersKayitForm = new DersKayitForm();
    }
}
