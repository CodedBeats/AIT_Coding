using DTO;
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
    public partial class FormDisplayAdminBookCRUD : Form
    {
        BookController bookController = new BookController();

        string username;


        public FormDisplayAdminBookCRUD(string name)
        {
            InitializeComponent();
            // welcome user
            username = name;
            label2.Text = "Welcome " + username;

            // load book table
            dataGridView1.DataSource = bookController.GetAllBooks();
        }


        private void CreateBtn(object sender, EventArgs e)
        {
            bookController.CreateBook(textBox1.Text, Int32.Parse(textBox5.Text), Int32.Parse(textBox6.Text), textBox7.Text);
            // reload book table
            dataGridView1.DataSource = bookController.GetAllBooks();
        }


        private void UpdateBtn(object sender, EventArgs e)
        {
            bookController.UpdateBook(textBox4.Text, textBox2.Text);
            // reload book table
            dataGridView1.DataSource = bookController.GetAllBooks();
        }


        private void DeleteBtn(object sender, EventArgs e)
        {
            bookController.DeleteBook(textBox3.Text);
            // reload book table
            dataGridView1.DataSource = bookController.GetAllBooks();
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
