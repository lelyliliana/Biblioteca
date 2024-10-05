package com.mycompany.formulario;

import static com.sun.source.util.DocTrees.instance;
import static com.sun.source.util.JavacTask.instance;
import static com.sun.source.util.Trees.instance;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

/**
 * @author leli
 */
public class Main extends javax.swing.JFrame {

    public static Main instance = null; // Declara la variable estática al nivel de la clase

    private JMenuBar menuBar;
    private JMenu menuArchivo, menuEditar, menuAyuda;
    private JMenuItem itemNuevo, itemEditar, itemEliminar, itemSalir;
    private JButton btnNuevo, btnEditar, btnEliminar;

    
    public Main() {
        
        initComponents();
        
        setTitle("LibraLuz - Gestión de Biblioteca");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));  // Ajusta el layout para espaciar los botones
        
        ImageIcon iconNuevo = new ImageIcon(getClass().getResource("/images/nuevo.png"));
        btnNuevo = new JButton("Nuevo Libro", iconNuevo);
        btnNuevo.setBackground(Color.WHITE);  // Establece el color de fondo
        btnNuevo.setForeground(Color.BLACK);  // Cambia el color del texto
        btnNuevo.setFont(new Font("Arial", Font.BOLD, 17));  // Cambia la fuente y el tamaño del texto
        btnNuevo.setPreferredSize(new Dimension(200, 50));  // Ajusta el tamaño del botón

        
        ImageIcon iconEditar = new ImageIcon(getClass().getResource("/images/editar.png"));
        btnEditar = new JButton("Editar Libro", iconEditar);
        btnEditar.setBackground(Color.WHITE);  // Establece el color de fondo
        btnEditar.setForeground(Color.BLACK);  // Cambia el color del texto
        btnEditar.setFont(new Font("Arial", Font.BOLD, 17));  // Cambia la fuente y el tamaño del texto
        btnEditar.setPreferredSize(new Dimension(200, 50));  // Ajusta el tamaño del botón
        
        ImageIcon iconEliminar = new ImageIcon(getClass().getResource("/images/eliminar.png"));
        btnEliminar = new JButton("Eliminar Libro", iconEliminar);
        btnEliminar.setBackground(Color.WHITE);  // Establece el color de fondo
        btnEliminar.setForeground(Color.BLACK);  // Cambia el color del texto
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 17));  // Cambia la fuente y el tamaño del texto
        btnEliminar.setPreferredSize(new Dimension(200, 50));  // Ajusta el tamaño del botón
        
        add(btnNuevo);
        add(btnEditar);
        add(btnEliminar);
        
        setVisible(true);
        
        // Menú Bar
        menuBar = new JMenuBar();

        // Menú Archivo
        menuArchivo = new JMenu("Archivo");
        itemNuevo = new JMenuItem("Nuevo Libro");
        itemEditar = new JMenuItem("Editar Libro");
        itemEliminar = new JMenuItem("Eliminar Libro");
        itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemEditar);
        menuArchivo.add(itemEliminar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        // Agregar menús a la barra de menú
        menuBar.add(menuArchivo);

        // Configurar la barra de menú en la ventana
        setJMenuBar(menuBar);
        
        btnNuevo.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                NuevoLibroForm dialogoNuevoLibro = new NuevoLibroForm(Main.this);
                dialogoNuevoLibro.setVisible(true);
    }
});
        
        // Suponiendo que btnEditar es tu JButton para editar libros
btnEditar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int libroId = obtenerIdDelLibroSeleccionado(); // Usa el mismo método que arriba o uno diferente si es necesario
        EditarLibroForm editarLibroForm = new EditarLibroForm(Main.this, libroId);
        editarLibroForm.setVisible(true);
    }
    
    private int obtenerIdDelLibroSeleccionado() {
        // La misma implementación que arriba o ajusta según sea necesario
        return 1; // Retorna el ID del libro seleccionado
    }
});

// Aquí es donde se configura el ActionListener para el botón btnEliminar
    btnEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            EliminarLibroForm eliminarLibroForm = new EliminarLibroForm(Main.this);
            eliminarLibroForm.setVisible(true);
        }
    });

    // Y aquí es donde se configura el ActionListener para el ítem de menú itemEliminar
    itemEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            EliminarLibroForm eliminarLibroForm = new EliminarLibroForm(Main.this);
            eliminarLibroForm.setVisible(true);
        }
    });

        // Configurar ActionListener para el ítem de menú itemNuevo
    itemNuevo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            NuevoLibroForm dialogoNuevoLibro = new NuevoLibroForm(Main.this);
            dialogoNuevoLibro.setVisible(true);
        }
    });
    
    itemEditar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Suponiendo que tienes una forma de obtener el ID del libro seleccionado para editar.
        int libroId = obtenerIdDelLibroSeleccionado();
        EditarLibroForm editarLibroForm = new EditarLibroForm(Main.this, libroId);
        editarLibroForm.setVisible(true);
    }

            private int obtenerIdDelLibroSeleccionado() {
            // Implementa la lógica para obtener el ID del libro seleccionado aquí
        // De momento, esto es solo un placeholder
        return 1; // Retorna el ID del libro seleccionado
            
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea u muestra la venta principal */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar SplashScreen
            SplashScreen splash = new SplashScreen();

            // Configurar un Timer para cerrar SplashScreen y mostrar Main después de 3 segundos
            new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Solo cerrar SplashScreen aquí. No se necesita crear Main.
                    splash.dispose();
                    
                     // Después de que se cierra el SplashScreen, crear y mostrar Main
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            if (instance == null) {
                                instance = new Main(); // Crear la ventana principal
                                instance.setVisible(true); // Hacerla visible
                            }
                        }
                    });
            }
                }).start(); // Inicia el temporizador
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
