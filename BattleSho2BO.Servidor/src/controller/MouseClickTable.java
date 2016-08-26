package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import network.ConectorDB;

public class MouseClickTable implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void doPop(MouseEvent e){
		
		JTable taula = ((JTable)e.getComponent());
		int row = taula.rowAtPoint(e.getPoint());
		if(row > 0){
			String cadena = (String)taula.getModel().getValueAt(row, 0);
		
			int reply = JOptionPane.showConfirmDialog(taula, "Segur que vols eliminar "+cadena+"?");
			if( reply == JOptionPane.YES_OPTION){
				ConectorDB.deleteUser(cadena);
				ConectorDB.deleteMap(cadena);
				((DefaultTableModel) taula.getModel()).removeRow(row);
				taula.revalidate();
				taula.repaint();
			}
		}
	}


	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if( SwingUtilities.isRightMouseButton(e)){
			doPop(e);
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
