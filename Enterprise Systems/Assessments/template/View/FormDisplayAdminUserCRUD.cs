using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace View
{
    public partial class FormDisplayAdminUserCRUD : Form
    {
        public FormDisplayAdminUserCRUD(string name)
        {
            InitializeComponent();
            label2.Text = name;
        }

        private void button9_Click(object sender, EventArgs e)
        {

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
        private void LogoutBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you'd like to logout?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // show login window
                FormDisplayLogin loginWindow = new FormDisplayLogin();
                loginWindow.Visible = true;

                // hide current window
                this.Visible = false;
            }
        }
        private void BackToDashboardBtn(object sender, EventArgs e)
        {
            // show dahsboard window
            FormDisplayAdminDashboard dashboardWindow = new FormDisplayAdminDashboard(label2.Text);
            dashboardWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
    }
}
