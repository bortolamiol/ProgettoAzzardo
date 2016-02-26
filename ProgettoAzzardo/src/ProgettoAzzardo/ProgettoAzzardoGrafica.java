package ProgettoAzzardo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

public class ProgettoAzzardoGrafica {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProgettoAzzardoGrafica window = new ProgettoAzzardoGrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReset.setBounds(10, 205, 75, 25);
		btnReset.setText("Reset");
		
		Button btnBetMax = new Button(shell, SWT.NONE);
		btnBetMax.setBounds(107, 205, 75, 25);
		btnBetMax.setText("Bet max");
		
		Button btnBetOne = new Button(shell, SWT.NONE);
		btnBetOne.setBounds(201, 205, 75, 25);
		btnBetOne.setText("Bet One");
		
		Label lblSimbolo2 = new Label(shell, SWT.BORDER);
		lblSimbolo2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo2.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo2.setBounds(165, 90, 88, 62);
		
		Label lblSimbolo1 = new Label(shell, SWT.BORDER);
		lblSimbolo1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo1.setBounds(58, 90, 88, 62);
		
		Label lblSimbolo3 = new Label(shell, SWT.BORDER);
		lblSimbolo3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo3.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo3.setBounds(272, 90, 88, 62);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		lblNewLabel.setBounds(30, 10, 363, 41);
		lblNewLabel.setText("NARDI'S SLOT MACHINE");
		
		Label lblSpin = new Label(shell, SWT.BORDER);
		lblSpin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
				for(int i=0; i<10; i++){
					String numero = Integer.toString(i);
					lblSimbolo1.setText(numero);
					lblSimbolo2.setText(numero);
					lblSimbolo3.setText(numero);
						try {
						    Thread.sleep(100);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						};
				}
			}
			
			public void mouseUp(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
		});
		lblSpin.setAlignment(SWT.CENTER);
		lblSpin.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
			public void mouseExit(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
			}
		});
		lblSpin.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSpin.setImage(SWTResourceManager.getImage(ProgettoAzzardoGrafica.class, "/ProgettoAzzardo/PlayNow.png"));
		lblSpin.setBounds(319, 202, 88, 32);
		lblSpin.setText("SPIN");

	}
}
