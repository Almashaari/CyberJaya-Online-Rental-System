import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TenantLoginGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -153318981893740517L;
	String str = "";
	String role = "";

	/**
	 * Creates new form Login
	 */
	public TenantLoginGUI() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		usernameT = new javax.swing.JTextField();
		Username = new javax.swing.JLabel();
		ownerPassword = new javax.swing.JLabel();
		ownerPasswordT = new javax.swing.JTextField();
		login = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jButtonBack = new javax.swing.JButton();

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		usernameT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				usernameTActionPerformed(evt);
			}
		});

		Username.setText("Username");

		ownerPassword.setText("Password");

		login.setText("Log In");
		login.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		jLabel1.setText("Log In or Sign up?");

		jButtonBack.setText("Back");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(54, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(ownerPassword).addComponent(Username)))
				.addContainerGap(70, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addComponent(jButtonBack).addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(usernameT, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(ownerPasswordT, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(login)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Username).addComponent(usernameT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ownerPassword).addComponent(ownerPasswordT,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonBack).addComponent(login))
						.addGap(58, 58, 58)));
		this.setLocation(500, 200);
		this.setTitle("Tenant Login");
		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void usernameTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usernameTActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_usernameTActionPerformed

	@SuppressWarnings("unchecked")
	void loginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginActionPerformed
		// TODO add your handling code here:
		String data = "";
		data = usernameT.getText();
		String pass = "";
		pass = ownerPasswordT.getText();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("files/Tenants.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Tenant> classes;
		// read the list from the stream object
		try {
			classes = (ArrayList<Tenant>) in.readObject();

			for (Tenant line : classes) {
//				System.out.println(line.getName() + "\nTenant id:" + line.getTenantID() + "\nTenant username:"
//						+ line.getUsername() + "\nPassword:" + line.getPassword() + "\n");
				if (data.equals(line.getUsername()) && pass.equals(line.getPassword())) {

					TenantHomeScreenGUI thsGUI = new TenantHomeScreenGUI();
					thsGUI.setVisible(true);

				}

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// close the stream

	}

	void backButtonActionListener(java.awt.event.ActionListener evt) {
		// TODO add your handling code here:
		jButtonBack.addActionListener(evt);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel Username;
	private javax.swing.JButton jButtonBack;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JButton login;
	private javax.swing.JTextField ownerPasswordT;
	private javax.swing.JLabel ownerPassword;
	private javax.swing.JTextField usernameT;
	// End of variables declaration//GEN-END:variables
}
