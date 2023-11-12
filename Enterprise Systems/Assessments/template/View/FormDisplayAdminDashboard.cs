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
    public partial class FormDisplayAdminDashboard : Form
    {
        string username;

        public FormDisplayAdminDashboard(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;
        }


        private void LanguageBtn(object sender, EventArgs e)
        {
            // show Language CRUD window
            FormDisplayAdminLangCRUD languageWindow = new FormDisplayAdminLangCRUD(username);
            languageWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
        private void CategoryBtn(object sender, EventArgs e)
        {
            // show Category CRUD window
            FormDisplayAdminCatCRUD categoryWindow = new FormDisplayAdminCatCRUD(username);
            categoryWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
        private void AuthorBtn(object sender, EventArgs e)
        {
            // show Author CRUD window
            FormDisplayAdminAuthCRUD authorWindow = new FormDisplayAdminAuthCRUD(username);
            authorWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
        private void UserBtn(object sender, EventArgs e)
        {
            // show User CRUD window
            FormDisplayAdminUserCRUD userWindow = new FormDisplayAdminUserCRUD(username);
            userWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }
        private void BookBtn(object sender, EventArgs e)
        {
            // show Book CRUD window
            FormDisplayAdminBookCRUD bookWindow = new FormDisplayAdminBookCRUD(username);
            bookWindow.Visible = true;

            // hide current window
            this.Visible = false;
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


        private void button1_Click(object sender, EventArgs e)
        {

        }
        private void label2_Click(object sender, EventArgs e)
        {

        }
        private void label3_Click(object sender, EventArgs e)
        {

        }  
    }
}
