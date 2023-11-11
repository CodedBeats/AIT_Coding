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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

/*
 * === ASSUMPTIONS ===
 * 1. Search criteria can be displayed as toggled buttons to switch between different criteria.
 * 2. For searching criteria that have string input for other tables but interger for book table, 
 *      they will be searched correctly in code,
 *      but still displayed with their number when displaying all matched books.
 * 3. All book data can just be displayed with the data grid and doesn't need any special formatiing or styling.
*/

namespace View
{
    public partial class FormDisplayUserDashboard : Form
    {
        // easy way to set search category state for switching and passing
        private int searchCat = 1;

        // connect to the Controller
        BookController bookController = new BookController();

        public FormDisplayUserDashboard(string name)
        {
            InitializeComponent();
            label2.Text = "Welcome " + name;
        }

        private void BookServicesBtn(object sender, EventArgs e)
        {
            // get username
            string userUsername = label2.Text;
            // show user book search
            FormDisplayUserBookSearch userBookSearch = new FormDisplayUserBookSearch(userUsername);
            userBookSearch.Visible = true;

            // hide dashboard
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



        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
