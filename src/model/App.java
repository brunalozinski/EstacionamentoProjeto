package model;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import ui.FrameEstacionamento;

public class App {

	    public static void main(String[] args) {
	        
	        try {
	            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	            }
	            }
	            } catch (UnsupportedLookAndFeelException e) {
	            // handle exception
	            } catch (ClassNotFoundException e) {
	            // handle exception
	            } catch (InstantiationException e) {
	            // handle exception
	            } catch (IllegalAccessException e) {
	            // handle exception
	            }
	      
		FrameEstacionamento tela = new FrameEstacionamento();
		tela.criarTela();
		
	}

}
