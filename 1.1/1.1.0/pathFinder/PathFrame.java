/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathFinder;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.ListModel;

/**
 *
 * @author Pat
 */
public class PathFrame extends javax.swing.JFrame
{
	private final PathFinder pathFinder;
	private ArrayList<JToggleButton> aspectButtons = new ArrayList<>();

	/**
	 * Creates new form PathFrame
	 * 
	 * @param p
	 */
	public PathFrame(PathFinder p)
	{
		pathFinder = p;

		// Generated initialization
		initComponents();

		// Custom initialization
		customInitComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		textField1 = new java.awt.TextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		goButton = new javax.swing.JButton();
		startAspectChoice = new java.awt.Choice();
		endAspectChoice = new java.awt.Choice();
		minLength = new java.awt.TextField();
		jLabel3 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		aspectsPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		resultsList = new javax.swing.JList();
		clipboardButton = new javax.swing.JButton();

		textField1.setText("textField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Research Helper");

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Start Aspect");

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("End Aspect");

		goButton.setText("Go!");
		goButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				goButtonActionPerformed(evt);
			}
		});

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Minimum Steps");

		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		javax.swing.GroupLayout aspectsPanelLayout = new javax.swing.GroupLayout(aspectsPanel);
		aspectsPanel.setLayout(aspectsPanelLayout);
		aspectsPanelLayout.setHorizontalGroup(aspectsPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 580, Short.MAX_VALUE));
		aspectsPanelLayout.setVerticalGroup(aspectsPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		resultsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(resultsList);

		clipboardButton.setText("Copy To Clipboard");
		clipboardButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				clipboardButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(minLength, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(startAspectChoice, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(endAspectChoice, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(goButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(clipboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, 177,
												Short.MAX_VALUE)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(aspectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(9, 9, 9)
																.addComponent(jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(startAspectChoice,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(34, 34, 34)
																.addComponent(jLabel3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(minLength,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(26, 26, 26)
																.addComponent(jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(endAspectChoice,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(34, 34, 34).addComponent(goButton)
																.addContainerGap(268, Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jSeparator2,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										clipboardButton))
																				.addComponent(
																						aspectsPanel,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jSeparator1,
																						javax.swing.GroupLayout.Alignment.LEADING))
																.addContainerGap()))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void customInitComponents()
	{
		pathFinder.getAllAspectList().forEach((a) -> {
			startAspectChoice.add(a.getName());
			endAspectChoice.add(a.getName());
		});

		ArrayList<Aspect> aspects = pathFinder.getAllAspectList();
		int rowSize = (int) Math.ceil((float) aspects.size() / 8.0);

		GridLayout aspectsLayout = new GridLayout(rowSize, rowSize);
		aspectsPanel.setLayout(aspectsLayout);

		for(Aspect a : aspects)
		{
			ImageIcon icon = new ImageIcon(a.getImage());
			ImageIcon pressedIcon = new ImageIcon(ApplyAlphaToImage(a.getImage()));
			JToggleButton button = new JToggleButton(icon);
			button.setSize(64, 64);
			button.setSelectedIcon(pressedIcon);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setOpaque(false);
			button.setBorder(null);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			button.setToolTipText(a.getName());
			aspectButtons.add(button);
			aspectsPanel.add(button);

			button.addActionListener((java.awt.event.ActionEvent evt) -> {
                            a.toggleEnabled();
                        });
		}
	}

	public BufferedImage ApplyAlphaToImage(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		int[] imagePixels = image.getRGB(0, 0, width, height, null, 0, width);

		for(int i = 0; i < imagePixels.length; i++)
		{
			int rgb = imagePixels[i] & 0x00ffffff;
			int a = (imagePixels[i] >> 24) & 0x000000ff;

			// Divide a by 8
			a >>= 3;

			imagePixels[i] = rgb + (a << 24);
		}
		BufferedImage returnImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		returnImage.setRGB(0, 0, width, height, imagePixels, 0, width);

		return returnImage;
	}

	private void goButtonActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_goButtonActionPerformed
		String startAspectName = startAspectChoice.getSelectedItem();
		String endAspectName = endAspectChoice.getSelectedItem();
		String minLengthString = minLength.getText();
		Aspect startAspect = null;
		Aspect endAspect = null;

		for(Aspect a : pathFinder.getAllAspectList())
		{
			if(a.getName().equals(startAspectName))
				startAspect = a;
			if(a.getName().equals(endAspectName))
				endAspect = a;
		}

		ArrayList<String> resultStrings = new ArrayList<>();
		try
		{
			int minLengthInt = Integer.parseInt(minLengthString);
			ArrayList<Aspect> l = pathFinder.findPath(startAspect, endAspect, minLengthInt);

			if(l != null)
			{
				for(Aspect a : l)
				{
					resultStrings.add(a.getName());
				}
			} else
			{
				resultStrings.add("Could not find path from");
				resultStrings.add("" + startAspectName + " to " + endAspectName + ".");
			}
		}
		// Don't throw exception if they enter bad input, just don't try to find
		// a path!
		catch(NumberFormatException e)
		{
		}

		resultsList.setListData(resultStrings.toArray());
		resultsList.revalidate();
		resultsList.repaint();
	}// GEN-LAST:event_goButtonActionPerformed

	private void clipboardButtonActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_clipboardButtonActionPerformed
		String resultsString = "";
		ListModel resultsModel = resultsList.getModel();

		for(int i = 0; i < resultsModel.getSize(); i++)
		{
			resultsString += resultsModel.getElementAt(i) + "\n";
		}

		StringSelection stringSelection = new StringSelection(resultsString);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}// GEN-LAST:event_clipboardButtonActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel aspectsPanel;
	private javax.swing.JButton clipboardButton;
	private java.awt.Choice endAspectChoice;
	private javax.swing.JButton goButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private java.awt.TextField minLength;
	private javax.swing.JList resultsList;
	private java.awt.Choice startAspectChoice;
	private java.awt.TextField textField1;
	// End of variables declaration//GEN-END:variables
}
