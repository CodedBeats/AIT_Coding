using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Controller;

namespace WindowsFormAppLibrarySystem
{
    public partial class FormDisplayAdminCatCRUD : Form
    {
        string username;

        CategoryController categoryController = new CategoryController();

        public FormDisplayAdminCatCRUD(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;

            // load categories
            dataGridView1.DataSource = categoryController.GetAllCategories();
        }


        private void CreateBtn(object sender, EventArgs e)
        {
            categoryController.CreateCategory(textBox1.Text);
            // load categories
            dataGridView1.DataSource = categoryController.GetAllCategories();
        }


        private void UpdateBtn(object sender, EventArgs e)
        {
            categoryController.UpdateCategory(Int32.Parse(textBox2.Text), textBox4.Text);
            // load categories
            dataGridView1.DataSource = categoryController.GetAllCategories();
        }


        private void DeleteBtn(object sender, EventArgs e)
        {
            categoryController.DeleteCategory(Int32.Parse(textBox3.Text));
            // load categories
            dataGridView1.DataSource = categoryController.GetAllCategories();
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
