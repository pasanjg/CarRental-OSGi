package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import carservice.CarService;

public class GUIBuilder {
	
	public static void ReserveCar(ArrayList<String> CarList, CarService carService) {
		JFrame frame = new JFrame("Reserved Cars");
		frame.getContentPane().setLayout(new GridLayout(1, 0,50,50));
		JPanel mainPanel = new JPanel(new GridLayout(1, 0,0,0));
		final JButton btnAdd = new JButton("New Reservation");
		mainPanel.setSize(400,400);
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Welcome to Rent a Car", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,24), Color.BLACK));
		
		JPanel detailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
	//	detailPanel.setSize(390,390);
		detailPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Reserved Cars:"));
		
		JLabel tableLable = new JLabel("to remove a reservation click on  the relative table row ", null, SwingConstants.LEFT);
		JButton b=new JButton("Check"); 	String col[] = {"Reserved Cars"};
		DefaultTableModel model = new DefaultTableModel( null,col );
		JTable table = new JTable(model);
		
        table.setPreferredScrollableViewportSize(new Dimension(300,60));
        table.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        //add(js);
		
		for (int i = 0; i < (CarList.size() ); i++) {
		      model.addRow(new Object[] { String.valueOf(CarList.get(i)),
		          String.valueOf(CarList.get( i) ) });
		    }
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
               //tableLable.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
               int opcion = JOptionPane.showConfirmDialog(null, "Are you sure, do you want to remove reservation?", "Remove Reservation", JOptionPane.YES_NO_OPTION);
               if (opcion == 0) { 
            	   carService.removeReservation(table.getValueAt(table.getSelectedRow(), 0).toString());
               } else {
               }


            }
        });
		
		 btnAdd.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
        		GUIBuilder.addReservation(carService);
           }
       });
		//.setBorder( BorderFactory.createEmptyBorder(-5, 0, -5, 0) );
		detailPanel.add(tableLable);
		detailPanel.add(js);
		detailPanel.add(btnAdd);
		
		mainPanel.add(detailPanel);
		
		frame.add(mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		

	}

	protected static void addReservation(CarService carService) {

		ArrayList<String> CarList = carService.displayAvailableCars();

		JFrame frame = new JFrame("Make New Reservation");
		frame.getContentPane().setLayout(new GridLayout(1, 0,50,50));
		JPanel mainPanel = new JPanel(new GridLayout(1, 0,0,0));
		mainPanel.setSize(400,400);
		mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Welcome to Rent a Car", TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,24), Color.BLACK));
		
		JPanel detailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
	//	detailPanel.setSize(390,390);
		detailPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Available Cars:"));
		
		JLabel tableLable = new JLabel("to reserve a Car click on  the relative table row ", null, SwingConstants.LEFT);
		JButton b=new JButton("Check"); 	String col[] = {"Available Cars"};
		DefaultTableModel model = new DefaultTableModel( null,col );
		JTable table = new JTable(model);
		
        table.setPreferredScrollableViewportSize(new Dimension(300,60));
        table.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        //add(js);
		
		for (int i = 0; i < (CarList.size() ); i++) {
		      model.addRow(new Object[] { String.valueOf(CarList.get(i)),
		          String.valueOf(CarList.get( i) ) });
		    }
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
               //tableLable.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
               int opcion = JOptionPane.showConfirmDialog(null, "Are you sure, do you want to reserve the Car?", "Reserve Car", JOptionPane.YES_NO_OPTION);
               if (opcion == 0) { 
            	   carService.reserveCar(table.getValueAt(table.getSelectedRow(), 0).toString());
               } else {
               }


            }
        });
		
		//.setBorder( BorderFactory.createEmptyBorder(-5, 0, -5, 0) );
		detailPanel.add(tableLable);
		detailPanel.add(js);
		
		mainPanel.add(detailPanel);
		
		frame.add(mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
	}

}
