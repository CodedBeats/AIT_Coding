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
    public partial class FormDisplayUserBookServices : Form
    {
        // connect to the Controller
        BookController bookController = new BookController();


        public FormDisplayUserBookServices(string name)
        {
            InitializeComponent();
            label2.Text = name;
        }

        private void GetAllBooksBtn(object sender, EventArgs e)
        {
            List<BookDTO> bookDTOs = bookController.GetAllBooks();

            // display the data
            dataGridView1.DataSource = bookDTOs;
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
            FormDisplayUserDashboard dashboardWindow = new FormDisplayUserDashboard(label2.Text);
            dashboardWindow.Visible = true;

            // hide current window
            this.Visible = false;
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
    }
}
