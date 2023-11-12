using Controller;
using DTO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace View
{
    public partial class FormDisplayLogin : Form
    {
        public FormDisplayLogin()
        {
            InitializeComponent();
            label4.Visible = false;
        }

        private void LoginBtn(object sender, EventArgs e)
        {
            UserController userController = new UserController();
            UserType userType = userController.ValidateLogin(textBox1.Text, textBox2.Text);

            // check for invalid login
            if (userType == UserType.NoUser)
            {
                // display unvalidated
                label4.Visible = true;
            }
            // successful login
            else
            {
                // Handle different user types
                switch (userType)
                {
                    case UserType.Student:
                        // get username
                        string userUsername = textBox1.Text;
                        // show user dashboard
                        FormDisplayUserDashboard userDashboard = new FormDisplayUserDashboard(userUsername);
                        userDashboard.Visible = true;
                        break;

                    case UserType.StaffOrAdmin:
                        // get username
                        string adminUsername = textBox1.Text;
                        // show admin dashboard
                        FormDisplayAdminDashboard adminDashboard = new FormDisplayAdminDashboard("Welcome " + adminUsername);
                        adminDashboard.Visible = true;
                        break;
                }

                // hide login screen
                this.Visible = false;
            }
        }

        private void ExitBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }
    }
}
