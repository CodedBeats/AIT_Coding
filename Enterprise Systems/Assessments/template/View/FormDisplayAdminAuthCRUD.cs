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
using System.Xml.Linq;

namespace View
{
    public partial class FormDisplayAdminAuthCRUD : Form
    {
        AuthorController authorController = new AuthorController();

        string username;

        public FormDisplayAdminAuthCRUD(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;

            // load author table
            dataGridView1.DataSource = authorController.GetAllAuthors();
        }


        private void CreateBtn(object sender, EventArgs e)
        {
            authorController.CreateAuthor(textBox1.Text);
            // reload author table
            dataGridView1.DataSource = authorController.GetAllAuthors();
        }


        private void UpdateBtn(object sender, EventArgs e)
        {
            authorController.UpdateAuthor(textBox4.Text, Int32.Parse(textBox2.Text));
            // reload author table
            dataGridView1.DataSource = authorController.GetAllAuthors();
        }


        private void DeleteBtn(object sender, EventArgs e)
        {
            authorController.DeleteAuthor(Int32.Parse(textBox3.Text));
            // reload author table
            dataGridView1.DataSource = authorController.GetAllAuthors();
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
