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
    public partial class FormDisplayAdminLangCRUD : Form
    {
        LanguageController languageController = new LanguageController();

        string username;

        public FormDisplayAdminLangCRUD(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;

            // load language table
            dataGridView1.DataSource = languageController.GetAllLanguages();
        }


        private void CreateBtn(object sender, EventArgs e)
        {
            languageController.CreateLanguage(textBox1.Text);
            // reload language table
            dataGridView1.DataSource = languageController.GetAllLanguages();
        }


        private void UpdateBtn(object sender, EventArgs e)
        {
            languageController.UpdateLanguage(textBox4.Text, Int32.Parse(textBox2.Text));
            // reload language table
            dataGridView1.DataSource = languageController.GetAllLanguages();
        }


        private void DeleteBtn(object sender, EventArgs e)
        {
            languageController.DeleteLanguage(Int32.Parse(textBox3.Text));
            // reload language table
            dataGridView1.DataSource = languageController.GetAllLanguages();
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
            FormDisplayAdminDashboard dashboardWindow = new FormDisplayAdminDashboard(username);
            dashboardWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
    }
}
