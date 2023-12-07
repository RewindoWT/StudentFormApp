package Form;

import Models.Ogrenci;
import Services.DosyaServis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OgrenciKayitForm extends JFrame{
    private JTextField ogrenciNoField;
    private JTextField ogrenciAdField;
    private JTextField ogrenciSoyadField;
    private JButton kaydetButton;
    private JPanel OgrenciKayitForm;
    private JRadioButton erkekRadioButton;
    private JRadioButton kadınRadioButton;
    private JComboBox bolumComboBox;
    private JComboBox derslerComboBox;
    private JButton gosterButton;
    DosyaServis dosyaServis = new DosyaServis();

    Ogrenci ogrenci = new Ogrenci();
    String ogrenciNo = ogrenci.OgrenciNo;
    String ogrenciAd = ogrenci.OgrenciAd;
    String ogrenciSoyad = ogrenci.OgrenciSoyad;
    public OgrenciKayitForm() {

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenciNo = ogrenciNoField.getText();
                ogrenciAd = ogrenciAdField.getText();
                ogrenciSoyad = ogrenciSoyadField.getText();
                String ogrenciBolum = (String) bolumComboBox.getSelectedItem();
                String ogrenciDers = (String) derslerComboBox.getSelectedItem();


                System.out.println("Öğrenci Bilgileri:");
                System.out.println("Öğrenci No: " + ogrenciNo);
                System.out.println("Öğrenci Ad: " + ogrenciAd);
                System.out.println("Öğrenci Soyad: " + ogrenciSoyad);
                System.out.println("Öğrenci Ders: " + ogrenciDers);
                System.out.println();


                dosyaServis.dosyayaKaydetOgrenci(ogrenciNo, ogrenciAd, ogrenciSoyad, ogrenciDers,ogrenciBolum);
            }
        });

        gosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                derslerComboBox.removeAllItems();

                List<String> dersList = dosyaServis.getDersIsimleri("dersler.txt");
                if (dersList != null) {
                    for (String ders : dersList) {
                        derslerComboBox.addItem(ders);
                    }
                } else {
                    System.out.println("Ders listesi bulunamadı.");
                }
            }
        });
        setContentPane(OgrenciKayitForm);
        setTitle("Ögrenci Kayıt Formu");
        setMinimumSize(new Dimension(500,300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args){
        OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
    }
}
