import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 * 
	 * @return
	 * 
	 */
	private void loadOwnersFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Owners.txt"));
			CORS.ownerList = (ArrayList<Owner>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
			// JOptionPane.showMessageDialog(null, "Owners successfully loaded from
			// file\n");
		} catch (Exception e) {
			System.out.println("Error loading Owners.txt file");
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Error loading the Owners file. System closing\n");
		}
	}

	private void loadTenantsFile() {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("files/Tenants.txt"));
			CORS.tenantList = (ArrayList<Tenant>) is.readObject();// note the typecast
			is.close(); // Close the Input Stream
//			JOptionPane.showMessageDialog(null, "Tenants successfully loaded from file\n");
		} catch (Exception e) {
			System.out.println("Error loading Tenants.txt file");
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Error loading the Tenants file. System closing\n");
		}
	}

	private void init() {
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		oRegB = new javax.swing.JButton();
		oLoginB = new javax.swing.JButton();
		tRegB = new javax.swing.JButton();
		tLoginB = new javax.swing.JButton();
		aLoginB = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(102, 153, 0));
		jLabel1.setText("C P R M S");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel3.setText("Owner Registration:");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel4.setText("Owner Log In:");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel5.setText("Tenent Sign Up:");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel6.setText("Log In as Tenent? ");

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13));
		jLabel7.setText("Log In as Admin? ");

		oRegB.setText("Sign Up");
		oRegB.setBackground(new java.awt.Color(51, 204, 255));

		oLoginB.setText("Log In");
		oLoginB.setBackground(new java.awt.Color(0, 204, 05));

		tRegB.setText("Sign Up");
		tRegB.setBackground(new java.awt.Color(51, 204, 255));

		tLoginB.setText("Log In");
		tLoginB.setBackground(new java.awt.Color(0, 204, 05));

		aLoginB.setText("Log In");
		aLoginB.setBackground(new java.awt.Color(0, 204, 05));

		jButton1.setText("Quit");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(34, 34, 34)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel7)
								.addComponent(jButton1))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(tLoginB).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(oRegB).addComponent(oLoginB).addComponent(tRegB))
										.addComponent(aLoginB).addGap(0, 0, Short.MAX_VALUE))))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

										.addGroup(layout.createSequentialGroup().addGap(120, 120, 120).addComponent(
												jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 0, Short.MAX_VALUE)))

				.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(oRegB))
								.addGap(34, 34, 34)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel4).addComponent(oLoginB))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(tRegB).addComponent(jLabel5))
								.addGap(23, 23, 23)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tLoginB))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(aLoginB))
								.addGap(9, 9, 9).addComponent(jButton1))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(10, 10, Short.MAX_VALUE).addContainerGap()));
		this.setLocation(500, 200);
		pack();
	}

	void loginAdminButtonActionListener(java.awt.event.ActionListener listenLoginB) {
		aLoginB.addActionListener(listenLoginB);

	}

	void registerOwnerButtonActionListener(java.awt.event.ActionListener listenRegB) {
		oRegB.addActionListener(listenRegB);

	}

	void loginOwnerButtonActionListener(java.awt.event.ActionListener listenLoginB) {// GEN-FIRST:event_oLoginBActionPerformed
		oLoginB.addActionListener(listenLoginB);

	}

	void registerTenantButtonActionListener(java.awt.event.ActionListener listenRegB) {
		tRegB.addActionListener(listenRegB);
	}

	void loginTenantButtonActionListener(java.awt.event.ActionListener listenLoginB) {
		tLoginB.addActionListener(listenLoginB);
	}// GEN-LAST:event_tRegBActionPerformed

	private void tLoginBActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tLoginBActionPerformed
		// TODO add your handling code here:
//		Login obj = new Login();
//		obj.setVisible(true);
//		obj.str = "ueserid";
//		setVisible(false);

	}// GEN-LAST:event_tLoginBActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		close();

	}// GEN-LAST:event_jButton1ActionPerformed

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JButton oLoginB;
	private javax.swing.JButton oRegB;
	private javax.swing.JButton tLoginB;
	private javax.swing.JButton tRegB;
	private javax.swing.JButton aLoginB;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		init();
		loadOwnersFile();
		loadTenantsFile();
	}

}
