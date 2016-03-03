package ProgettoAzzardo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

public class ProgettoAzzardoGrafica {
	Image[] immagini = new Image[7];
	Label lblSimbolo1, lblSimbolo2, lblSimbolo3;
	
	int n = 0;

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
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

		shell.setSize(650, 500);
		shell.setText("SWT Application");

		// diamo ad ogni spazio del vettore un'immagine

		immagini[0] = new Image(null, "immagini/gatto1.jpg");
		immagini[1] = new Image(null, "immagini/gatto2.jpg");
		immagini[2] = new Image(null, "immagini/gatto3.png");
		immagini[3] = new Image(null, "immagini/gatto4.jpg");
		immagini[4] = new Image(null, "immagini/reginato.jpg");
		immagini[5] = new Image(null, "immagini/reginatocapelli.jpg");
		immagini[6] = new Image(null, "immagini/verde.jpg");

		// fine dichiarazione immagine
		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReset.setBounds(30, 351, 75, 25);
		btnReset.setText("Reset");

		Button btnBetMax = new Button(shell, SWT.NONE);
		btnBetMax.setBounds(141, 351, 75, 25);
		btnBetMax.setText("Bet max");

		Button btnBetOne = new Button(shell, SWT.NONE);
		btnBetOne.setBounds(285, 351, 75, 25);
		btnBetOne.setText("Bet One");

		Label lblSimbolo2 = new Label(shell, SWT.BORDER);
		lblSimbolo2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo2.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo2.setBounds(257, 90, 160, 153);

		Label lblSimbolo1 = new Label(shell, SWT.BORDER);
		lblSimbolo1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo1.setBounds(58, 90, 160, 153);

		Label lblSimbolo3 = new Label(shell, SWT.BORDER);
		lblSimbolo3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo3.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo3.setBounds(451, 90, 160, 153);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		lblNewLabel.setBounds(30, 10, 497, 54);
		lblNewLabel.setText("NARDI'S SLOT MACHINE");

		Label lblSpin = new Label(shell, SWT.BORDER);

		lblSpin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lblSpin.setEnabled(false);
				Thread thread = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {
							n = i;
							System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
										//ora le immagini cambiano
									lblSimbolo1.setImage(immagini[n]);
									
								}
							});
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				};
				
				thread.start();
				
				
				Thread thread2 = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {
							n = i;
							System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
										//ora le immagini cambiano
									
									lblSimbolo2.setImage(immagini[n]);
									
								}
							});
							try {
								Thread.sleep(50);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				};
				thread2.start();
				//p.CambioImmagine(100);
				
				
				Thread thread3 = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {
							n = i;
							System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
										//ora le immagini cambiano
									
									lblSimbolo3.setImage(immagini[n]);
									
								}
							});
							try {
								Thread.sleep(60);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				};
				thread3.start();
				
				//lblSpin.set(true);
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
		lblSpin.setBounds(464, 343, 88, 32);
		lblSpin.setText("SPIN");
		
		

	}
	
	public Image[] getImmagini() {
		return immagini;
	}

	public void setImmagini(Image[] immagini) {
		this.immagini = immagini;
	}

}
