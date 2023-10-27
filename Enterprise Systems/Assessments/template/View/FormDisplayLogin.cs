using Controller;
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
            bool loginValidated = userController.ValidateLogin(textBox1.Text, textBox2.Text);

            // check for invalid login
            if (!loginValidated)
            {
                // display unvalidated
                label4.Visible = true;
            }
            // successful login
            else
            {
                // show user dashboard
                FormDisplayDashboard formDisplayDashboard = new FormDisplayDashboard();
                formDisplayDashboard.Visible = true;
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
