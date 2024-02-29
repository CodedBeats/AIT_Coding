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
    public partial class FormDisplayAdminUserCRUD : Form
    {
        UserController userController = new UserController();

        string username;

        public FormDisplayAdminUserCRUD(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;

            // load user database
            dataGridView1.DataSource = userController.GetAllUsers();
        }

        private void CreateBtn(object sender, EventArgs e)
        {
            userController.CreateUser(textBox1.Text, textBox5.Text, Int32.Parse(textBox6.Text));
            // reload user database
            dataGridView1.DataSource = userController.GetAllUsers();
        }


        private void UpdateBtn(object sender, EventArgs e)
        {
            userController.UpdateUser(textBox4.Text, textBox7.Text, Int32.Parse(textBox8.Text), Int32.Parse(textBox2.Text));
            // reload user database
            dataGridView1.DataSource = userController.GetAllUsers();
        }


        private void DeleteBtn(object sender, EventArgs e)
        {
            userController.DeleteUser(Int32.Parse(textBox3.Text));
            // reload user database
            dataGridView1.DataSource = userController.GetAllUsers();
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

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
