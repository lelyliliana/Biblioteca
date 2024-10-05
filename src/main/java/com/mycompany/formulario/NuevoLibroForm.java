package com.mycompany.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NuevoLibroForm extends JFrame {

    private Main mainFrame;
    private ListaLibros listaLibros;
    private DefaultListModel<String> listModel;
    private JList<String> jListLibros;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditorial;
    private JTextField txtAnio;
    private JTextArea txtSinopsis;
    private JComboBox<String> comboGenero;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelCampos;
    private JPanel panelBotones;

    public NuevoLibroForm(Main mainFrame) {
        this.mainFrame = mainFrame;
        this.listaLibros = new ListaLibros();
        this.listModel = new DefaultListModel<>();
        this.jListLibros = new JList<>(listModel);

        initComponents();
        cargarLibrosExistentes();
        setLocationRelativeTo(mainFrame);
    }

    private void initComponents() {
        setTitle("Nuevo Libro");
        setSize(500, 600); // Ajusta el tamaño del formulario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para la lista de libros
        JScrollPane scrollPane = new JScrollPane(jListLibros);
        add(scrollPane, BorderLayout.NORTH);

        // Panel central para los campos de entrada
        panelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Título");
        txtTitulo = new JTextField();

        JLabel lblAutor = new JLabel("Autor");
        txtAutor = new JTextField();

        JLabel lblEditorial = new JLabel("Editorial");
        txtEditorial = new JTextField();

        JLabel lblAnio = new JLabel("Año de publicación");
        txtAnio = new JTextField();

        JLabel lblGenero = new JLabel("Género");
        comboGenero = new JComboBox<>(new String[]{
            "Ficción", "No Ficción", "Educación", "Misterio", "Ciencia Ficción", 
            "Fantasía", "Biografía", "Historia", "Poesía", "Otro"
        });
        comboGenero.addItem("Nuevo Género");

        JLabel lblSinopsis = new JLabel("Sinopsis");
        txtSinopsis = new JTextArea(5, 20);
        txtSinopsis.setLineWrap(true);  // Permitir el ajuste de línea
        txtSinopsis.setWrapStyleWord(true);  // Ajustar línea por palabra completa
        JScrollPane scrollSinopsis = new JScrollPane(txtSinopsis);

        panelCampos.add(lblTitulo);
        panelCampos.add(txtTitulo);
        panelCampos.add(lblAutor);
        panelCampos.add(txtAutor);
        panelCampos.add(lblEditorial);
        panelCampos.add(txtEditorial);
        panelCampos.add(lblAnio);
        panelCampos.add(txtAnio);
        panelCampos.add(lblGenero);
        panelCampos.add(comboGenero);
        panelCampos.add(lblSinopsis);
        panelCampos.add(scrollSinopsis);

        add(panelCampos, BorderLayout.CENTER);

        // Panel inferior para los botones
        panelBotones = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarLibro();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoLibroForm.this.dispose();
            }
        });
    }

    private void cargarLibrosExistentes() {
        String sql = "SELECT titulo FROM libros";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                listaLibros.agregarLibro(titulo);
                listModel.addElement(titulo); // Añadir el título al JList
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los libros existentes: " + e.getMessage());
        }
    }

    private void guardarLibro() {
        // Recoge los datos de los campos de texto
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String editorial = txtEditorial.getText();
        String anio = txtAnio.getText();
        String genero = (String) comboGenero.getSelectedItem(); // Obtiene el género seleccionado
        String sinopsis = txtSinopsis.getText();

        if (listaLibros.existeLibro(titulo)) {
            JOptionPane.showMessageDialog(NuevoLibroForm.this, "El libro ya está guardado en la base de datos.");
            return;
        }

        String sql = "INSERT INTO libros (titulo, autor, editorial, anio, genero, sinopsis) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setString(3, editorial);
            pstmt.setString(4, anio);
            pstmt.setString(5, genero);
            pstmt.setString(6, sinopsis);

            pstmt.executeUpdate();
            listaLibros.agregarLibro(titulo);
            listModel.addElement(titulo); // Añadir el título al JList

            JOptionPane.showMessageDialog(NuevoLibroForm.this, "Libro guardado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(NuevoLibroForm.this, "Error al guardar el libro: " + e.getMessage());
        }

        dispose();
    }

    public static void main(String[] args) {
        // Para pruebas, crear una instancia de Main y mostrar el formulario
        Main mainFrame = new Main();
        NuevoLibroForm nuevoLibroForm = new NuevoLibroForm(mainFrame);
        nuevoLibroForm.setVisible(true);
    }
}
