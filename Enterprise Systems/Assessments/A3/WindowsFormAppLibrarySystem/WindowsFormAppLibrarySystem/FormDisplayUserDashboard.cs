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


/*
 * === ASSUMPTIONS ===
 * 1. Search criteria can be displayed as toggled buttons to switch between different criteria.
 * 2. For searching criteria that have string input for other tables but interger for book table, 
 *      they will be searched correctly in code,
 *      but still displayed with their number when displaying all matched books.
 * 3. All book data can just be displayed with the data grid and doesn't need any special formatiing or styling.
*/


namespace WindowsFormAppLibrarySystem
{
    public partial class FormDisplayUserDashboard : Form
    {
        // username
        string username = "";

        public FormDisplayUserDashboard(string name)
        {
            InitializeComponent();
            username = name;
            label2.Text = "Welcome " + username;
        }


        private void BookServicesBtn(object sender, EventArgs e)
        {
            // show user book services
            FormDisplayUserBookServices userBookServices = new FormDisplayUserBookServices(username);
            userBookServices.Visible = true;

            // hide dashboard
            this.Visible = false;
        }
        private void BookSearchBtn(object sender, EventArgs e)
        {
            // show user book search
            FormDisplayUserBookSearch userBookSearch = new FormDisplayUserBookSearch(username);
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
    }
}
